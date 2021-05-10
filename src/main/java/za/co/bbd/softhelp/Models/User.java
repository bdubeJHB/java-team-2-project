package za.co.bbd.softhelp.Models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity()
@Table(name = "client")
public class User {


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

    public Set<SkillsCategory> getSkillsCategorys() {
        return skillsCategorys;
    }

    //--------------
    @ManyToMany(mappedBy = "user")
    private Set<SkillsCategory> skillsCategorys = new HashSet<>();
//--------------


    @OneToMany(mappedBy = "user")
    Set<ProjectTable> projectTables = new HashSet<>();

    @OneToMany(mappedBy = "worker")
    Set<ProjectTable> project = new HashSet<>();

    public User(Long userId, String firstName, String lastName, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public User(){

    }

    public User(String firstName, String lastName, String email) {
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
