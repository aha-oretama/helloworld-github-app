package jp.ahaoretama.helloworldgithubapp;

import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    @PostMapping("hello-world")
    public Map<String,String> helloWorld(@RequestHeader(value = "X-GitHub-Event",required = false) String event) {
        HashMap<String, String> response = new HashMap<>();
        if(StringUtils.isEmpty(event) || !event.equals("pull_request_review_comment")) {
            response.put("message", "Event is not pull_request_review_comment");
            return response;
        }

        commentService.createComment();

        response.put("message", "Commented to pull request");
        return response;
    }

}
