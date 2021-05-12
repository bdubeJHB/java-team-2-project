package za.co.bbd.softhelp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.bbd.softhelp.Models.Client;
import za.co.bbd.softhelp.Models.ProjectTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "testingServices")
public class TestController {
    private final ClientServices clientServices;
    private final ProjectServices projectServices;
    private final SkillServices skillServices;

    @Autowired
    public TestController(ClientServices clientServices, ProjectServices projectServices,
                          SkillServices skillServices) {
        this.clientServices = clientServices;
        this.projectServices = projectServices;
        this.skillServices = skillServices;
    }

    @GetMapping("/user")
    public List<Client> viewClientList(){
        return clientServices.getClientByEmail("simon@Last");
    }

    @GetMapping("/info")
    public List<String> viewClientInfo(){
        return clientServices.getListOfClientInfo("simon@Last");
    }

    @GetMapping("/fname")
    public String fname(){
        return clientServices.getClientFirstName("simon@Last");
    }

    @GetMapping("/id")
    public Long id(){
        return clientServices.getClientId("simon@Last");
    }

    @PostMapping("/register")
    public String registerClient(@RequestBody Client client){
        return clientServices.addNewClient(client);
    }

    @GetMapping("/project")
    public List<List<String>> project(){
        return projectServices.getProjectsBySkillList(2L);
    }

    @GetMapping("/Allproject")
    public List<List<String>> allProject(){
        return projectServices.getAllProjectsAsList();
    }

    @GetMapping("/deleteproject")
    public String deleteProject(){
        return projectServices.deleteProject(1L);
    }

    @GetMapping("/projectCancel")
    public String cancelProject(){
        return projectServices.workerCancelProject(2L);
    }

    @GetMapping("/skills")
    public List<List<String>> skills(){
        return skillServices.listOfAllSKillsAndIds();
    }
}
