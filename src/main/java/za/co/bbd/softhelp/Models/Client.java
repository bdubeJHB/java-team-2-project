package za.co.bbd.softhelp.Models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity()
@Table(name = "Client")
public class Client {


    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    @Column(name = "userID")
    private Long userId;

    @Column(name = "username"
            ,nullable = false
            ,length = 20)
    private String firstName;

    @Column(name = "description"
            ,nullable = false
            ,length = 120)
    private String description;

    @Column(name = "email"
            ,nullable = false
            ,unique = true)
    private String email;


    //--------------
    @ManyToMany(mappedBy = "user")
    private List<SkillsCategory> skillsCategorys;
//--------------


    @OneToMany(mappedBy = "user")
    List<ProjectTable> projectTables ;

    @OneToMany(mappedBy = "worker")
    List<ProjectTable> project ;


    public Client(){
    }

    public Client(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.description = lastName;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<SkillsCategory> getSkillsCategorys() {
        return skillsCategorys;
    }

    public void setSkillsCategorys(List<SkillsCategory> skillsCategorys) {
        this.skillsCategorys = skillsCategorys;
    }

    public List<ProjectTable> getProjectTables() {
        return projectTables;
    }

    public void setProjectTables(List<ProjectTable> projectTables) {
        this.projectTables = projectTables;
    }

    public List<ProjectTable> getProject() {
        return project;
    }

    public void setProject(List<ProjectTable> project) {
        this.project = project;
    }

    public void addSkillCategory(SkillsCategory skill){
        if (skillsCategorys == null) {
            this.skillsCategorys = new ArrayList<>(0);
            skillsCategorys.add(skill);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + description + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
