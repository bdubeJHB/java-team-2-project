package za.co.bbd.softhelp.CommandLineRunner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;;
import za.co.bbd.softhelp.Models.Client;
import za.co.bbd.softhelp.Models.SkillsCategory;
import za.co.bbd.softhelp.Models.Status;
import za.co.bbd.softhelp.Repository.ProjectRepository;
import za.co.bbd.softhelp.Repository.SkillsRepository;
import za.co.bbd.softhelp.Repository.StatusRepository;
import za.co.bbd.softhelp.Repository.UserRepository;

@Configuration
public class CONFIG {

    StatusRepository statusRepository;
    ProjectRepository projectRepository;
    SkillsRepository skillsRepository;
    UserRepository userRepository;


    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository,SkillsRepository skillsRepository,StatusRepository statusRepository){
        return args -> {
            Client user = new Client(2l,"sure","last","sureLast");
            Status status = new Status("available");
            SkillsCategory skillsCategory = new SkillsCategory("java");

            userRepository.save(user);
            skillsRepository.save(skillsCategory);
            statusRepository.save(status);
        };
    }
}
