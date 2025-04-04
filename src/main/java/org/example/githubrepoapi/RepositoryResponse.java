package org.example.githubrepoapi;

import java.util.List;

public class RepositoryResponse {

    private String name;
    private String owner_login;
    private List<GitHubBranch> branches;

    public RepositoryResponse(String name, String owner_login, List<GitHubBranch> branches) {
        this.name = name;
        this.owner_login = owner_login;
        this.branches = branches;
    }

    public String getName() {
        return name;
    }

    public String getOwner_login() {
        return owner_login;
    }

    public List<GitHubBranch> getBranches() {
        return branches;
    }
}
