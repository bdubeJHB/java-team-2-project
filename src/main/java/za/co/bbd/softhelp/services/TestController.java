package za.co.bbd.softhelp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @Autowired
    public TestController(ClientServices clientServices, ProjectServices projectServices) {
        this.clientServices = clientServices;
        this.projectServices = projectServices;
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

    @GetMapping("/project")
    public List<List<String>> project(){
        return projectServices.getProjectsBySkillList(2L);
    }
}
