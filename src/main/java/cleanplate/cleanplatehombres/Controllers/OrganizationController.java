//package cleanplate.cleanplatehombres.Controllers;
//
//import cleanplate.cleanplatehombres.Repositories.ListingRepository;
//import cleanplate.cleanplatehombres.Repositories.OrganizationRepository;
//import cleanplate.cleanplatehombres.models.Listing;
//import cleanplate.cleanplatehombres.models.Organization;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class OrganizationController {
//
//    private final OrganizationRepository organizationRepository;
//
//    public OrganizationController(OrganizationRepository organizationRepository) {
//        this.organizationRepository = organizationRepository;
//    }
//
//    @GetMapping("/orgs")
//    public String index(Model model) {
//        model.addAttribute("organizations", organizationRepository.findAll());
//        return "orgs/index";
//    }
//
//    @GetMapping("/orgs/create")
//    public String create(Model model) {
//        model.addAttribute("organization", new Organization());
//        return "orgs/create";
//    }
//
//    @PostMapping("listings/create")
//    public String post(@ModelAttribute Organization organization) {
//        if(organization.getOrgName().equals("") ||
//                organization.getOrgDescription().equals("") ||
//                organization.getOrgStAddress().equals("") ||
//                organization.getOrgCity().equals("") ||
//                organization.getOrgState().equals("") ||
//                (organization.getOrgZip() == 0) ||
//                organization.isDonor()
//        ){
//            return "orgs/create";
//        }
//
//        listingRepository.save(listing);
//        return "redirect:/listings";
//    }
//
//    @GetMapping("listings/show")
//    public String showPage() {
//        return "listings/show";
//    }
//
//
//
//}