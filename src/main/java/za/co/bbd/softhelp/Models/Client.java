package za.co.bbd.softhelp.Models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Column(name = "first_name"
            ,nullable = false)
    private String firstName;

    @Column(name = "last_name"
            ,nullable = false)
    private String lastName;

    @Column(name = "email"
            ,nullable = false
            ,unique = true)
    private String email;


    //--------------
    @ManyToMany(mappedBy = "user")
//    private Set<SkillsCategory> skillsCategorys = new HashSet<>();
    private List<SkillsCategory> skillsCategorys;
//--------------


    @OneToMany(mappedBy = "user")
    List<ProjectTable> projectTables ;

    @OneToMany(mappedBy = "worker")
    List<ProjectTable> project ;

    public Client(Long userId, String firstName, String lastName, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public Client(){

    }

    public Client(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
