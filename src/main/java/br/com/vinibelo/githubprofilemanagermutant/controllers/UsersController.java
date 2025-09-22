package br.com.vinibelo.githubprofilemanagermutant.controllers;

import br.com.vinibelo.githubprofilemanagermutant.controllers.dto.users.ListUsersDto;
import br.com.vinibelo.githubprofilemanagermutant.services.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public ResponseEntity<ListUsersDto> listUsers() {
        return ResponseEntity.ok(usersService.listUsers());
    }
}
