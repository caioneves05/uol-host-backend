package uol_host_backend.domain.entities;

import uol_host_backend.domain.enums.GroupNickname;

public record Player (
    String id,
    String name,
    String email,
    String phoneNumber,
    GroupNickname nickname
){

}
