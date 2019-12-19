package com.messiaen.dropshipping.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDto {

    private Long id;
    @NotBlank(message = "Le nom d'utilisateur doit être définit")
    @Size(min = 4, max = 32, message = "Le nom d'utilisateur doit contenir entre 4 et 32 charactères")
    private String username;
    @NotBlank(message = "Le nom d'utilisateur doit être définit")
    @Size(min = 4, message = "Le mot de passe doit contenir au moins 4 charactères")
    private String password;

    private String basketId;

    private Boolean isAdmin;

}
