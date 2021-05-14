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

    private String userEmail;
    private Client client;

    @Autowired
    EndpointController(ClientServices clientService, ProjectServices projectService, SkillServices skillService){
        this.projectService = projectService;
        this.clientService = clientService;
        this.skillService = skillService;
    }

    /**
     * Attempt to sign in user.
     * If the given email exists in DB, redirect the user to the home page.
     * Otherwise, redirect the user to the sign up page.
     * @param principal: benedict will explain...
     * @param model: The model map to be used for redirecting
     * @return ModelAndView: A new model with the email address as an attribute, and a redirected view
     */
    @GetMapping("/sign-in")
    public String checkCredentials(Principal principal, Model model){
        GoogleAuthResponse googleAuthResponse = new GoogleAuthResponse(principal);
        String email = googleAuthResponse.getEmail();

        try{
            List<Client> user = clientService.getClientByEmail(email);
            client = user.get(0);
            return homePage(client, model);
        }catch(IllegalStateException ignored){}

        return createUser(email, model);
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
        this.client = client;

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
        client = clientService.getClientById(this.client.getUserId()).get(0);

        for (SkillsCategory skill : client.getSkillsCategorys())
        {
            List<ProjectTable> projectsForSkill = projectService.getProjectsBySkill(skill.getId());
            projects.addAll(projectsForSkill);
        }

        // making sure we have 5 projects max shown
        Collections.shuffle(projects);
        projects = projects.size() > 5 ? projects.subList(0, 5) : projects;

        model.addAttribute("client", client);
        model.addAttribute("projects", projects);
        model.addAttribute("user", client);
        return "home";
    }

    @GetMapping("/project/{id}")
    String projectPage(@PathVariable(value = "id") Long id, Model model){
        ProjectTable project = projectService.getProjectByID(id);

        model.addAttribute("project", project);
        model.addAttribute("id", id);
        return "project";
    }

    @GetMapping("/accept/{id}")
    ModelAndView acceptProject(@PathVariable(value = "id") Long id, ModelMap model){
        this.client = clientService.getClientById(this.client.getUserId()).get(0);
        projectService.acceptProjectIfNull(this.client, id);

        return new ModelAndView("redirect:/home", model);
    }

    @PutMapping("/all-projects")
    String allProjectsForUser(Model model){
        List<ProjectTable> projects = new ArrayList<>();

        for (SkillsCategory skill : client.getSkillsCategorys())
        {
            List<ProjectTable> projectsForSkill = projectService.getProjectsBySkill(skill.getId());
            projects.addAll(projectsForSkill);
        }

        model.addAttribute("projects", projects);
        return "all-projects";
    }
}