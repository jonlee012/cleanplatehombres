package cleanplate.cleanplatehombres.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactUs {

    @GetMapping("/contact")
    public String index(){
        return "contact";
    }

}
