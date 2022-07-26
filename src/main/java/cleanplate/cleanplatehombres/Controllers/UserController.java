package cleanplate.cleanplatehombres.Controllers;

import cleanplate.cleanplatehombres.Repositories.ListingRepository;
import cleanplate.cleanplatehombres.Repositories.OrganizationRepository;
import cleanplate.cleanplatehombres.Repositories.UserRepository;
import cleanplate.cleanplatehombres.models.Listing;
import cleanplate.cleanplatehombres.models.Organization;
import cleanplate.cleanplatehombres.models.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {
    private ListingRepository listingRepository;
    private OrganizationRepository organizationRepository;
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder, ListingRepository listingRepository, OrganizationRepository organizationRepository) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.listingRepository = listingRepository;
        this.organizationRepository = organizationRepository;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model) {
        model.addAttribute("title", "Sign Up Page");
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user) {
        System.out.println(user.getPassword());
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        System.out.println(user.getPassword());
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String userLogout() {
        return "redirect:/login";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userDao.getById(id));
        model.addAttribute("currentUser", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "users/edit";
    }

    @PostMapping("users/edit")
    public String editListing(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        System.out.println(user.getPassword());
        userDao.save(user);
        return "redirect:/profile";
    }

    @GetMapping("users/delete/{id}")
    public String deleteUserProfile(@ModelAttribute Listing listing, Organization organization, User user) {
        listingRepository.delete(listing);
        organizationRepository.delete(organization);
        userDao.delete(user);
        return "redirect:/users/sign-up";
    }
}