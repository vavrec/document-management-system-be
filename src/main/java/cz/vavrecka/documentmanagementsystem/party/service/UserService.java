package cz.vavrecka.documentmanagementsystem.party.service;

import cz.vavrecka.documentmanagementsystem.party.domain.User;
import cz.vavrecka.documentmanagementsystem.party.model.CreateUserDTO;
import cz.vavrecka.documentmanagementsystem.party.model.UpdateUserDTO;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Mono;

import java.util.UUID;


public interface UserService {

    Mono<User> findUserById(UUID id);

    Mono<Page<User>> getPersonsPaged(int page, int size);

    Mono<User> createUser(CreateUserDTO newUser);

    Mono<User> updateUser(UpdateUserDTO updatedUser);
}
