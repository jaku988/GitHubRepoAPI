package org.example.githubrepoapi;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
@RequiredArgsConstructor
public class GitHubClient {

    private final String reposUrl = "https://api.github.com/users/%s/repos";
    private final String branchesUrl = "https://api.github.com/repos/%s/%/branches";
    private final RestTemplate restTemplate;

    public List<GitHubRepository> fetchUserRepositories(String username){

        String url = String.format(reposUrl, username);
        ResponseEntity<GitHubRepository[]> response = restTemplate.getForEntity(url, GitHubRepository[].class);

        try{

            return Optional.ofNullable(response.getBody())
                    .map(Arrays::asList)
                    .orElse(Collections.emptyList());

        }catch(HttpClientErrorException | HttpServerErrorException e){
            throw new CustomHttpException(e.getMessage(), e.getStatusCode().value());
        }

    }

}
