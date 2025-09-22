package br.com.vinibelo.githubprofilemanagermutant.controllers.dto.users;

import java.math.BigInteger;

public record UsersToListDto(
        BigInteger id,
        String login,
        String url
) { }
