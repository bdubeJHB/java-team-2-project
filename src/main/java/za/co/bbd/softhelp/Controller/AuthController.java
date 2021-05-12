package za.co.bbd.softhelp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {
    @RequestMapping(value="/sign-in")
    @ResponseBody
    public String authorize(Principal principal) {
        return principal.getName();
    }
}
