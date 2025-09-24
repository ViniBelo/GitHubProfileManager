package br.com.vinibelo.githubprofilemanagermutant.controllers.dto.profiles;

import java.math.BigInteger;
import java.util.Optional;

public record CreateProfileDto(
        String name,
        String url,
        Optional<BigInteger> userId
) { }
