package za.co.bbd.softhelp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.bbd.softhelp.Models.Client;

@Repository
public interface UserRepository extends JpaRepository<Client,Long> {
}
