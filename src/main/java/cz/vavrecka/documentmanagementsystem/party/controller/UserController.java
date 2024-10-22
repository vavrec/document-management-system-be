package cz.vavrecka.documentmanagementsystem.party.controller;


import cz.vavrecka.documentmanagementsystem.party.domain.User;
import cz.vavrecka.documentmanagementsystem.party.exception.UserNotFound;
import cz.vavrecka.documentmanagementsystem.party.model.CreateUserDTO;
import cz.vavrecka.documentmanagementsystem.party.model.UpdateUserDTO;
import cz.vavrecka.documentmanagementsystem.party.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static cz.vavrecka.documentmanagementsystem.party.controller.UserController.URL;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping(URL)
@AllArgsConstructor
@Validated
@Slf4j
public class UserController {

    public static final String URL = "/api/v1/user";

    private final UserService userService;

    @GetMapping(path = "/{id}", produces = "application/json")
    public Mono<ResponseEntity<User>> getUser(@PathVariable UUID id) {
        return userService.findUserById(id)
                .map(ResponseEntity::ok);
    }

    @PostMapping(produces = "application/json")
    public Mono<ResponseEntity<User>> createUser(@RequestBody @Valid CreateUserDTO createUserDTO) {
        return userService.createUser(createUserDTO)
                .map(ResponseEntity::ok);
    }

    @PutMapping(produces = "application/json")
    public Mono<ResponseEntity<User>> updateUser(@RequestBody @Valid UpdateUserDTO user) {
        return userService.updateUser(user)
                .map(ResponseEntity::ok);
    }

    @ExceptionHandler(UserNotFound.class)
    public ProblemDetail userNotFoundExceptionHandler(UserNotFound userNotFound) {
        log.info(userNotFound.getMessage());
        return ProblemDetail.forStatusAndDetail(BAD_REQUEST, "Invalid data");
    }

}
