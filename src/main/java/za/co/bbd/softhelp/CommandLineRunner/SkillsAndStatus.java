package za.co.bbd.softhelp.CommandLineRunner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.bbd.softhelp.Models.SkillsCategory;
import za.co.bbd.softhelp.Models.Status;
import za.co.bbd.softhelp.Repository.ProjectRepository;
import za.co.bbd.softhelp.Repository.SkillsRepository;
import za.co.bbd.softhelp.Repository.StatusRepository;
import za.co.bbd.softhelp.Repository.UserRepository;

import java.util.List;

@Configuration
public class SkillsAndStatus {


    //######################################################################################################
    //############################## Skills and Status default #############################################
    //######################################################################################################

    @Bean
    CommandLineRunner commandLineRunner (UserRepository userRepository,
                                         SkillsRepository skillsRepository,
                                         StatusRepository statusRepository,
                                         ProjectRepository projectRepository){

        return args -> {

            Status status1 = new Status("Available");
            Status status2 = new Status("In progress");
            Status status3 = new Status("Complete");

            SkillsCategory skillsCategory = new SkillsCategory("Java");
            SkillsCategory skillsCategory1 = new SkillsCategory("JavaScript");
            SkillsCategory skillsCategory2 = new SkillsCategory("Python");
            SkillsCategory skillsCategory3 = new SkillsCategory("C#");
            SkillsCategory skillsCategory4 = new SkillsCategory("PHP");


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
