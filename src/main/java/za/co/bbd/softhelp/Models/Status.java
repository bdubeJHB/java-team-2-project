package za.co.bbd.softhelp.Models;


import javax.persistence.*;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
import java.util.*;
>>>>>>> Piet

@Entity
@Table()
public class Status {

    @OneToMany(mappedBy = "status")
    private List<ProjectTable> projects = new ArrayList<>();



    public Status(Long statusId, String status) {
        this.statusId = statusId;
        this.status = status;
    }

    //added this
    //-----------------------------------------------------------------------
    @OneToMany(mappedBy = "status")
    List<ProjectTable> projectTableList;
    //-----------------------------------------------------------------------

    public Status() {
    }

    public Status(String status) {
        this.status = status;
    }


    @Id
    @SequenceGenerator(
            name = "status_sequence",
            sequenceName = "status_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "status_sequence"
    )


<<<<<<< HEAD
=======

>>>>>>> Piet
    private Long statusId;

    @Column(name = "status"
            ,nullable = false
            ,updatable = false)
    private String status;


    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //added this
    //-----------------------------------------------------------------------------
    public List<ProjectTable> getProjectTableList() {
        return projectTableList;
    }

    public void setProjectTableList(List<ProjectTable> projectTableList) {
        this.projectTableList = projectTableList;
    }
    //-----------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", status='" + status + '\'' +
                '}';
    }
}
