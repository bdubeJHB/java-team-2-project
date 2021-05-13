package za.co.bbd.softhelp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.bbd.softhelp.Models.Client;
import za.co.bbd.softhelp.Models.ProjectTable;

import java.util.List;


@RestController
@RequestMapping(value = "testingServices")
public class TestController {
    private final ClientServices clientServices;
    private final ProjectServices projectServices;
    private final SkillServices skillServices;
    private final StatusService statusService;


    @Autowired
    public TestController(ClientServices clientServices, ProjectServices projectServices,
                          SkillServices skillServices, StatusService statusService) {
        this.clientServices = clientServices;
        this.projectServices = projectServices;
        this.skillServices = skillServices;
        this.statusService = statusService;
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

    @GetMapping("/register")
    public String registerClient(){
        Client client = new Client("smith","last","smith@Last");
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

    @GetMapping("/status")
    public String getStatus(){
        return statusService.getStatus(1L);
    }

    @GetMapping("/updateclient")
    public String updateclient(){
        return clientServices.updateClientName(1L,"Ethan");
    }

    @GetMapping("/deleteUser")
    public void deleteUser(){
        clientServices.deleteClient(1L);
    }

    @GetMapping("/updateemail")
    public String emailchange(){
        return clientServices.updateClientEmail(1L, "Ethan@bbd");
    }

    @GetMapping("/updatedes")
    public String changeDes(){
        return clientServices.updateClientDescription(1L, "Ethan@bbddsdsdsdsdsdsdsdsdsds");
    }

    @GetMapping("/statusid")
    public Long getStatusid(){
        return statusService.getStatusId(1L);
    }

    @GetMapping("/setUserSkill")
    public String setUserSkill(){
        Client client = clientServices.getClientByEmail("smith@Last").get(0);

        return  skillServices.addSkillToClient(client,1L);
    }

    @GetMapping("/workerp")
    public String getWorkerProjects(){
        return projectServices.findProjectsByWorkerId(1L).toString();
    }

    @GetMapping("/clientp")
    public String clientProjects(){
        return projectServices.findProjectByClientId(1L).toString();
    }

    @GetMapping("/acceptp")
    public String acceptingAOpenProject(){
        return projectServices.acceptProjectIfNull(clientServices.getClientById(2L).get(0),3L);
    }

    @GetMapping("/createp")
    public String createProject(){

        return projectServices.createProject(clientServices.getClientById(2L).get(0),12,"dsds",
                skillServices.getSkillObjectById(1L),statusService.getStatusObjectById(1L));
    }
}
