package za.co.bbd.softhelp.CommandLineRunner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;;
import za.co.bbd.softhelp.Models.User;
import za.co.bbd.softhelp.Repository.ProjectRepository;
import za.co.bbd.softhelp.Repository.SkillsRepository;
import za.co.bbd.softhelp.Repository.StatusRepository;
import za.co.bbd.softhelp.Repository.UserRepository;

import java.util.List;

@Configuration
public class CONFIG {

    StatusRepository statusRepository;
    ProjectRepository projectRepository;
    SkillsRepository skillsRepository;
    UserRepository userRepository;


    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            User user = new User(2L,"sure","last","sureLast");
            userRepository.save(user);
        };
    }
}
