package cz.vavrecka.documentmanagementsystem.user.mapper;

import cz.vavrecka.documentmanagementsystem.user.domain.User;
import cz.vavrecka.documentmanagementsystem.user.model.CreateUserDTO;
import cz.vavrecka.documentmanagementsystem.user.model.UpdateUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "id", expression = "java(UUID.randomUUID())"),
            @Mapping(target = "isNew", constant = "true")
    })
    User toUser(CreateUserDTO userDTO);

    @Mappings({
            @Mapping(target = "isNew", constant = "false")
    })
    User toUpdateUser(UpdateUserDTO user);

}
