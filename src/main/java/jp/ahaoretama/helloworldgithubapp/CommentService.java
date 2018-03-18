package jp.ahaoretama.helloworldgithubapp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author aha-oretama
 */
@Service
@RequiredArgsConstructor
public class CommentService {

    private final GitHubTemplate template;

    public boolean createComment(Event event) throws IOException, GeneralSecurityException {
        Token authToken = template.getAuthToken(event.getInstallation().getId());
        return template.postReplyComment(event, authToken);
    }
}
