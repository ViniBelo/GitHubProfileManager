package br.com.vinibelo.githubprofilemanagermutant.controllers.dto.profiles;

import java.util.Optional;

public record CreateProfileDto(
        String name,
        String url,
        Optional<Long> userId
) {
    public CreateProfileDto {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can not be null.");
        }
        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException("Url can not be null.");
        }
    }
}
