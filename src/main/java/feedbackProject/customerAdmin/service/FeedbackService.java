package feedbackProject.customerAdmin.service;

import feedbackProject.customerAdmin.model.FeedbackModel;
import feedbackProject.customerAdmin.repository.FeedbackRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepo feedbackRepo;

    public FeedbackModel add(String message,Long userid) {
        FeedbackModel feedbackModel=new FeedbackModel();
        feedbackModel.setMessage(message);
        feedbackModel.setUserid(userid);

        feedbackRepo.save(feedbackModel);
        return feedbackModel;
    }
    public List<FeedbackModel> getFeedback(HttpSession session){

        Long userid= (Long) session.getAttribute("userid");
        if(userid!=null){
            return feedbackRepo.feedbackById(userid);
        }
        return feedbackRepo.findAll();
        
    }

    public Optional<FeedbackModel> getFeedbackById(Long id) {
        System.out.println("id"+id);
        return feedbackRepo.findById(id);
    }

    public void edit(String message, Long id) {
        feedbackRepo.editFeedbackById(message,id);
    }

    public void delete(Long id) {
        feedbackRepo.deleteById(id);
    }
}
