package za.co.bbd.softhelp.Models;


import javax.persistence.*;
import java.util.*;

@Entity
@Table()
public class Status {

    @OneToMany(mappedBy = "status")
    private List<ProjectTable> projects = new ArrayList<>();

    public Status(Long statusId, String status) {
        this.statusId = statusId;
        this.status = status;
    }

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

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", status='" + status + '\'' +
                '}';
    }
}
