package jp.ahaoretama.helloworldgithubapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import jp.ahaoretama.helloworldgithubapp.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author aha-oretama
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
@Slf4j
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private CommentService service;

    @Test
    public void pingReturnOk() throws Exception {
        Map<String, String> expected = new HashMap<>();
        expected.put("message", "Ping is OK");

        this.mvc.perform(get("/ping"))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(expected)));
    }

    @Test
    public void helloWorldNotAcceptNoHeader() throws Exception {
        Map<String, String> expected = new HashMap<>();
        expected.put("message", "Event is not issue_comment");

        this.mvc.perform(post("/hello-world"))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(expected)));
    }

    @Test
    public void helloWorldNotAcceptExceptReviewComment() throws Exception {
        Map<String, String> expected = new HashMap<>();
        expected.put("message", "Event is not issue_comment");

        this.mvc.perform(post("/hello-world").header("X-GitHub-Event","pull_request"))
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(expected)));
    }

    @Test
    public void helloWorldNotWorkExceptActionCreated() throws Exception {
        // Arrange
        Event event = new Event();
        event.setAction("edited");
        String body = mapper.writeValueAsString(event);
        log.info(body);

        Map<String, String> expected = new HashMap<>();
        expected.put("message", "This comment event is not a target");

        // Act
        this.mvc.perform(post("/hello-world").header("X-GitHub-Event","issue_comment").content(body).contentType(MediaType.APPLICATION_JSON))
                // Assert
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(expected)));
    }

    @Test
    public void helloWorldNotWorkExceptHelloComment() throws Exception {
        // Arrange
        Event event = new Event();
        event.setAction("created");
        Event.Comment comment = new Event.Comment();
        comment.setBody("GoodBye");
        event.setComment(comment);
        String body = mapper.writeValueAsString(event);
        log.info(body);

        Map<String, String> expected = new HashMap<>();
        expected.put("message", "This comment event is not a target");

        // Act
        this.mvc.perform(post("/hello-world").header("X-GitHub-Event","issue_comment").content(body).contentType(MediaType.APPLICATION_JSON))
                // Assert
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(expected)));
    }

    @Test
    public void helloWorldAcceptPullRequestReviewCommentEvent() throws Exception {
        // Arrange
        Event event = new Event();
        event.setAction("created");
        Event.Comment comment = new Event.Comment();
        comment.setBody("HelloWorld");
        event.setComment(comment);
        String body = mapper.writeValueAsString(event);
        log.info(body);

        doReturn(true).when(service).createComment(event);

        Map<String, String> expected = new HashMap<>();
        expected.put("message", "Comment succeeded.");

        // Act
        this.mvc.perform(post("/hello-world").header("X-GitHub-Event","issue_comment").content(body).contentType(MediaType.APPLICATION_JSON))
        // Assert
                .andExpect(status().isOk())
                .andExpect(content().string(mapper.writeValueAsString(expected)));
        verify(service).createComment(event);
    }
}