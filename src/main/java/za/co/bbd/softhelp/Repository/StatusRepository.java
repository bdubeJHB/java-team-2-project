package za.co.bbd.softhelp.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.bbd.softhelp.Models.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {
}
