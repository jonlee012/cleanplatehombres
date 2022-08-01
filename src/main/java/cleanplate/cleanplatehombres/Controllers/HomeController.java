package cleanplate.cleanplatehombres.Controllers;

import cleanplate.cleanplatehombres.Repositories.ListingRepository;
import cleanplate.cleanplatehombres.Repositories.OrganizationRepository;
import cleanplate.cleanplatehombres.Repositories.UserRepository;
import org.apache.tomcat.util.modeler.BaseAttributeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

//    private final OrganizationRepository organizationRepository;
//
//    public HomeController (OrganizationRepository organizationRepository) {
//        this.organizationRepository = organizationRepository;
//    }

    @GetMapping("/index")
    public String index(Model model){
//        model.addAttribute("organizations", organizationRepository.findAll());
        return "index";
    }

}
