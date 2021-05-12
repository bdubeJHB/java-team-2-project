package za.co.bbd.softhelp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import za.co.bbd.softhelp.Models.Client;

@Controller
public class EndpointController {
    @GetMapping("/wtf")
    String landingPage(Model model){
        return "index";
    }

    @PostMapping("/login")
    String logUserIn(Model model, @ModelAttribute Client client){
        model.addAttribute("client", client);
        return "home";
    }
}
