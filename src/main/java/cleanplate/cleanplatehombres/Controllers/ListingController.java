package cleanplate.cleanplatehombres.Controllers;

import cleanplate.cleanplatehombres.Repositories.ListingRepository;
import cleanplate.cleanplatehombres.models.Listing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ListingController {

    private final ListingRepository listingRepository;

    public ListingController(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }


    //listing index controller
    @GetMapping("/listings")
    public String index(Model model) {
        model.addAttribute("listings", listingRepository.findAll());
        return "listings/index";
    }


   //create controller
    @GetMapping("/listings/create")
    public String create(Model model) {
        model.addAttribute("listing", new Listing());
            return "listings/create";
    }

    @PostMapping("listings/create")
    public String post(@ModelAttribute Listing listing) {
        if(listing.getFood_name().equals("") || listing.getDonation_description().equals("")){
            return "listings/create";
        }

        listingRepository.save(listing);
        return "redirect:/listings";
    }

   //show controller
    @GetMapping("listings/show")
    public String showPage() {
        return "listings/show";
    }

    //edit controller
    @GetMapping("listings/edit/{id}")
    public String editListing(@PathVariable long id, Model model) {
        Listing editListing = listingRepository.getById(id);
        model.addAttribute("listingToEdit", editListing);
        return "listings/edit";
    }

//    @PostMapping("listings/edit/{id}")
//    public String saveEditedListing(@PathVariable long id,
//                                    @RequestParam(name="donation_description") String donation_description){
//        Listing listingToEdit = listingRepository.getById(id);
//        listingToEdit.setDonation_description(listingDonation_description);
//        listingToEdit.setFood_name(listingFood_name);
//        listingRepository.save(listingToEdit);
//        return "redirect:/listings";
//    }
//
}
