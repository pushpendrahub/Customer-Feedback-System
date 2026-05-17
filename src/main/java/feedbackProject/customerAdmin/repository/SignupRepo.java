package feedbackProject.customerAdmin.repository;

import feedbackProject.customerAdmin.model.SignupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignupRepo extends JpaRepository<SignupModel,Long> {


    @Query(value="SELECT * FROM customer_feedback WHERE username=:username",nativeQuery = true)
    Optional<SignupModel> findByUserName(@Param("username") String username);
}
