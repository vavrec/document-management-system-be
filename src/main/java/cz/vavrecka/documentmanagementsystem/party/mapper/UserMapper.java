package cz.vavrecka.documentmanagementsystem.party.mapper;

import cz.vavrecka.documentmanagementsystem.party.domain.User;
import cz.vavrecka.documentmanagementsystem.party.model.CreateUserDTO;
import cz.vavrecka.documentmanagementsystem.party.model.UpdateUserDTO;
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
