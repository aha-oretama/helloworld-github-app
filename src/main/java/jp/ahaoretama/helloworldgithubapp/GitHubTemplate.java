package jp.ahaoretama.helloworldgithubapp;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aha-oretama
 */
@Repository
@RequiredArgsConstructor
@Slf4j
public class GitHubTemplate {

    private final RestTemplate restTemplate;
    private final ResourceLoader resourceLoader;

    private static final long EXPIRATION_TIME = 30 * 1000; // 30 second.
    private static final long TIME_DELTA = 5 * 1000; // 5 second.

    public Token getAuthToken(String installationId) throws IOException, GeneralSecurityException {
        String jwt = getJwt();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Bearer " + jwt);

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Token> response = restTemplate.exchange(String.format("https://api.github.com/installations/%s/access_tokens", installationId), HttpMethod.GET, requestEntity, Token.class);
        return response.getBody();
    }

    public boolean postReplyComment(Event event, Token token) {
        Map<String, Object> args = new HashMap<>();
        args.put("body", "World!");
        args.put("in_reply_to", event.getComment().getId());

        RequestEntity requestEntity = RequestEntity.
                post(URI.create(event.getPullRequest().getReviewCommentsUrl()))
                .header("Authorization", "token " + token.getToken())
                .body(args);

        ResponseEntity<Object> exchange = restTemplate.exchange(requestEntity, Object.class);

        return exchange.getStatusCode() == HttpStatus.CREATED;
    }

    public String getInstallation() throws IOException, GeneralSecurityException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Bearer " + getJwt());

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> exchange = restTemplate.exchange("https://api.github.com/app/installations", HttpMethod.GET, entity, String.class);
        return exchange.getBody();
    }

    private PrivateKey getPrivateKey() throws IOException, GeneralSecurityException {
        Resource resource = resourceLoader.getResource("classpath:priv8.pem");
        return EncryptionUtil.getPrivateKey(Paths.get(resource.getURI()));
    }

    private String getJwt() throws IOException, GeneralSecurityException {
        String jwt = Jwts.builder().setIssuer("9674")
                .setIssuedAt(new Date(System.currentTimeMillis() - TIME_DELTA))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.RS256, getPrivateKey())
                .compact();
        log.info(jwt);
        return jwt;
    }
}
