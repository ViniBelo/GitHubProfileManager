package br.com.vinibelo.githubprofilemanagermutant.services;

import br.com.vinibelo.githubprofilemanagermutant.entities.Role;
import br.com.vinibelo.githubprofilemanagermutant.entities.User;
import br.com.vinibelo.githubprofilemanagermutant.repositories.RoleRepository;
import br.com.vinibelo.githubprofilemanagermutant.repositories.UserRepository;
import br.com.vinibelo.githubprofilemanagermutant.repositories.dto.GitHubUserDto;
import br.com.vinibelo.githubprofilemanagermutant.repositories.github.GitHubUsersApiClientImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GitHubUsersService {
    private final GitHubUsersApiClientImpl gitHubUsersApiClient;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public GitHubUsersService(GitHubUsersApiClientImpl gitHubUsersApiClient,
                              UserRepository userRepository, RoleRepository roleRepository) {
        this.gitHubUsersApiClient = gitHubUsersApiClient;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void populateDatabase() {
        List<GitHubUserDto> gitHubUsersDtos = gitHubUsersApiClient.listUsers();
        if (gitHubUsersDtos.isEmpty()) return;
        List<User> users = new ArrayList<>();
        gitHubUsersDtos.forEach(gitHubUserDto -> {
            Role role = getRole(gitHubUserDto.type());
            if (!userExists(gitHubUserDto.login())) {
                User user = new User(gitHubUserDto.login(),
                        gitHubUserDto.url(),
                        List.of(role));
                users.add(user);
            }
        });
        userRepository.saveAll(users);
    }

    private Role getRole(String roleName) {
        return roleExists(roleName) ? roleRepository.findByName(roleName) : createRole(roleName);
    }

    private boolean roleExists(String roleName) {
        return roleRepository.existsRolesByName((roleName));
    }

    private boolean userExists(String login) {
        return userRepository.existsUserByLogin(login);
    }

    private Role createRole(String roleName) {
        Role role = new Role(roleName);
        return roleRepository.save(role);
    }
}
