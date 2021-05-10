package za.co.bbd.softhelp.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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


    public ProjectTable() {
    }

    @ManyToOne
    @JoinColumn(name = "user_ID")
    User user = new User();


    @ManyToOne
    @JoinColumn(name = "Worker_ID")
    User worker = new User();

    @ManyToOne
    @JoinColumn(name = "skill_ID")
    SkillsCategory skill = new SkillsCategory();

    @OneToOne
    @JoinColumn(name = "status_ID")
    Status status;


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