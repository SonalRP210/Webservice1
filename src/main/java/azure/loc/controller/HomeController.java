//package azure.loc.controller;
//
////import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
////import org.springframework.security.core.annotation.AuthenticationPrincipal;
////import com.trade.finance.loc.model.User;
//import azure.loc.model.User;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDateTime;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
////@EnableOAuth2Sso
//public class HomeController {
//
//    //@Value("${spring.application.name:CBSService}") OR
//    @Value("${spring.application.name}")
//    private String name;
//
//    private Map<String, LocalDateTime> usersLastAccess = new HashMap<>();
//
//    @GetMapping("/login")
//    public String getCurrentUser(/*@AuthenticationPrincipal*/ User user, Model model) {
//        String username = user.getUsername();
//
////        model.addAttribute("email", email);
////        model.addAttribute("lastAccess", usersLastAccess.get(email));
////        model.addAttribute("firstName", user.getGivenName());
////        model.addAttribute("lastName", user.getFamilyName());
////
////        usersLastAccess.put(email, LocalDateTime.now());
//
//        return "Hi " + username + "! Welcome.";
//    }
//
//    @GetMapping("/hello")
//    public String hello()
//    {
//        return "Hello! " + name;
//    }
//}
