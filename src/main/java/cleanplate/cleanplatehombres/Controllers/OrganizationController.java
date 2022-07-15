package cleanplate.cleanplatehombres.Controllers;

import cleanplate.cleanplatehombres.Repositories.ListingRepository;
import cleanplate.cleanplatehombres.Repositories.OrganizationRepository;
import cleanplate.cleanplatehombres.models.Listing;
import cleanplate.cleanplatehombres.models.Organization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrganizationController {

    private final OrganizationRepository organizationRepository;

    public OrganizationController(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @GetMapping("/orgs")
    public String index(Model model) {
        model.addAttribute("organizations", organizationRepository.findAll());
        return "organizations/orgIndex";
    }

    @GetMapping("/orgs/create")
    public String create(Model model) {
        model.addAttribute("organization", new Organization());
        return "organizations/create";
    }

    //if any of the fields are empty in the registration form then return back to the create page
    //need to implement errors for which data point is not correct
    @PostMapping("orgs/create")
    public String post(@ModelAttribute Organization organization) {
        if(organization.getOrgName().equals("") ||
                organization.getOrgDescription().equals("") ||
                organization.getOrgStAddress().equals("") ||
                organization.getOrgCity().equals("") ||
                organization.getOrgState().equals("") ||
                (organization.getOrgZip() == 0) ||
                (organization.isDonor() == null)) {
                return "organizations/create";
            }
                organizationRepository.save(organization);
                return "redirect:/orgs/page"; //still need to build out this single-org-index-page
            }

    @GetMapping("organizations/show")
    public String showPage() {
        return "organizations/show";
    }



}