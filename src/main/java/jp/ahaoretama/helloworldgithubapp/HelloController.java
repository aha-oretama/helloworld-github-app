package jp.ahaoretama.helloworldgithubapp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author aha-oretama
 */
@RestController
@RequiredArgsConstructor
public class HelloController {

    @GetMapping
    public Map<String ,String> ping() {
        HashMap<String, String> response = new HashMap<>();
        response.put("ping", "OK");
        return response;
    }

    @PostMapping("/helloworld")
    public Map<String,String> helloWorld() {
        return null;
    }

}
