package br.com.vinibelo.githubprofilemanagermutant.controllers;

import br.com.vinibelo.githubprofilemanagermutant.controllers.dto.profiles.AssignOwnerDto;
import br.com.vinibelo.githubprofilemanagermutant.controllers.dto.profiles.CreateProfileDto;
import br.com.vinibelo.githubprofilemanagermutant.services.ProfilesService;
import br.com.vinibelo.githubprofilemanagermutant.services.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profiles")
public class ProfilesController {
    private final ProfilesService profilesService;

    public ProfilesController(ProfilesService profilesService) {
        this.profilesService = profilesService;
    }

    @PostMapping
    public ResponseEntity<Void> createProfiles(@RequestBody CreateProfileDto createProfileDto) {
        try {
            profilesService.createProfile(createProfileDto.name(),
                    createProfileDto.url(),
                    createProfileDto.userId());
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> assignProfileOwner(@PathVariable("id") Long id,
                                                   @RequestBody AssignOwnerDto assignOwnerDto) {
        try {
            profilesService.assignProfileOwner(id, assignOwnerDto.userId());
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
