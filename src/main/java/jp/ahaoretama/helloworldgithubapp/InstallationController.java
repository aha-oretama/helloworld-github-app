package jp.ahaoretama.helloworldgithubapp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author aha-oretama
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class InstallationController {

    private final GitHubTemplate template;

    @GetMapping("valid")
    public String getValid() throws IOException, GeneralSecurityException {
        return template.getInstallation();
    }

}
