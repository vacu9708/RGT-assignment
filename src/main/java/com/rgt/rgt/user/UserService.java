package com.rgt.rgt.user;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rgt.rgt.user.utils.JwtUtils;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserService {
    final UserRepository userRepository;
    @Value("${google.client_secret}") String client_secret;

    String OAuthGoogleCallback(String code) {
        // Get access token from code
        String client_id="&client_id=974689523976-2fodc0j4g72b5qma4cc4ppsk1dft50f4.apps.googleusercontent.com";
        String tokenResponse = WebClient.create("https://oauth2.googleapis.com")
            .post().uri("/token?code=" + code+client_id+client_secret+"&redirect_uri=http://localhost:8080/OAuth/google/callback"+"&grant_type=authorization_code")
            .retrieve()
            .bodyToMono(String.class)
            .block();
        String id_token="";
        try {
            id_token = new ObjectMapper().readTree(tokenResponse).get("id_token").asText();
        } catch (Exception e){
            e.printStackTrace();
        }
        // A dot in a regular string is just a dot.
        // A dot in a regular expression matches any character.
        // To match a literal dot in a regular expression, you escape it with a backslash: \..
        // To include a backslash in a Java string, you escape it with another backslash: \\.
        // Convert id_token base64 to json
        String id_token_decoded = new String(java.util.Base64.getDecoder().decode(id_token.split("\\.")[1]), java.nio.charset.StandardCharsets.UTF_8);
    
        // Get email from json
        JsonNode id_token_object=null;
        try {
            id_token_object = new ObjectMapper().readTree(id_token_decoded);
        } catch (Exception e){
            e.printStackTrace();
        }

        // Register the user if the email does not exist
        UserEntity userEntity = userRepository.findByEmail(id_token_object.get("email").asText());
        UUID id;
        if (userEntity == null) {
            id = UUID.randomUUID();
            userRepository.insertUser(id, id_token_object.get("email").asText(), id_token_object.get("name").asText());
        }
        else
            id = userEntity.getId();
        // Generate access token
        Map<String, Object> accessTokenClaims = new HashMap<>();
        accessTokenClaims.put("userId", id);
        String accessToken = JwtUtils.generateToken(accessTokenClaims, 1800000);
        return accessToken;
    }
}
