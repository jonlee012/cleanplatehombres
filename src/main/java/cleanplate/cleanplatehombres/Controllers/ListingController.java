package cleanplate.cleanplatehombres.Controllers;

import cleanplate.cleanplatehombres.Repositories.ListingRepository;
import cleanplate.cleanplatehombres.Repositories.OrganizationRepository;
import cleanplate.cleanplatehombres.Repositories.UserRepository;
import cleanplate.cleanplatehombres.models.Listing;
import cleanplate.cleanplatehombres.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ListingController {

    private final ListingRepository listingRepository;
    private final UserRepository userDao;
    private final OrganizationRepository organizationRepository;
    private final EmailService emailService;

    public ListingController(ListingRepository listingRepository, UserRepository userDao,
                             OrganizationRepository organizationRepository,
                             EmailService emailService) {

        this.listingRepository = listingRepository;
        this.userDao = userDao;
        this.organizationRepository = organizationRepository;
        this.emailService = emailService;
    }

    //listing index controller
    @GetMapping("/listings")
    public String index(Model model) {
        model.addAttribute("listings", listingRepository.findAll());
        return "listings/listings";
    }

   //create controller
    @GetMapping("/listings/create")
    public String create(Model model) {
        model.addAttribute("listing", new Listing());
        model.addAttribute("organizations", organizationRepository.findAll());
            return "listings/create";
    }

    @PostMapping("listings/create")
    public String post(@ModelAttribute Listing listing) {
        listing.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        if(listing.getFoodName().equals("") || listing.getDonationDescription().equals("")){
            return "listings/create";
        }

        listingRepository.save(listing);
        emailService.prepareAndSend(listing, "donation listing created", "Confirmation: your donation listing has " +
                "been created");
        return "redirect:/listings";
    }

   //show controller
    @GetMapping("listings/show/{id}")
    public String showPage(@PathVariable Integer id, Model model) {
        model.addAttribute("listing", listingRepository.getById(id));
        return "listings/show";
    }

    //edit controllerid
    @GetMapping("listings/edit/{id}")
    public String editListing(@PathVariable Integer id, Model model) {
        model.addAttribute("listing", listingRepository.getById(id));
        model.addAttribute("currentUser", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "listings/edit";
    }

    @PostMapping("listings/edit/{id}")
   public String editListing(@PathVariable Integer id, @RequestParam(name="foodName") String foodName,
                             @RequestParam(name="foodAmt") String foodAmt,
                             @RequestParam(name="donationDescription") String donationDescription){
        Listing listing = listingRepository.getById(id);
        listing.setFoodName(foodName);
        listing.setFoodAmt(foodAmt);
        listing.setDonationDescription(donationDescription);
        listingRepository.save(listing);
        return "redirect:/listings";
    }





    @GetMapping("listings/delete/{id}")
    public String delete(@ModelAttribute Listing listing) {
       listingRepository.delete(listing);
        return "redirect:/listings";
    }

//    @GetMapping("/error")
//    public String error(){
//        return "/error/500.html";
//    }



}
