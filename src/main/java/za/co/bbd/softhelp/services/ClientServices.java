package za.co.bbd.softhelp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bbd.softhelp.Models.Client;
import za.co.bbd.softhelp.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServices {
    final private UserRepository userRepository;

    @Autowired
    public ClientServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Client> getAllClients(){
        return userRepository.findAll();
    }

    public List<Client> getClientById(Long id){
        Optional<Client> client = userRepository.findById(id);
        List<Client> clientList = new ArrayList<>();
        if(client.isEmpty()){
            throw new IllegalStateException("Client ID " + id + "does not exist");
        }
        clientList.add(client.get());
        return clientList;
    }

    public List<Client> getClientByEmail(String email){
        List<Client> client =  userRepository.findByemail(email);
        if(client.isEmpty()){
            throw new IllegalStateException("Client email: " + email + "does not exist");
        }
        return client;
    }

    public List<String> getListOfClientInfo(String email){
        List<String> clientInfo = new ArrayList<>();
        Client client = userRepository.findByemail(email).get(0);

        clientInfo.add(client.getFirstName());
        clientInfo.add(client.getDescription());
        clientInfo.add(client.getEmail());

        return clientInfo;
    }

    public String getClientEmail(String email) {
        List<String> clientInfo = new ArrayList<>();
        Client client = userRepository.findByemail(email).get(0);
        return client.getEmail();
    }

    public String getClientFirstName(String email){
        List<String> clientInfo = new ArrayList<>();
        Client client = userRepository.findByemail(email).get(0);
        return client.getFirstName();
    }

    public Long getClientId(String email){
        List<String> clientInfo = new ArrayList<>();
        Client client = userRepository.findByemail(email).get(0);
        return client.getUserId();
    }

//    public void deleteClient(Long id) {
//        Optional<Client> client = getClientById(id);
//        if(client.isEmpty()){
//            throw new IllegalStateException("Client "+id+" does not exist");
//        }
//        userRepository.deleteById(id);
//    }

}
