package cz.vavrecka.documentmanagementsystem.party.service;

import cz.vavrecka.documentmanagementsystem.party.domain.User;
import cz.vavrecka.documentmanagementsystem.party.model.CreateUserDTO;
import cz.vavrecka.documentmanagementsystem.party.model.UpdateUserDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Validated
public interface UserService {

    Mono<User> findUserById(UUID id);

    Mono<Page<User>> getPersonsPaged(int page, int size);

    Mono<User> createUser(@Valid CreateUserDTO newUser);

    Mono<User> updateUser(@Valid UpdateUserDTO updatedUser);
}
