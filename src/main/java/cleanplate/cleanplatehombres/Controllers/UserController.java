package cleanplate.cleanplatehombres.Controllers;

import cleanplate.cleanplatehombres.Repositories.ListingRepository;
import cleanplate.cleanplatehombres.Repositories.OrganizationRepository;
import cleanplate.cleanplatehombres.Repositories.UserRepository;
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
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
//        userDao.save(user);

        User newUser = userDao.getById(user.getUserId());
        System.out.println(newUser + "newUser");
//        org2update.setId(organization.getId());
        newUser.setEmail(user.getEmail());
        newUser.setAdmin(user.getAdmin());
        String hash = passwordEncoder.encode(user.getPassword());
        newUser.setPassword(hash);
        newUser.setUsername(user.getUsername());

        newUser.getOrganizationList().clear();
        newUser.getOrganizationList().addAll(organizationRepository.findAllByUserId(user.getUserId()));

        newUser.getListingList().clear();
        newUser.getListingList().addAll(listingRepository.findAllByUserId(user.getUserId()));

        userDao.save(newUser);

        return "redirect:/logout";
    }

    @GetMapping("users/delete/{id}")
    public String delete(@ModelAttribute User user, @PathVariable Integer id) {
        userDao.deleteById(id);
//        listingRepository.delete(listing);
//        organizationRepository.delete(organization);
//        userDao.deleteUserById(id);
        return "redirect:/logout";
    }

}