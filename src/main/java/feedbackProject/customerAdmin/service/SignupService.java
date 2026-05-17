package feedbackProject.customerAdmin.service;

import feedbackProject.customerAdmin.model.SignupModel;
import feedbackProject.customerAdmin.repository.SignupRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SignupService {


    @Autowired
    private SignupRepo signupRepo;


    public SignupModel register(String username,String email,String confirm_password){
            SignupModel signupModel=new SignupModel();
            signupModel.setUsername(username);
            signupModel.setEmail(email);
            signupModel.setPassword(confirm_password);

        return signupRepo.save(signupModel);

    }

    public String login(String username, String password,HttpSession session) {
        Optional<SignupModel> user= signupRepo.findByUserName(username);
        SignupModel foundUser=user.get();
        if(username.equals(foundUser.getUsername()) && password.equals(foundUser.getPassword())){
            session.setAttribute("userid", foundUser.getId());
            return "sucess";
        }
        else{
            return "fail";
        }

    }
}
