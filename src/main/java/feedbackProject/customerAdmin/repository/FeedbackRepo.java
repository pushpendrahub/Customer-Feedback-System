package feedbackProject.customerAdmin.repository;

import feedbackProject.customerAdmin.model.FeedbackModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeedbackRepo extends JpaRepository<FeedbackModel,Long> {

    @Query(value="SELECT * FROM feedback WHERE userid=:userid",nativeQuery = true)
    List<FeedbackModel> feedbackById(@Param("userid")Long userid);

    @Modifying
    @Transactional
    @Query(value="UPDATE feedback SET message=:message WHERE id=:id",nativeQuery = true)
    void editFeedbackById(@Param("message") String message,
                            @Param("id") Long id);
}
