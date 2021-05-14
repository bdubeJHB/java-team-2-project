package za.co.bbd.softhelp.auth;

import java.security.Principal;

public class GoogleAuthResponse {
    private final String response;
    private String email;
    private String profilePicLink;

    public GoogleAuthResponse(Principal p) {
        this.response = p.toString();
        setEmail();
        setProfilePicLink();
    }

    public void setEmail() {
        String trimmedResponse = response;
        int emailStartIndex = trimmedResponse.indexOf("email=") + 6;
        trimmedResponse = trimmedResponse.substring(emailStartIndex);

        int emailEndIndex = trimmedResponse.indexOf("}],");
        trimmedResponse = trimmedResponse.substring(0, emailEndIndex);

        email = trimmedResponse;
    }

    public void setProfilePicLink() {
        String trimmedResponse = response;
        int picStartIndex = trimmedResponse.indexOf("picture=") + 8;
        trimmedResponse = trimmedResponse.substring(picStartIndex);

        int picEndIndex = trimmedResponse.indexOf(",");
        trimmedResponse = trimmedResponse.substring(0, picEndIndex);

        profilePicLink = trimmedResponse;
    }

    public String getEmail() {
        return this.email;
    }

    public String getProfilePicLink() {
        return this.profilePicLink;
    }
}
