package br.com.vinibelo.githubprofilemanagermutant.services;

import br.com.vinibelo.githubprofilemanagermutant.entities.Profile;
import br.com.vinibelo.githubprofilemanagermutant.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfilesService {
    private final ProfileRepository profileRepository;

    public ProfilesService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public void createProfile(String name, String url, Optional<Long> userId) {
        Profile profile = new Profile(name, url);
        profileRepository.save(profile);
    }
}
