package za.co.bbd.softhelp.Models;


import javax.persistence.*;
import java.util.HashSet;
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

//    @ManyToMany(mappedBy = "skillsCategories")
//    Set<User> users = new HashSet<>();

    @Column(name = "skillID")
    private  Long id;

    @Column(name = "name")
    private String name;

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

    @Override
    public String toString() {
        return "SkillsCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
