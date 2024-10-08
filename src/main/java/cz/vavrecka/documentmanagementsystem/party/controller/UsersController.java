package cz.vavrecka.documentmanagementsystem.party.controller;

import cz.vavrecka.documentmanagementsystem.party.domain.User;
import cz.vavrecka.documentmanagementsystem.party.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static cz.vavrecka.documentmanagementsystem.party.controller.UsersController.URL;

@RestController
@RequestMapping(URL)
@AllArgsConstructor
public class UsersController {

    public static final String URL = "/api/v1/users";

    private final UserService userService;

    @GetMapping(produces = "application/json")
    public Mono<ResponseEntity<Page<User>>> getUsers(@RequestParam int page, @RequestParam int size) {
        return userService.getPersonsPaged(page, size).map(ResponseEntity::ok);
    }
}
