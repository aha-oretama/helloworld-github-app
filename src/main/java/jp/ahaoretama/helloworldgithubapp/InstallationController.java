package jp.ahaoretama.helloworldgithubapp;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.Date;

/**
 * @author aha-oretama
 */
@RestController
@RequiredArgsConstructor
@Log4j2
public class InstallationController {

    private final ResourceLoader resourceLoader;

    private final RestTemplate restTemplate;

    private static final long EXPIRATION_TIME = 10 * 60 * 1000; // 10 minute.
    private static final long TIME_DELTA = 5 * 5 * 1000; // 5 second.

    @GetMapping("valid")
    public String getValid() throws IOException, GeneralSecurityException {
        String jwt = Jwts.builder().setIssuer("9674")
                .setIssuedAt(new Date(System.currentTimeMillis() - TIME_DELTA))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.RS256, getPrivateKey())
                .compact();

        log.info(jwt);

        // TODO: 毎回であればRestTemplateConfigurationへ移行
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization","Bearer " + jwt);
        httpHeaders.add("Accept","application/vnd.github.machine-man-preview+json");

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> exchange = restTemplate.exchange("https://api.github.com/app/installations", HttpMethod.GET, entity, String.class);
        return exchange.getBody();
    }

    private PrivateKey getPrivateKey() throws IOException, GeneralSecurityException {
        Resource resource = resourceLoader.getResource("classpath:priv8.pem");
        return EncryptionUtil.getPrivateKey(Paths.get(resource.getURI()));
    }
}
