package za.co.bbd.softhelp.auth;

import java.security.Principal;

public class GoogleAuthResponse {
    private String email;

    public GoogleAuthResponse(Principal p) {
        setEmail(p);
    }

    public void setEmail(Principal principal) {
        String response = principal.toString();
        System.out.println(response);

        int emailStartIndex = response.indexOf("email=") + 6;
        response = response.substring(emailStartIndex);

        int emailEndIndex = response.indexOf("}],");
        response = response.substring(0, emailEndIndex);

        email = response;
    }

    public String getEmail() {
        return email;
    }
}
