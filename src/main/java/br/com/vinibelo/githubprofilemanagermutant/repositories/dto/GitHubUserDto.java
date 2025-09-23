package br.com.vinibelo.githubprofilemanagermutant.repositories.dto;

public record GitHubUserDto(
        String login,
        String url,
        String type
) { }
