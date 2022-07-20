package cleanplate.cleanplatehombres.Controllers;

import cleanplate.cleanplatehombres.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactUs {

    private final EmailService emailService;

    public ContactUs(EmailService emailService) {
        this.emailService = emailService;
    }



    @GetMapping("/contact")
    public String contactEmail(Model model) {
        model.addAttribute("user", new User());
        return "contact";
    }

    @PostMapping("/contact")
    public String post(@ModelAttribute User user) {
        user.getEmail();

        emailService.prepareAndSend(user, "we received your request", "Confirmation: your request has " +
                "been received");


        return "/contact";


    }
}