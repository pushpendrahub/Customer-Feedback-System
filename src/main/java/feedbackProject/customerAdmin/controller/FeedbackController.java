package feedbackProject.customerAdmin.controller;

import feedbackProject.customerAdmin.model.FeedbackModel;
import feedbackProject.customerAdmin.service.FeedbackService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

//    @GetMapping("editFeedback"){
//        return "editFeedback";
//    }
    @GetMapping("/feedback")
    public String userFeedback(Model model,
                               HttpSession session
    ){

        List<FeedbackModel> list=feedbackService.getFeedback(session);
        model.addAttribute("feedbackList",list);
        return "feedback";
    }

    @GetMapping("/addFeedback")
    public String addFeedback(){
        return "addFeedback.html";
    }

    @PostMapping("/setFeedback")
    public String setFeedback(
            @RequestParam String message,
            HttpSession session
    ){
        Long userid= (Long) session.getAttribute("userid");
        feedbackService.add(message,userid);
        return "redirect:/feedback";
    }
    @GetMapping("/getFeedback/{id}")
    public String getFeedback(@PathVariable Long id,
                               Model model
    ){
        Optional<FeedbackModel> list=feedbackService.getFeedbackById(id);
        System.out.println("Feedback List = " +list.get().getId());
        model.addAttribute("feedback",list.get());
        return "editFeedback";
    }
    @PostMapping("/editFeedback/{id}")
    public String editFeedback(
            @PathVariable Long id,
            @RequestParam String message,
            HttpSession session
    ){

        feedbackService.edit(message,id);
        if(session.getAttribute("userid")!=null){
            return "redirect:/feedback";
        }
        return "redirect:/adminFeedback";
    }

}
