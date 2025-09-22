package br.com.vinibelo.githubprofilemanagermutant.controllers.dto.users;

import java.util.List;

public record ListUsersDto(
        List<UsersToListDto> users
) { }
