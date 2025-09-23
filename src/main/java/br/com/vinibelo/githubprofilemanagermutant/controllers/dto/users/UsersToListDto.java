package br.com.vinibelo.githubprofilemanagermutant.controllers.dto.users;

import java.math.BigInteger;
import java.util.List;

public record UsersToListDto(
        BigInteger id,
        String login,
        String url,
        List<RoleDto> roles
) { }
