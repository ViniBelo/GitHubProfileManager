package br.com.vinibelo.githubprofilemanagermutant.controllers;

import br.com.vinibelo.githubprofilemanagermutant.controllers.dto.profiles.CreateProfileDto;
import br.com.vinibelo.githubprofilemanagermutant.services.ProfilesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profiles")
public class ProfilesController {
    private final ProfilesService profilesService;

    public ProfilesController(ProfilesService profilesService) {
        this.profilesService = profilesService;
    }

    @PostMapping
    public ResponseEntity<Void> createProfiles(@RequestBody CreateProfileDto createProfileDto) {
        profilesService.createProfile(createProfileDto.name(),
                createProfileDto.url(),
                createProfileDto.userId());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }
}
