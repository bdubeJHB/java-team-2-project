package za.co.bbd.softhelp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import za.co.bbd.softhelp.Models.ProjectTable;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectTable,Long> {
    List<ProjectTable> findBySkillId(Long skillId);

    @Transactional
    @Modifying
    @Query("DELETE FROM ProjectTable WHERE projectId= :id")
    void deleteProject(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query("UPDATE ProjectTable SET worker=NULL, status=1 WHERE projectId= :id")
    void changeStatusToAvailable(@Param("id") Long id);

}