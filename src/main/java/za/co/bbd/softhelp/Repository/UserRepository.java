package za.co.bbd.softhelp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.co.bbd.softhelp.Models.Client;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Client,Long> {

    List<Client> findByfirstName(String firstName);
    List<Client> findByemail(String email);

}
