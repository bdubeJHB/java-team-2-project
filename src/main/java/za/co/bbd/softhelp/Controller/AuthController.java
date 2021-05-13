//package za.co.bbd.softhelp.Controller;
//
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import za.co.bbd.softhelp.auth.GoogleAuthResponse;
//
//import java.security.Principal;
//
//@RestController
//public class AuthController {
//    @RequestMapping(value="/sign-in")
////    @ResponseBody
//    public String authorize(Principal principal) {
//        GoogleAuthResponse response = new GoogleAuthResponse(principal);
//
//        return response.getEmail();
//    }
//}
