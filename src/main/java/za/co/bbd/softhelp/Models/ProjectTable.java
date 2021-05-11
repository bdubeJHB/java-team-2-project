package za.co.bbd.softhelp.Models;

import javax.persistence.*;

@Entity
@Table(name="ProjectTable")
public class ProjectTable {

    @Id
    @SequenceGenerator(
            name ="project_sequence",
            sequenceName = "project_sequence",
            allocationSize =1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "project_sequence"
    )

    private long projectId;
    private String description;
    private  float price;


    public ProjectTable(long projectId, String description, float price) {
        this.projectId = projectId;
        this.description = description;
        this.price = price;
    }

    public ProjectTable(String description, float price) {
        this.description = description;
        this.price = price;
    }

    public ProjectTable() {
    }

    @ManyToOne
    @JoinColumn(name = "status_ID")
    private Status status ;

    @ManyToOne
    @JoinColumn(name = "user_ID")
    Client user = new Client();


    @ManyToOne
    @JoinColumn(name = "Worker_ID")
    Client worker = new Client();

    @ManyToOne
    @JoinColumn(name = "skill_ID")
    SkillsCategory skill = new SkillsCategory();


    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Client getUser() {
        return user;
    }

    public void setUser(Client user) {
        this.user = user;
    }

    public Client getWorker() {
        return worker;
    }

    public void setWorker(Client worker) {
        this.worker = worker;
    }

    public SkillsCategory getSkill() {
        return skill;
    }

    public void setSkill(SkillsCategory skill) {
        this.skill = skill;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProjectTable{" +
                "projectId=" + projectId +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", user=" + user +
                ", worker=" + worker +
                ", skill=" + skill +
                '}';
    }
}