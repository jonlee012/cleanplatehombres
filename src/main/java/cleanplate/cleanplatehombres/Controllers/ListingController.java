package cleanplate.cleanplatehombres.Controllers;

import cleanplate.cleanplatehombres.Repositories.ListingRepository;
import cleanplate.models.Listing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ListingController {

    private final ListingRepository listingRepository;

    public ListingController(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    @GetMapping("/listings")
    public String index(Model model) {
        model.addAttribute("listings", listingRepository.findAll());
        return "listings/index";
    }

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

    @GetMapping("listings/show")
    public String showPage() {
        return "listings/show";
    }



}
