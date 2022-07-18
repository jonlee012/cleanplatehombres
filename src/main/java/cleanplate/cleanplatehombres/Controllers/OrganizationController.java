package cleanplate.cleanplatehombres.Controllers;

import cleanplate.cleanplatehombres.Repositories.OrganizationRepository;
import cleanplate.cleanplatehombres.models.Organization;
import cleanplate.cleanplatehombres.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrganizationController {

    private final OrganizationRepository organizationRepository;

    public OrganizationController(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @GetMapping("/nonProfitIndex")
    public String nonProfit(Model model) {
        model.addAttribute("organizations", organizationRepository.findAll());
        return "organizations/nonProfitIndex";
    }

    @GetMapping("/restaurant")
    public String restaurant(Model model) {
        model.addAttribute("organizations", organizationRepository.findAll());
        return "organizations/restaurant";
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
                (organization.getOrgZip() == 0)) {
//                ||
//                (organization.isDonor() == null)) {
            return "organizations/create";
        }
        organizationRepository.save(organization);
        return "redirect:/orgs/page"; //still need to build out this single-org-index-page
    }

    @GetMapping("organizations/show")
    public String showPage() {
        return "organizations/orgShow";
    }

//    @GetMapping("/organizations/{id}")
//    public String viewPost(@PathVariable Integer id, Model model) {
//        model.addAttribute("title", "Post Page");
//
//        //TODO: Inside the method that shows an individual post, create a new post object and pass it to the view.
//        model.addAttribute("orgProfile", organizationDao.findById(id));
//        Organization organization = organizationDao.getById(id);
////        User user = userDao.getById(post.getUser().getId());
//        model.addAttribute("postTitle", organization.getTitle());
//        model.addAttribute("postBody", post.getBody());
//        model.addAttribute("postID", post.getId());
//        model.addAttribute("user", user);
//        return


    @GetMapping("/profile")
    public String userProfilePage(Model model) {
        model.addAttribute("organizations", organizationRepository.findAll());
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "users/profile";
    }

}