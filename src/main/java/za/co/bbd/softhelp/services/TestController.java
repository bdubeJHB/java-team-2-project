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

    @GetMapping("/users")
    public List<String> viewClientList(){
        return clientServices.getListOfClientInfo(2L);
    }

    @GetMapping("/user")
    public List<String> userData(){
        List<String> userData = new ArrayList<>();
        userData.add(clientServices.getClientEmail(1L));
        userData.add(clientServices.getClientFirstName(1L));
        userData.add(clientServices.getClientLastName(1L));
        return userData;
    }

    @GetMapping("/deleteUser")
    public String deleteUser(){
        clientServices.deleteClient(1L);
        return "USER DELETED";
    }

    @GetMapping("/project")
    public List<List<String>> viewProject(){
        return projectServices.getProjectsBySkillList(2L);
    }
}
