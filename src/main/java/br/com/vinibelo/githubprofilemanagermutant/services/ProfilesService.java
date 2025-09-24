package br.com.vinibelo.githubprofilemanagermutant.services;

import br.com.vinibelo.githubprofilemanagermutant.entities.Profile;
import br.com.vinibelo.githubprofilemanagermutant.entities.User;
import br.com.vinibelo.githubprofilemanagermutant.repositories.ProfileRepository;
import br.com.vinibelo.githubprofilemanagermutant.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfilesService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public ProfilesService(ProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    public void createProfile(String name, String url, Optional<Long> userId) {
        Profile profile = new Profile(name, url);
        if (userId.isPresent()) {
            Optional<User> user = userRepository.findById(userId.get());
            user.ifPresent(profile::setOwner);
        }
        profileRepository.save(profile);
    }
}
