package uol_host_backend.application.dtos;

import java.util.List;

public record AvengersDTO(List<Nickname> vingadores) implements NicknameDTO {

    @Override
    public List<String> getNicknames() {
        return vingadores.stream()
                .map(Nickname::codinome)
                .toList();
    }
}

record Nickname(String codinome) {
}