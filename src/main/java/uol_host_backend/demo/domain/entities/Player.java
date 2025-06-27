package uol_host_backend.demo.domain.entities;

import uol_host_backend.demo.domain.types.GroupNickname;

public record Player (
    String id,
    String name,
    String email,
    String phoneNumber,
    GroupNickname Nickname
){

}
