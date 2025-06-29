package uol_host_backend.application.repositories;

import uol_host_backend.application.interfaces.NicknameRepository;

import java.util.List;

public class JusticeLeagueRepository  implements NicknameRepository {
    @Override
    public List<String> getNicknamesByGroup() {
        return List.of("Superman", "Batman");
    }
}
