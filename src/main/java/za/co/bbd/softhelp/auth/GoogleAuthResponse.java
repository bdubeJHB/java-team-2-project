package za.co.bbd.softhelp.auth;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.security.Principal;
import java.util.HashMap;

public class GoogleAuthResponse {
    private Principal principal;
    Gson gson = new Gson();

    public GoogleAuthResponse(Principal principal) {
        this.principal = principal;
    }

    public String getEmail() {
        String response = principal.toString();
        System.out.println(response);

        int emailStartIndex = response.indexOf("email=") + 6;
        response = response.substring(emailStartIndex);

        int emailEndIndex = response.indexOf("}],");
        response = response.substring(0,emailEndIndex);

        return response;
    }
}
