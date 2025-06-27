package uol_host_backend.demo.domain.entities;

import uol_host_backend.demo.domain.enums.GroupNickname;

public record Player (
    String id,
    String name,
    String email,
    String phoneNumber,
    GroupNickname nickname
){

}
