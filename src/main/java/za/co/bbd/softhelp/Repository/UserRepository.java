package za.co.bbd.softhelp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import za.co.bbd.softhelp.Models.Client;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Client,Long> {

    List<Client> findByfirstName(String firstName);
    List<Client> findByemail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE Client SET firstName=:name WHERE userId=:id")
    void updateName(@Param("id") Long id,@Param("name") String name);

    @Transactional
    @Modifying
    @Query("UPDATE Client SET email=:newEmail WHERE userId=:id")
    void updateEmail(@Param("id") Long id,@Param("newEmail") String newEmail);

    @Transactional
    @Modifying
    @Query("UPDATE Client SET description=:newDescription WHERE userId=:id")
    void updateDescription(@Param("id") Long id, @Param("newDescription") String newDescription);
}
