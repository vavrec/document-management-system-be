package cz.vavrecka.documentmanagementsystem.user.service;

import cz.vavrecka.documentmanagementsystem.user.domain.User;
import cz.vavrecka.documentmanagementsystem.user.model.CreateUserDTO;
import cz.vavrecka.documentmanagementsystem.user.model.UpdateUserDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Validated
public interface UserService {

    Mono<User> findUserById(UUID id);

    Mono<Page<User>> getPersonsPaged(int page, int size);

    Mono<User> createUser(CreateUserDTO newUser);

    Mono<User> updateUser(@Valid UpdateUserDTO updatedUser);
}
