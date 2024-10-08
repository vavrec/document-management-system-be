package cz.vavrecka.documentmanagementsystem.party.service.impl;


import cz.vavrecka.documentmanagementsystem.party.domain.User;
import cz.vavrecka.documentmanagementsystem.party.exception.UserNotFound;
import cz.vavrecka.documentmanagementsystem.party.mapper.UserMapper;
import cz.vavrecka.documentmanagementsystem.party.model.CreateUserDTO;
import cz.vavrecka.documentmanagementsystem.party.model.UpdateUserDTO;
import cz.vavrecka.documentmanagementsystem.party.repository.UserRepository;
import cz.vavrecka.documentmanagementsystem.party.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private UserRepository userRepository;

    private UserMapper createUserDTOMapper;

    @Override
    public Mono<User> findUserById(UUID id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<Page<User>> getPersonsPaged(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return userRepository.findAll(pageRequest)
                .collectList()
                .zipWith(userRepository.count()).map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));
    }

    @Override
    public Mono<User> createUser(CreateUserDTO newUser) {
        return userRepository.save(createUserDTOMapper.toUser(newUser));
    }

    @Override
    public Mono<User> updateUser(UpdateUserDTO updatedUser) {
        User user = userMapper.toUpdateUser(updatedUser);
        return userRepository.findById(user.getId())
                .switchIfEmpty(Mono.error(new UserNotFound("User does not exist")))
                .flatMap((result) -> userRepository.save(user));
    }
}
