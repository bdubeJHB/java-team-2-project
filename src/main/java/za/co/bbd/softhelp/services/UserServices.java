package za.co.bbd.softhelp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bbd.softhelp.Models.User;
import za.co.bbd.softhelp.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    final private UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> GetUserById(Long id){
        return userRepository.findById(id);
    }

    public void addNewUser(User user){
        Optional<User> UsersByEmail = userRepository.findUserByEmail(user.getEmail());
        if (!UsersByEmail.isPresent()){
            throw new IllegalStateException("Email Taken");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        boolean exists = userRepository.existsById(id);

        if(!exists){
            throw new IllegalStateException("student with id " + id + "does not exist");
        }
        userRepository.deleteById(id);
    }

//    public void upDateUser(){
//
//    }
}
