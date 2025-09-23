package br.com.vinibelo.githubprofilemanagermutant.repositories.github;

import br.com.vinibelo.githubprofilemanagermutant.repositories.dto.GitHubUserDto;

import java.util.List;

public interface GitHubUsersApiClient {
    List<GitHubUserDto> listUsers();
}
