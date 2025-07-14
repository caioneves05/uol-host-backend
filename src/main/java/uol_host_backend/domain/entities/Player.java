package uol_host_backend.domain.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import uol_host_backend.domain.enums.GroupNickname;

@Validated
public record Player (

    @NotBlank
    String name,

    @NotBlank
    @Email
    String email,

    String phoneNumber,

    String nickname,

    @NotNull
    GroupNickname groupNickname
){
    public Player withNickname(String nickname) {
        return new Player(name, email, phoneNumber, nickname, groupNickname);
    }
}
