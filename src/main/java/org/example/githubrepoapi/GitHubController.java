package org.example.githubrepoapi;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/github")
public class GitHubController {

    private final GitHubService gitHubService;

    @GetMapping("/repositories/{username}")
    public ResponseEntity<List<RepositoryResponse>> getRepositories(@PathVariable("username") String username) {
        List<RepositoryResponse> repositories = gitHubService.getUserRepositories(username);
        return ResponseEntity.ok(repositories);
    }
}
