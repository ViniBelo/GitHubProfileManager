package br.com.vinibelo.githubprofilemanagermutant.services;

import br.com.vinibelo.githubprofilemanagermutant.controllers.dto.users.ListUsersDto;
import br.com.vinibelo.githubprofilemanagermutant.controllers.dto.users.RoleDto;
import br.com.vinibelo.githubprofilemanagermutant.controllers.dto.users.UsersToListDto;
import br.com.vinibelo.githubprofilemanagermutant.entities.User;
import br.com.vinibelo.githubprofilemanagermutant.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ListUsersDto listUsers() {
        ListUsersDto response = new ListUsersDto(new ArrayList<UsersToListDto>());
        List<User> usersList = userRepository.findAll();
        usersList.forEach((user) ->
                response.users().add(
                        new UsersToListDto(
                                user.getId(),
                                user.getLogin(),
                                user.getUrl(),
                                user.getRoles().stream().map((role -> new RoleDto(role.getName()))).toList()
                        )
                )
        );
        return response;
    }
}
