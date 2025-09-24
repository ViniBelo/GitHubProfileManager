package br.com.vinibelo.githubprofilemanagermutant.controllers.dto.users;

import java.util.List;

public record UsersToListDto(
        Long id,
        String login,
        String url,
        List<RoleDto> roles
) { }
