package jp.ahaoretama.helloworldgithubapp;

import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aha-oretama
 */
@RestController
@RequiredArgsConstructor
public class HelloController {

    private final CommentService commentService;

    @GetMapping("ping")
    public Map<String ,String> ping() {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", "Ping is OK");
        return response;
    }

    @PostMapping(value = "hello-world")
    public Map<String, String> helloWorld(@RequestHeader(value = "X-GitHub-Event", required = false) String eventType, @RequestBody(required = false) Event event) throws IOException, GeneralSecurityException {
        HashMap<String, String> response = new HashMap<>();

        // コメントかどうか？
        if(StringUtils.isEmpty(eventType) || !eventType.equals("pull_request_review_comment")) {
            response.put("message", "Event is not pull_request_review_comment");
            return response;
        }

        // 対象のコメントかどうか？
        if (!event.getAction().equals("created") || !event.getComment().getBody().toLowerCase().startsWith("hello")) {
            response.put("message", "This comment event is not a target");
            return response;
        }

        boolean isCreated = commentService.createComment(event);

        Map<String, String> message = new HashMap<>();
        message.put("message", isCreated ? "Comment succeeded." : "Comment Failed.");
        return message;
    }

}
