package za.co.bbd.softhelp.auth;

import java.security.Principal;

public class GoogleAuthResponse {
    private Principal principal;

    public GoogleAuthResponse(Principal principal) {
        this.principal = principal;
    }

    public String getEmail() {
        return "test@gmail.co.za";
    }
}
