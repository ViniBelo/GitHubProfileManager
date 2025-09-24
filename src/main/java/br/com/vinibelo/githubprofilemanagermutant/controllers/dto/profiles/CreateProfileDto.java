package br.com.vinibelo.githubprofilemanagermutant.controllers.dto.profiles;

import java.util.Optional;

public record CreateProfileDto(
        String name,
        String url,
        Optional<Long> userId
) { }
