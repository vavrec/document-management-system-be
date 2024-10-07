package cz.vavrecka.documentmanagementsystem.user.repository;

import cz.vavrecka.documentmanagementsystem.user.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface UserRepository extends R2dbcRepository<User, UUID> {


    @Query("SELECT * FROM dms_user")
    Flux<User> findAll(Pageable pageable);

}
