package org.example.githubrepoapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GitHubService {

    private final GitHubClient gitHubClient;

    public List<RepositoryResponse> getUserRepositories(String username){

        List<GitHubRepository> repositories = gitHubClient.fetchUserRepositories(username);

        return repositories.stream()
                .filter(repo -> !repo.isFork())
                .map(repo -> new RepositoryResponse(
                        repo.getName(),
                        repo.getOwner() != null ? repo.getOwner().getLogin() : "unknown",
                        gitHubClient.fetchUserBranches(username, repo.getName())
                ))
                .toList();

    }

}
