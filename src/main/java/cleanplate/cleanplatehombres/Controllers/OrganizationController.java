package cleanplate.cleanplatehombres.Controllers;

import cleanplate.cleanplatehombres.Repositories.ListingRepository;
import cleanplate.cleanplatehombres.Repositories.OrganizationRepository;
import cleanplate.cleanplatehombres.Repositories.UserRepository;
import cleanplate.cleanplatehombres.models.Organization;
import cleanplate.cleanplatehombres.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class OrganizationController {

    private final OrganizationRepository organizationRepository;
    private final ListingRepository listingRepository;
    private final UserRepository userDao;


    public OrganizationController(OrganizationRepository organizationRepository, ListingRepository listingRepository,
                                    UserRepository userDao) {
        this.organizationRepository = organizationRepository;
        this.listingRepository = listingRepository;
        this.userDao = userDao;
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

    // THIS IS A TESTING ENDPOINT FOR MY FILESTACK
    @GetMapping("/organizations/create2")
    public String create2(Model model) {
        model.addAttribute("organization", new Organization());
        return "organizations/create_filestackCodeBase";
    }




    //if any of the fields are empty in the registration form then return back to the create page
    //need to implement errors for which data point is not correct
    @PostMapping("/organizations/create")
    public String post(@ModelAttribute Organization organization) {
        organization.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        if(organization.getOrgName().equals("") ||
                organization.getOrgDescription().equals("") ||
                organization.getOrgStAddress().equals("") ||
                organization.getOrgCity().equals("") ||
                organization.getOrgState().equals("") ||
//                organization.getDonor() == true ||
                (organization.getOrgZip() == 0))
        {

            return "organizations/create";
        }

        organizationRepository.save(organization);
        return "redirect:/profile"; //still need to build out this single-org-index-page
    }

    @GetMapping("organizations/orgShow")
    public String showPage() {
        return "organizations/orgShow";
    }

    @GetMapping("organizations/edit/{id}")
    public String updateOrgForm(@PathVariable Integer id, Model model) {
        model.addAttribute("organization", organizationRepository.getById(id));

        return "organizations/edit";
    }


    @PostMapping("organizations/edit/{id}")
    public String updateOrganization(@PathVariable Integer id, @ModelAttribute Organization organization) {
        Organization org2update = organizationRepository.getById(id);
        System.out.println(org2update + "org2Update");
//        org2update.setId(organization.getId());
        org2update.setOrgName(organization.getOrgName());
        org2update.setOrgDescription(organization.getOrgDescription());
        org2update.setOrgStAddress(organization.getOrgStAddress());
        org2update.setOrgCity(organization.getOrgCity());
        org2update.setOrgState(organization.getOrgState());
        org2update.setOrgZip(organization.getOrgZip());

    org2update.getListingList().clear();
    org2update.getListingList().addAll(listingRepository.findAllByOrganizationId(id));

        org2update.setImages(organization.getImages());

//        User user = userDao.findAll().get(0);
        org2update.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//        organization.setUser(user);

        organizationRepository.save(org2update);
        return "redirect:/profile";
    }


    @PostMapping("organizations/edit")

    public String editOrganization(@ModelAttribute Organization organization) {
        organizationRepository.save(organization);
        return "redirect:/profile";

//    public String editOrganization(@ModelAttribute Organization organization, Integer id){
//        organizationRepository.updateOrg(id);
//        organizationRepository.deleteById(organization.getId());
//        organizationRepository.save(organization);
//        return "redirect:/nonProfitIndex";

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
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "users/profile";
    }


    @GetMapping("organizations/delete/{id}")
    public String delete(@ModelAttribute Organization organization, Integer id) {
        organizationRepository.delete(organization);
        return "redirect:/profile";
    }


}