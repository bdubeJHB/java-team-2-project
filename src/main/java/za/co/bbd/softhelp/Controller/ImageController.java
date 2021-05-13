package za.co.bbd.softhelp.Controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ImageController {
    @RequestMapping(value="/img/logo.png", method= RequestMethod.GET,
            produces=MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getLogo() throws IOException {
        var logo = new ClassPathResource("static/img/logo.png");
        byte[] logoBytes = StreamUtils.copyToByteArray(logo.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(logoBytes);
    }

    @RequestMapping(value="/img/google_signin.png", method= RequestMethod.GET,
            produces=MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getGoogleSignInImage() throws IOException {
        var signInImage = new ClassPathResource("static/img/google_signin.png");
        byte[] signInImageBytes = StreamUtils.copyToByteArray(signInImage.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(signInImageBytes);
    }

    @RequestMapping(value="/img/favicon.png", method= RequestMethod.GET,
            produces=MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getFavicon() throws IOException {
        var favicon = new ClassPathResource("static/img/favicon.png");
        byte[] faviconBytes = StreamUtils.copyToByteArray(favicon.getInputStream());

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(faviconBytes);
    }
}
