//<<<<<<< HEAD
//package za.co.bbd.softhelp.CommandLineRunner;
//
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;;
//import za.co.bbd.softhelp.Models.Client;
//import za.co.bbd.softhelp.Models.ProjectTable;
//import za.co.bbd.softhelp.Models.SkillsCategory;
//import za.co.bbd.softhelp.Models.Status;
//import za.co.bbd.softhelp.Repository.ProjectRepository;
//import za.co.bbd.softhelp.Repository.SkillsRepository;
//import za.co.bbd.softhelp.Repository.StatusRepository;
//import za.co.bbd.softhelp.Repository.UserRepository;
//
//import java.util.List;
//
//@Configuration
//public class CONFIG {
//
//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository userRepository,
//                                        SkillsRepository skillsRepository,
//                                        StatusRepository statusRepository,
//                                        ProjectRepository projectRepository){
//        return args -> {
//
//            // -----------Config data don't delete -----------------------
//            Status status1 = new Status("Available");
//            Status status2 = new Status("In progress");
//            Status status3 = new Status("Complete");
//
//            SkillsCategory skillsCategory0 = new SkillsCategory("Java");
//            SkillsCategory skillsCategory1 = new SkillsCategory("JavaScript");
//            SkillsCategory skillsCategory2 = new SkillsCategory("Python");
//            SkillsCategory skillsCategory3 = new SkillsCategory("C#");
//            SkillsCategory skillsCategory4 = new SkillsCategory("PHP");
//
//            // -----------End of Config  ----------------------------
//
//            // ----------- Test database -----------------------------
//            Client user = new Client("John","last","john@Last");
//            Client user1 = new Client("Simon","last","simon@Last");
//            Client user2 = new Client("smith","last","smith@Last");
//            userRepository.save(user);
//            skillsCategory1.setUser(List.of(user));
//            skillsRepository.saveAll(List.of(skillsCategory1));
//
//
////            skillsCategory1.setUser(List.of(user,user1));
////            skillsCategory2.setUser(List.of(user2,user1));
////            skillsCategory3.setUser(List.of(user,user1));
//
//
//
//=======
////package za.co.bbd.softhelp.CommandLineRunner;
////
////
////import org.springframework.boot.CommandLineRunner;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;;
////import za.co.bbd.softhelp.Models.Client;
////import za.co.bbd.softhelp.Models.ProjectTable;
////import za.co.bbd.softhelp.Models.SkillsCategory;
////import za.co.bbd.softhelp.Models.Status;
////import za.co.bbd.softhelp.Repository.ProjectRepository;
////import za.co.bbd.softhelp.Repository.SkillsRepository;
////import za.co.bbd.softhelp.Repository.StatusRepository;
////import za.co.bbd.softhelp.Repository.UserRepository;
////
////import java.util.List;
////
////@Configuration
////public class CONFIG {
////
////    @Bean
////    CommandLineRunner commandLineRunner(UserRepository userRepository,
////                                        SkillsRepository skillsRepository,
////                                        StatusRepository statusRepository,
////                                        ProjectRepository projectRepository){
////        return args -> {
////
////            // -----------Config data don't delete -----------------------
////            Status status1 = new Status("Available");
////            Status status2 = new Status("In progress");
////            Status status3 = new Status("Complete");
////
////            SkillsCategory skillsCategory0 = new SkillsCategory("Java");
////            SkillsCategory skillsCategory1 = new SkillsCategory("JavaScript");
////            SkillsCategory skillsCategory2 = new SkillsCategory("Python");
////            SkillsCategory skillsCategory3 = new SkillsCategory("C#");
////            SkillsCategory skillsCategory4 = new SkillsCategory("PHP");
////            // -----------End of Config  ----------------------------
////
////            // ----------- Test database -----------------------------
////            Client user = new Client("John","last","john@Last");
////            Client user1 = new Client("Simon","last","simon@Last");
////            Client user2 = new Client("smith","last","smith@Last");
////
////            skillsCategory1.setUser(List.of(user,user1));
////            skillsCategory2.setUser(List.of(user2,user1));
////            skillsCategory3.setUser(List.of(user,user1));
////
//>>>>>>> 82a5755145041b604ca408e53a467ed609ac856b
////            ProjectTable projectTable = new ProjectTable("website", 123.0F);
////            projectTable.setUser(user);
////            projectTable.setStatus(status1);
////            projectTable.setSkill(skillsCategory2);
////            projectTable.setWorker(user2);
////
////            ProjectTable projectTable2 = new ProjectTable("mobile app", 133.0F);
////            projectTable2.setUser(user2);
////            projectTable2.setStatus(status2);
////            projectTable2.setSkill(skillsCategory3);
////            projectTable2.setWorker(user1);
//<<<<<<< HEAD
//
////            userRepository.saveAll(List.of(user1,user2,user));
////            skillsRepository.saveAll(List.of(skillsCategory1,skillsCategory2,skillsCategory3,skillsCategory0,skillsCategory4));
////            statusRepository.saveAll(List.of(status1,status2,status3));
////            projectRepository.saveAll(List.of(projectTable,projectTable2));
//
////            System.out.println(projectRepository.count());
//            // --------End of test -----------------------------------
//
//        };
//    }
//}
//=======
////
////            userRepository.saveAll(List.of(user1,user2,user));
////            skillsRepository.saveAll(List.of(skillsCategory1,skillsCategory2,skillsCategory3));
////            statusRepository.saveAll(List.of(status1,status2,status3));
////            projectRepository.saveAll(List.of(projectTable,projectTable2));
////
//////            System.out.println(projectRepository.count());
////            // --------End of test -----------------------------------
////
////        };
////    }
////}
//>>>>>>> 82a5755145041b604ca408e53a467ed609ac856b
