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
import za.co.bbd.softhelp.services.ClientServices;
import za.co.bbd.softhelp.services.ProjectServices;
import za.co.bbd.softhelp.services.SkillServices;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EndpointController{

    ClientServices clientService;
    ProjectServices projectService;
    SkillServices skillService;
    ProjectRepository projectRepository;

    private String userEmail;

    @Autowired
    EndpointController(ClientServices clientService, ProjectServices projectService, SkillServices skillService, ProjectRepository projectRepository){
        this.projectService = projectService;
        this.clientService = clientService;
        this.skillService = skillService;
        this.projectRepository = projectRepository;
    }

    @GetMapping("/")
    String loginPage(Model model){
        return "login";
    }

    /**
     * [Only called internally] Attempt to sign in user.
     * If the given email exists in DB, redirect the user to the home page.
     * Otherwise, redirect the user to the sign up page.
     * @param email: The email address of the user attempting to log in             // COMMENT ME OUT ONCE OAUTH EMAIL WORKS
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
        model.addAttribute("skills", skillService.listOfAllSKillsAndIds());
        return "sign-up";
    }

    @PostMapping("/home")
    String addNewUser(@ModelAttribute Client client, String skill_one, String skill_two, String skill_three, Model model){

//        Client newUser = clientService.addNewUser(client);
        // assign the skills to the user
        List<SkillsCategory> skills = new ArrayList<>(0);
        skills.add(new SkillsCategory(skill_one));
        skills.add(new SkillsCategory(skill_two));
        skills.add(new SkillsCategory(skill_three));

        client.setSkillsCategorys(skills);

        return homePage(client, model);
    }

    @GetMapping("/home")
    String homePage(@ModelAttribute Client client, Model model){
        List<ProjectTable> projects = new ArrayList<>(0);

        ProjectTable pt = new ProjectTable("the project", 12.4f);
        projectRepository.save(pt);
        pt = new ProjectTable("the other OTHER project", 1.4f);
        projectRepository.save(pt);
        pt = new ProjectTable("the other project", 13.4f);
        projectRepository.save(pt);

        model.addAttribute("user", client);
        model.addAttribute("projects", projectRepository.findAll()); // request a list of projects for the user ID
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