package feedbackProject.customerAdmin.controller;

import feedbackProject.customerAdmin.model.SignupModel;
import feedbackProject.customerAdmin.service.SignupService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private SignupService signupService;

    @GetMapping("/login")
    public String loginController(){
        return "login.html";
    }

    @GetMapping("/signup")
    public String signUp(){
        return "signup";
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String confirm_password
    ){
        if(!password.equals(confirm_password)){
            return "signup";
        }
        signupService.register(username,email,confirm_password);
        return "login";

    }

    @PostMapping("/loginUser")
    public String loginUser(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session
    ){

        String message=signupService.login(username,password,session);
        if(message.equals("sucess")){
            return "redirect:/feedback";
        }
        else{
            return "login";
        }
    }

}
