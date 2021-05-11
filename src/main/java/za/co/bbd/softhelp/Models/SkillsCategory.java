package za.co.bbd.softhelp.Models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "skillscategory")
public class SkillsCategory {

    @Id
    @SequenceGenerator(
            name = "skillscategory_sequence",
            sequenceName = "skillscategory_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "skillscategory_sequence"
    )

    @Column(name = "skillID")
    private  Long id;

    @Column(
            name = "name",
            updatable = false
    )
    private String name;


    //--------------
    @ManyToMany()
    @JoinTable(
            name ="skill_set",
            joinColumns = @JoinColumn(name="skillID")
            ,inverseJoinColumns = @JoinColumn(name="userID")
    )
    private List<Client> user ;

    @OneToMany(mappedBy = "skill")
    List<ProjectTable> project ;

    //--------------

    public SkillsCategory(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SkillsCategory(String name) {
        this.name = name;
    }

    public SkillsCategory() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getUser() {
        return user;
    }

    public void setUser(List<Client> user) {
        this.user = user;
    }

    public List<ProjectTable> getProject() {
        return project;
    }

    public void setProject(List<ProjectTable> project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "SkillsCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
