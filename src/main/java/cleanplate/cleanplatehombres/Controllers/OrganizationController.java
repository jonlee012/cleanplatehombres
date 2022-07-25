package cleanplate.cleanplatehombres.Controllers;

import cleanplate.cleanplatehombres.Repositories.ListingRepository;
import cleanplate.cleanplatehombres.Repositories.OrganizationRepository;
import cleanplate.cleanplatehombres.models.Listing;
import cleanplate.cleanplatehombres.models.Organization;
import cleanplate.cleanplatehombres.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class OrganizationController {

    private final OrganizationRepository organizationRepository;
    private final ListingRepository listingRepository;

    public OrganizationController(OrganizationRepository organizationRepository, ListingRepository listingRepository) {
        this.organizationRepository = organizationRepository;
        this.listingRepository = listingRepository;
    }

    @GetMapping("/nonProfitIndex")
    public String nonProfit(Model model) {
        model.addAttribute("organizations", organizationRepository.findAll());
        return "organizations/nonProfitIndex";
    }

    @GetMapping("/restaurant")
    public String restaurant(Model model) {
        List<Organization> orgList = organizationRepository.findAll();
//        model.addAttribute("orgAddress", organizationRepository.getOrganizationAddress(""));

        ArrayList<Organization> orgListAL = new ArrayList<Organization>();
//
        orgListAL.add(organizationRepository.getById(1));
        orgListAL.add(organizationRepository.getById(2));
        System.out.println(orgListAL);

        model.addAttribute("organizations", orgList);
        model.addAttribute("organizationsForJS", orgListAL);
        model.addAttribute("test", "Hello World");
//        List<Organization> organizationList = organizationRepository.findAll();
//        model.addAttribute("usersForJS", user);
//        model.addAttribute("organizationsForJS", List<Organization> organizationList);
        System.out.println(orgList);
        return "organizations/restaurant";
    }

    @GetMapping("/organizations/create")
    public String create(Model model) {
        model.addAttribute("organization", new Organization());
        return "organizations/create";
    }

    //if any of the fields are empty in the registration form then return back to the create page
    //need to implement errors for which data point is not correct
    @PostMapping("/organizations/create")
    public String post(@ModelAttribute Organization organization) {
//        organization.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        if(organization.getOrgName().equals("") ||
                organization.getOrgDescription().equals("") ||
                organization.getOrgStAddress().equals("") ||
                organization.getOrgCity().equals("") ||
                organization.getOrgState().equals("") ||
//                organization.isDonor() == false ||
                (organization.getOrgZip() == 0))
        {

            return "organizations/create";
        }

        organizationRepository.save(organization);
        return "redirect:/organizations/nonProfitIndex"; //still need to build out this single-org-index-page
    }

    @GetMapping("organizations/orgShow")
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
        model.addAttribute("listings", listingRepository.findAll());
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "users/profile";
    }

}