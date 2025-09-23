package br.com.vinibelo.githubprofilemanagermutant.repositories.github;

import br.com.vinibelo.githubprofilemanagermutant.repositories.dto.GitHubUserDto;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class GitHubUsersApiClientImpl implements GitHubUsersApiClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiUrl = "https://api.github.com/users";

    @Override
    public List<GitHubUserDto> listUsers() {
        GitHubUserDto[] users = restTemplate.getForObject(apiUrl, GitHubUserDto[].class);
        return users != null ? Arrays.asList(users) : Collections.emptyList();
    }
}
