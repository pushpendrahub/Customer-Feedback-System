package feedbackProject.customerAdmin.controller;

import feedbackProject.customerAdmin.model.FeedbackModel;
import feedbackProject.customerAdmin.service.FeedbackService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class adminController {

    @Autowired
    FeedbackService feedbackService;

    @GetMapping("/adminFeedback")
    public String adminFeedback(Model model,
                                HttpSession session
    ){
        List<FeedbackModel> list=feedbackService.getFeedback(session);
        model.addAttribute("feedbackList",list);
        return "adminFeedback";
    }
    @GetMapping("/deleteFeedback/{id}")
    public String admineditFeedback(
            @PathVariable Long id
    ){
        feedbackService.delete(id);
        return "redirect:/adminFeedback";
    }


}
