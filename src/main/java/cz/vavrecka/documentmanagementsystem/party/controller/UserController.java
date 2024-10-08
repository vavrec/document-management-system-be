package cz.vavrecka.documentmanagementsystem.party.controller;


import cz.vavrecka.documentmanagementsystem.party.domain.User;
import cz.vavrecka.documentmanagementsystem.party.model.CreateUserDTO;
import cz.vavrecka.documentmanagementsystem.party.model.UpdateUserDTO;
import cz.vavrecka.documentmanagementsystem.party.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static cz.vavrecka.documentmanagementsystem.party.controller.UserController.URL;

@RestController
@RequestMapping(URL)
@AllArgsConstructor
public class UserController {

    public static final String URL = "/api/v1/user";

    private final UserService userService;

    @GetMapping(path = "/{id}", produces = "application/json")
    private Mono<ResponseEntity<User>> getUser(@PathVariable UUID id) {
        return userService.findUserById(id)
                .map(ResponseEntity::ok);
    }

    @PostMapping(produces = "application/json")
    private Mono<ResponseEntity<User>> createUser(@RequestBody CreateUserDTO createUserDTO) {
        return userService.createUser(createUserDTO)
                .map(ResponseEntity::ok);
    }

    @PutMapping(produces = "application/json")
    private Mono<ResponseEntity<User>> updateUser(@RequestBody UpdateUserDTO user) {
        return userService.updateUser(user)
                .map(ResponseEntity::ok);
    }
}
