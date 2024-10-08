package cz.vavrecka.documentmanagementsystem.party.model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserDTO(@NotNull(message = "First name is a mandatory parameter") String firstName,
                            @NotBlank(message = "Last name is a mandatory parameter") String lastName,
                            @NotBlank(message = "Email is a mandatory parameter")
                            @Email(message = "The format of the email is incorrect") String email) {
}
