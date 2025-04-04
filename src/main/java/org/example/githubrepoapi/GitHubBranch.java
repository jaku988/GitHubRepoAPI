package org.example.githubrepoapi;

public class GitHubBranch {

    private String name;
    private String lastCommitSha;

    public GitHubBranch(String name, String lastCommitSha) {
        this.name = name;
        this.lastCommitSha = lastCommitSha;
    }

    public String getName() {
        return name;
    }

    public String getLastCommitSha() {
        return lastCommitSha;
    }
}
