package cz.vavrecka.documentmanagementsystem.user.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("dms_user")
public record User(@Id @Column("user_id") UUID id,
                   String firstName,
                   String lastName,
                   String email,
                   @JsonIgnore @Transient boolean isNew) implements Persistable<UUID> {

    @PersistenceCreator
    public User(UUID id, String firstName, String lastName, String email) {
        this(id, firstName, lastName, email, false);
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
