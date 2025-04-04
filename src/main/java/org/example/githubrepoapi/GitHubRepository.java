package org.example.githubrepoapi;

public class GitHubRepository {

    private String name;
    private Owner owner;
    private boolean isFork;

    public GitHubRepository(String name, Owner owner, boolean isFork) {
        this.name = name;
        this.owner = owner;
        this.isFork = isFork;
    }

    public String getName() {
        return name;
    }

    public Owner getOwner() {
        return owner;
    }

    public boolean isFork() {
        return isFork;
    }
}
