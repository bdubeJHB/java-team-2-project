package za.co.bbd.softhelp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bbd.softhelp.Models.ProjectTable;
import za.co.bbd.softhelp.Repository.ProjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServices {
    final private ProjectRepository projectRepository;

    @Autowired
    public ProjectServices(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

//    public List<ProjectTable> getProjectsBySkill(Long skillId){
//        return projectRepository.findByskill_ID(skillId);
//    }

//    public List<List<String>> getProjectsBySkillList(Long skillId){
//        List<ProjectTable> projects = projectRepository.findByskill_ID(skillId);
//        if(projects.isEmpty()){
//            throw new IllegalStateException("There are no projects available for that skill");
//        }
//
//        List<List<String>> projectList = new ArrayList<List<String>>();
//        for(ProjectTable project:projects){
//            List<String> row = new ArrayList<>();
//            row.add(project.getDescription());
//            row.add(String.valueOf(project.getPrice()));
//            row.add(project.getSkill().getName());
//            row.add(project.getStatus().getStatus());
//            row.add("Client " + project.getUser().getFirstName());
//            row.add("Worker " + project.getWorker().getFirstName());
//            projectList.add(row);
//        }
//
//        return projectList;
//    }
}
