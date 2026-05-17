package feedbackProject.customerAdmin.model;

import jakarta.persistence.*;

@Entity
@Table(name="feedback")
public class FeedbackModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;
    private Long userid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "FeedbackModel{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", userid=" + userid +
                '}';
    }
}
