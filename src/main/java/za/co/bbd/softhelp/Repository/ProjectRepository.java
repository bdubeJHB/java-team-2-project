package za.co.bbd.softhelp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.co.bbd.softhelp.Models.ProjectTable;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectTable,Long> {

}