//package cleanplate.cleanplatehombres.Controllers;
//
//import cleanplate.cleanplatehombres.models.Organization;
//import cleanplate.cleanplatehombres.models.User;
//import cleanplate.cleanplatehombres.Repositories.OrganizationRepository;
//import cleanplate.cleanplatehombres.Repositories.UserRepository;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.repository.query.Param;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//
//
//@Controller
//public class BusinessController {
//
//
//    UserRepository userDao;
//    OrganizationRepository organizationDao;
//
////    @Value("${pk.eyJ1Ijoiam9ubGVlMDEyIiwiYSI6ImNsNWw0dG5pNzBkbTYzanB4NWlnaDVwd2MifQ.eDtDtr7ygeb9fFyujvva2A}")
////    private String apiKey;
//
//    public BusinessController(UserRepository userDao, OrganizationRepository organizationDao) {
//        this.userDao = userDao;
//        this.organizationDao = organizationDao;
//    }
//
//
//    @GetMapping("/profile/organization")
//    public String organizationProfile(Model model) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        List<Organization> organizations = organizationDao.getOrganizationByUser(user);
//        model.addAttribute("organization", organizations);
////        model.addAttribute("images", organizations.getOrganizationImages());
////        if (organization.isDonor()) {
////
////        }
//        return "organizationProfile";
//    }
//
//
//    @GetMapping("/updateOrganization")
//    public String updateProfile(Model model) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        List<Organization> organizations = organizationDao.getOrganizationByUser(user);
//        model.addAttribute("user", user);
//        model.addAttribute("organization", organizations);
//        return "updateOrganization";
//    }
//
//
//    @PostMapping(value = "/updateOrganization/{id}", params = {"imageUrl"})
//    public String postUpdateProfile(Model model, @ModelAttribute Organization organization, BindingResult result, @PathVariable Integer id, @RequestParam(value = "imageUrl", required = false) String imageUrl) {
//
//        if (result.hasErrors()) {
//            organization.setId(id);
//            return "updateOrganization";
//        }
//        if (imageUrl != null) {
//            organization.setImages(imageUrl);
//        }
//        System.out.println("organization.getOrgName() = " + organization.getOrgName());
//        System.out.println("organization.getOrgStAddress() = " + organization.getOrgStAddress());
//        System.out.println("organization.getOrgCity() = " + organization.getOrgCity());
//        System.out.println("organization.getOrganizationImages() =" + organization.getImages());
//        organizationDao.save(organization);
//        return "redirect:/profile/organization";
//    }
//
////    @GetMapping("/organization/{id}")
////    public String singleOrganizationProfile(Model model, @PathVariable String id) {
////        Organization organization = organizationDao.getOrganizationById((int) Long.parseLong(id));
////        model.addAttribute("organization", organization);
////        return "viewOrganization";
////    }
//
//
//    @GetMapping("/search")
//    public String search(Model model, @Param("keyword") String keyword) {
//        model.addAttribute("apiKey", "pk.eyJ1Ijoiam9ubGVlMDEyIiwiYSI6ImNsNWw0dG5pNzBkbTYzanB4NWlnaDVwd2MifQ.eDtDtr7ygeb9fFyujvva2A");
//        model.addAttribute("organization", organizationDao.findAll());
//        System.out.println("keyword = " + keyword);
////        if (keyword != null) {
////            model.addAttribute("apiKey", apiKey);
////            model.addAttribute("organization", organizationDao.getAllByNameContaining(keyword));
////        } else {
////
////        }
//        return "home";
//    }
//
//
//
//}
//
//
