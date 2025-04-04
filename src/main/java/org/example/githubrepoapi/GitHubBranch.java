package org.example.githubrepoapi;

public class GitHubBranch {

    private final String name;
    private final String lastCommitSha;

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
