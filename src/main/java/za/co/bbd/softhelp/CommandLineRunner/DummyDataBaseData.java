package za.co.bbd.softhelp.CommandLineRunner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.bbd.softhelp.Models.Client;
import za.co.bbd.softhelp.Models.ProjectTable;
import za.co.bbd.softhelp.Models.SkillsCategory;
import za.co.bbd.softhelp.Repository.ProjectRepository;
import za.co.bbd.softhelp.Repository.SkillsRepository;
import za.co.bbd.softhelp.Repository.StatusRepository;
import za.co.bbd.softhelp.Repository.UserRepository;

import java.util.List;

@Configuration
public class DummyDataBaseData {

    //######################################################################################################
    //####################################  DUMMY DATA FOR DATABASE ########################################
    //######################################################################################################


    public DummyDataBaseData() {
    }


    @Bean
    CommandLineRunner dummyData(UserRepository userRepository,
                                        SkillsRepository skillsRepository,
                                        StatusRepository statusRepository,
                                        ProjectRepository projectRepository){

        return args -> {

            Client user = new Client(
                    "Peter"
                    ,"Lorem Ipsum is simply dummy text of the printing and typesetting industry"
                    ,"peter.short@gmail.com");

            Client user1 = new Client("Rachel",
                    " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s",
                    "rachel.black@gmail.com");
            Client user2 = new Client(
                    "Stephen",
                    "when an unknown printer took a galley of type and scrambled it to make a type specimen book",
                    "stephen.fisher@gmail.com");
            Client user3 = new Client(
                    "Megan",
                    "It has survived not only five centuries",
                    "megan.tucker@gmail.com"
            );


            SkillsAndStatus.getSkillsCategory().get(0).setUser(List.of(user,user3));
            SkillsAndStatus.getSkillsCategory().get(1).setUser(List.of(user1,user2));
            SkillsAndStatus.getSkillsCategory().get(2).setUser(List.of(user2,user1));
            SkillsAndStatus.getSkillsCategory().get(3).setUser(List.of(user3,user));

            ProjectTable projectTable = new ProjectTable("website", 123.0F);
            projectTable.setUser(user);
            projectTable.setStatus(SkillsAndStatus.getStatuses().get(0));
            projectTable.setSkill(SkillsAndStatus.getSkillsCategory().get(1));
            projectTable.setWorker(null);

            ProjectTable projectTable2 = new ProjectTable("mobile app", 133.0F);
            projectTable2.setUser(user1);
            projectTable2.setStatus(SkillsAndStatus.getStatuses().get(0));
            projectTable2.setSkill(SkillsAndStatus.getSkillsCategory().get(2));
            projectTable2.setWorker(null);

            userRepository.saveAll(List.of(user,user1,user2,user3));
            skillsRepository.saveAll(List.of(
                    SkillsAndStatus.getSkillsCategory().get(0),
                    SkillsAndStatus.getSkillsCategory().get(1),
                    SkillsAndStatus.getSkillsCategory().get(2),
                    SkillsAndStatus.getSkillsCategory().get(3)
            ));
            statusRepository.saveAll(List.of(SkillsAndStatus.getStatuses().get(0)));
            projectRepository.saveAll(List.of(projectTable,projectTable2));

        };

    };

}
