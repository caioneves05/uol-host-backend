package uol_host_backend.application.repositories;

import org.springframework.stereotype.Component;
import uol_host_backend.application.interfaces.NicknameRepository;
import uol_host_backend.domain.enums.GroupNickname;

@Component
public class NicknameRepositoryFactory {
    private final JusticeLeagueRepository justiceLeagueRepository;
    private final AvengersRepository avengersRepository;

    public NicknameRepositoryFactory(JusticeLeagueRepository justiceLeagueRepository, AvengersRepository avengersRepository) {
        this.justiceLeagueRepository = justiceLeagueRepository;
        this.avengersRepository = avengersRepository;
    }

    public NicknameRepository create(GroupNickname groupNickname){
        switch (groupNickname) {
            case JUSTICE_LEAGUE -> {
                return justiceLeagueRepository;
            }
            case AVENGERS -> {
                return avengersRepository;
            }
            default -> throw new IllegalArgumentException("Unknown group nickname: " + groupNickname);
        }
    }
}
