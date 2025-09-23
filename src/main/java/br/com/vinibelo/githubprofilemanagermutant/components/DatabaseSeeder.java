package br.com.vinibelo.githubprofilemanagermutant.components;

import br.com.vinibelo.githubprofilemanagermutant.services.GitHubUsersService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private final GitHubUsersService gitHubUsersService;

    public DatabaseSeeder(GitHubUsersService gitHubUsersService) {
        this.gitHubUsersService = gitHubUsersService;
    }

    @Override
    public void run(String... args) throws Exception {
        gitHubUsersService.populateDatabase();
    }
}
