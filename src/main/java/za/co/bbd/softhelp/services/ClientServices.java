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

    public Optional<Client> getClientById(Long id){
        return userRepository.findById(id);
    }

    public List<String> getListOfClientInfo(Long id){
        List<String> clientInfo = new ArrayList<>();
        Client client = userRepository.findById(id).get();

        clientInfo.add(client.getFirstName());
        clientInfo.add(client.getLastName());
        clientInfo.add(client.getEmail());

        return clientInfo;
    }

    public String getClientEmail(Long id) {
        Client client = getClientById(id).get();
        return client.getEmail();
    }

    public String getClientFirstName(Long id){
        Client client = getClientById(id).get();
        return client.getFirstName();
    }

    public String getClientLastName(Long id) {
        Client client = getClientById(id).get();
        return client.getLastName();
    }

    public void deleteClient(Long id) {
        Optional<Client> client = getClientById(id);
        if(client.isEmpty()){
            throw new IllegalStateException("Client "+id+" does not exist");
        }
        userRepository.deleteById(id);
    }

}
