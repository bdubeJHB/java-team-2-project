package za.co.bbd.softhelp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import za.co.bbd.softhelp.Models.Client;
import za.co.bbd.softhelp.Models.ProjectTable;
import za.co.bbd.softhelp.Models.SkillsCategory;
import za.co.bbd.softhelp.Repository.ProjectRepository;
import za.co.bbd.softhelp.auth.GoogleAuthResponse;
import za.co.bbd.softhelp.services.ClientServices;
import za.co.bbd.softhelp.services.ProjectServices;
import za.co.bbd.softhelp.services.SkillServices;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class EndpointController{

    ClientServices clientService;
    ProjectServices projectService;
    SkillServices skillService;

    @Autowired
    EndpointController(ClientServices clientService, ProjectServices projectService, SkillServices skillService){
        this.projectService = projectService;
        this.clientService = clientService;
        this.skillService = skillService;
    }

    /**
     * [Only called internally] Attempt to sign in user.
     * If the given email exists in DB, redirect the user to the home page.
     * Otherwise, redirect the user to the sign up page.
//     * @param email: The email address of the user attempting to log in             // COMMENT ME OUT ONCE OAUTH EMAIL WORKS
     * @param model: The model map to be used for redirecting
     * @return ModelAndView: A new model with the email address as an attribute, and a redirected view
     */
    @GetMapping("/sign-in")
    public ModelAndView checkCredentials(Principal principal, ModelMap model){
        GoogleAuthResponse googleAuthResponse = new GoogleAuthResponse(principal);
        String email = googleAuthResponse.getEmail();

        try{
            List<Client> user = clientService.getClientByEmail(email);
            model.addAttribute("user", user.get(0));
            return new ModelAndView("redirect:/home", model);
        }catch(IllegalStateException ignored){}

        model.addAttribute("email", email);
        return new ModelAndView("redirect:/sign-up", model);
    }

    @GetMapping("/sign-up")
    String createUser(String email, Model model){
        model.addAttribute("email", email);
        model.addAttribute("skills", skillService.listOfAllSKillsAndIds());
        return "sign-up";
    }

    @PostMapping("/home")
    String addNewUser(@ModelAttribute Client client, String skill_one, String skill_two, String skill_three, Model model){
        client = clientService.addNewUser(client);

        String[] skill_ids = {skill_one, skill_two, skill_three};

        for (String skill_id : skill_ids) {
            if (skill_id != null && Integer.parseInt(skill_id) > -1) {
                skillService.addSkillToClient(client, (long) Integer.parseInt(skill_id));
            }
        }

        return homePage(client, model);
    }

    @GetMapping("/home")
    String homePage(@ModelAttribute Client client, Model model){
        List<ProjectTable> projects = new ArrayList<>(0);

        for (SkillsCategory skill : client.getSkillsCategorys())
        {
            List<ProjectTable> projectsForSkill = projectService.getProjectsBySkill(skill.getId());
            projects.addAll(projectsForSkill);
        }

        Collections.shuffle(projects);
        model.addAttribute("projects", projects); // request a list of projects for the user ID
        model.addAttribute("user", client);
        return "home";
    }

    @GetMapping("/project/{id}")
    String projectPage(@RequestParam Long id, Model model){
//        model.addAttribute("project", projectService.getProjectByID(id));

        return "project";
    }

    @PutMapping("/all-projects")
    String allProjectsForUser(@ModelAttribute Client client, Model model){
//        model.addAttribute("projects", projectService.getProjectsBySkillList(client.getUserId(), -1));
        return "all-projects";
    }
}