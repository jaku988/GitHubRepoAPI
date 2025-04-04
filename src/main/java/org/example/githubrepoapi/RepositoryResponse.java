package org.example.githubrepoapi;

import java.util.List;

public class RepositoryResponse {

    private String name;
    private String ownerLogin;
    private List<GitHubBranch> branches;

    public RepositoryResponse(String name, String ownerLogin, List<GitHubBranch> branches) {
        this.name = name;
        this.ownerLogin = ownerLogin;
        this.branches = branches;
    }

    public String getName() {
        return name;
    }

    public String getOwnerLogin() {
        return ownerLogin;
    }

    public List<GitHubBranch> getBranches() {
        return branches;
    }
}
