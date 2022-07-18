package cleanplate.cleanplatehombres.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm() {
        System.out.println("anything");
        return "users/login";
    }
}