package br.com.vinibelo.githubprofilemanagermutant.services;

import br.com.vinibelo.githubprofilemanagermutant.entities.Profile;
import br.com.vinibelo.githubprofilemanagermutant.entities.User;
import br.com.vinibelo.githubprofilemanagermutant.repositories.ProfileRepository;
import br.com.vinibelo.githubprofilemanagermutant.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProfilesServiceTests {

    @Mock
    private ProfileRepository profileRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ProfilesService profilesService;

    private User mockUser;
    private Profile mockProfile;

    @BeforeEach
    void setUp() {
        mockUser = new User("testuser", "https://github.com/testuser", null);
        mockProfile = new Profile("Test Profile", "https://github.com/testprofile");
    }

    @Test
    void shouldCreateProfile_WhenValidDataWithUserId() {
        // Given
        String name = "Test Profile";
        String url = "https://github.com/test";
        Optional<Long> userId = Optional.of(1L);

        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));
        when(profileRepository.save(any(Profile.class))).thenReturn(mockProfile);

        // When
        profilesService.createProfile(name, url, userId);

        // Then
        verify(userRepository).findById(1L);
        verify(profileRepository).save(any(Profile.class));

        verify(profileRepository).save(argThat(profile ->
                profile.getName().equals(name) &&
                        profile.getUrl().equals(url)
        ));
    }
}
