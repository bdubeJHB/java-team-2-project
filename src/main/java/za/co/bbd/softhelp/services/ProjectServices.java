package za.co.bbd.softhelp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.bbd.softhelp.Models.Client;
import za.co.bbd.softhelp.Models.ProjectTable;
import za.co.bbd.softhelp.Models.SkillsCategory;
import za.co.bbd.softhelp.Models.Status;
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

    public List<ProjectTable> getProjectsBySkill(Long skillId){
        return projectRepository.findBySkillId(skillId);
    }

    public List<List<String>> getProjectsBySkillList(Long skillId){
        List<ProjectTable> projects = projectRepository.findBySkillId(skillId);
        if(projects.isEmpty()){
            throw new IllegalStateException("There are no projects available for that skill");
        }

        List<List<String>> projectList = new ArrayList<List<String>>();
        for(ProjectTable project:projects){
            List<String> row = new ArrayList<>();
            row.add(project.getDescription());
            row.add(String.valueOf(project.getPrice()));
            row.add(project.getSkill().getName());
            row.add(project.getStatus().getStatus());
            row.add("Client " + project.getUser().getFirstName());
            row.add("Worker " + project.getWorker().getFirstName());
            projectList.add(row);
        }

        return projectList;
    }

    public List<List<String>> getAllProjectsAsList(){
        List<ProjectTable> projects = projectRepository.findAll();
        if(projects.isEmpty()){
            throw new IllegalStateException("There are no projects available");
        }

        List<List<String>> projectList = new ArrayList<List<String>>();
        for(ProjectTable project:projects){
            List<String> row = new ArrayList<>();
            row.add(project.getDescription());
            row.add(String.valueOf(project.getPrice()));
            row.add(project.getSkill().getName());
            row.add(project.getStatus().getStatus());
            row.add("Client " + project.getUser().getFirstName());
            row.add("Worker " + project.getWorker().getFirstName());
            projectList.add(row);
        }

        return projectList;
    }

    public String deleteProject(Long projectId){
        Optional<ProjectTable> project = projectRepository.findById(projectId);
        if(project.isEmpty()){
            throw new IllegalStateException("Project does not exist");
        }
        projectRepository.deleteProject(projectId);
        return "Project has been removed";
    }

    public String workerCancelProject(Long projectId){
        Optional<ProjectTable> project = projectRepository.findById(projectId);
        if(project.isEmpty()){
            throw new IllegalStateException("Project does not exist");
        }
        projectRepository.changeStatusToAvailable(projectId);
        return "Project has been canceled";
    }

    public List<ProjectTable> findProjectsByWorkerId(Long workerId){
        List<ProjectTable> allProjects = projectRepository.findAll();
        List<ProjectTable> workerProjects = new ArrayList<>();

        for(ProjectTable project: allProjects){
            try{
                if(project.getWorker().getUserId() == workerId){
                    workerProjects.add(project);
                }
            }catch (Exception e){
            }
        }

        return workerProjects;
    }

    public List<ProjectTable> findProjectByClientId(Long clientId){
        List<ProjectTable> allProjects = projectRepository.findAll();
        List<ProjectTable> clientProjects = new ArrayList<>();

        for(ProjectTable project: allProjects){
            try{
                if(project.getUser().getUserId() == clientId){
                    clientProjects.add(project);
                }
            }catch (Exception e){
            }
        }

        return clientProjects;
    }

    public String acceptProjectIfNull(Client worker, Long projectId){
        ProjectTable project = projectRepository.findById(projectId).get();

        if(project.getWorker() != null){
            throw new IllegalStateException("Project is taken");
        }
        projectRepository.updateProjectStatusInProgress(worker,projectId);
        return "Project has been Accepted";
    }

    public String createProject(Client client, int price, String description, SkillsCategory skill, Status status){
        ProjectTable project = new ProjectTable();

        project.setUser(client);
        project.setWorker(null);
        project.setDescription(description);
        project.setPrice((float) price);
        project.setSkill(skill);
        project.setStatus(status);
        projectRepository.save(project);
        return "Project Created.";
    }
}
