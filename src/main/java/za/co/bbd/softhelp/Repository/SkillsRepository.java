package za.co.bbd.softhelp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.bbd.softhelp.Models.SkillsCategory;


import java.util.Optional;

@Repository
public interface SkillsRepository extends JpaRepository<SkillsCategory,Long> {

}
