package za.co.bbd.softhelp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import za.co.bbd.softhelp.Models.Client;
import za.co.bbd.softhelp.Models.SkillsCategory;
import za.co.bbd.softhelp.services.ClientServices;
import za.co.bbd.softhelp.services.ProjectServices;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EndpointController{

    ClientServices clientService;
    ProjectServices projectService;

    @Autowired
    EndpointController(ClientServices clientService, ProjectServices projectService){
        this.projectService = projectService;
        this.clientService = clientService;
    }

    @GetMapping("/")
    String loginPage(Model model){
        return "login";
    }

    /**
     * [Only called internally] Attempt to sign in user.
     * If the given email exists in DB, redirect the user to the home page.
     * Otherwise, redirect the user to the sign up page.
     * @param email: The email address of the user attempting to log in
     * @param model: The model map to be used for redirecting
     * @return ModelAndView: A new model with the email address as an attribute, and a redirected view
     */
    @PostMapping("/sign-in")
    ModelAndView checkCredentials(String email, ModelMap model){
        try{
            List<Client> user = clientService.getClientByEmail(email);
            model.addAttribute("user", user.get(0));
            return new ModelAndView("redirect:/home", model);
        }catch(IllegalStateException e){
            String skip = "skiiip";
        }

        model.addAttribute("email", email);
        return new ModelAndView("redirect:/sign-up", model);
    }

    @GetMapping("/sign-up")
    String createUser(String email, Model model){
        model.addAttribute("email", email);
        return "sign-up";
    }

    @PostMapping("/home")
    String addNewUser(@ModelAttribute Client client, Model model){
        clientService.addNewUser(client);

        return homePage(client, model);
    }

    @GetMapping("/home")
    String homePage(@ModelAttribute Client client, Model model){
        List<List<String>> projects = new ArrayList<>(0);

        for (SkillsCategory skill : client.getSkillsCategorys()){
            projects = userProjects(client, 5);
        }

        model.addAttribute("user", client);
        model.addAttribute("projects", projects);
        return "home";
    }

    /**
     * Return a list of projects for the user. Each project is contained in a list
     * as follows:
     *
     * [0] - Project description
     * [1] - Project price
     * [2] - Skill required for project
     * [3] - Status of project
     * [4] - Client for project
     * [5] - Assigned worker for project
     * @param client: The user to search projects for
     * @param limit: The number of maximum number of projects to add
     * @return List<List<String>>: The list of projects found
     */
    List<List<String>> userProjects(Client client, int limit){
        List<List<String>> projectsForUser = new ArrayList<>(0);

        for (SkillsCategory skill : client.getSkillsCategorys()){
            getProjectsForSkill(skill.getId(), projectsForUser, limit);
        }

        return projectsForUser;
    }

    /**
     * Given a skill ID and a list to add to, add an open project to the list
     * @param skillID: The skill ID to search for
     * @param projectsForUser: The list to add a project to if it fits the parameters
     *                          for an open project.
     */
    void getProjectsForSkill(Long skillID, List<List<String>> projectsForUser, int limit) {
        List<List<String>> projectsForSkill = projectService.getProjectsBySkillList(skillID);

        for (List<String> project : projectsForSkill) {
            boolean available = project.get(3).equalsIgnoreCase("available"); // project status = available
            boolean noWorker = project.get(5) == null; // project worker is not defined
            boolean spaceAvailable = projectsForUser.size() < limit; // projects to be shown < 5

            if (available && noWorker && spaceAvailable) {
                projectsForUser.add(project);
            }
        }
    }
}