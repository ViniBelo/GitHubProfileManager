
package br.com.vinibelo.githubprofilemanagermutant.controllers;

import br.com.vinibelo.githubprofilemanagermutant.controllers.dto.profiles.CreateProfileDto;
import br.com.vinibelo.githubprofilemanagermutant.services.ProfilesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProfilesController.class)
class ProfilesControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProfilesService profilesService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateProfile_WhenValidData() throws Exception {
        // Given
        CreateProfileDto createProfileDto = new CreateProfileDto(
                "Test Name",
                "https://github.com/testprofile",
                Optional.of(1L)
        );

        doNothing().when(profilesService)
                .createProfile(anyString(), anyString(), any());

        // When & Then
        mockMvc.perform(post("/profiles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createProfileDto)))
                .andExpect(status().isCreated());

        verify(profilesService).createProfile(
                eq("Test Name"),
                eq("https://github.com/testprofile"),
                eq(Optional.of(1L))
        );
    }
}