package za.co.bbd.softhelp.CommandLineRunner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.bbd.softhelp.Models.Client;
import za.co.bbd.softhelp.Models.SkillsCategory;
import za.co.bbd.softhelp.Models.Status;
import za.co.bbd.softhelp.Repository.ProjectRepository;
import za.co.bbd.softhelp.Repository.SkillsRepository;
import za.co.bbd.softhelp.Repository.StatusRepository;
import za.co.bbd.softhelp.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Configuration
public class SkillsAndStatus {


    //######################################################################################################
    //############################## Skills and Status default #############################################
    //######################################################################################################


//    Client user = new Client("John","last","john@Last");
//    Client user1 = new Client("Simon","last","simon@Last");
//    Client user2 = new Client("smith","last","smith@Last");

    Status status1 = new Status("Available");
    Status status2 = new Status("In progress");
    Status status3 = new Status("Complete");

    static SkillsCategory skillsCategory = new SkillsCategory("Java");
    static SkillsCategory skillsCategory1 = new SkillsCategory("JavaScript");
    static SkillsCategory skillsCategory2 = new SkillsCategory("Python");
    static SkillsCategory skillsCategory3 = new SkillsCategory("C#");
    static SkillsCategory skillsCategory4 = new SkillsCategory("PHP");

    public static List<SkillsCategory> getSkillsCategory() {
        return List.of(skillsCategory,skillsCategory1,skillsCategory2,skillsCategory3,skillsCategory4);
    }

    public SkillsAndStatus() {
    }

    @Bean
    CommandLineRunner commandLineRunner (UserRepository userRepository,
                                         SkillsRepository skillsRepository,
                                         StatusRepository statusRepository,
                                         ProjectRepository projectRepository){

        return args -> {


//            userRepository.saveAll(List.of(user,user1,user2));

            skillsRepository.saveAll(List.of(
                    skillsCategory
                    ,skillsCategory1
                    ,skillsCategory2
                    ,skillsCategory3
                    ,skillsCategory4));
            statusRepository.saveAll(List.of(status1
                    ,status2
                    ,status3));

        };

    }
}
