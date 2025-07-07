package uol_host_backend.application.services.nickname;

import org.springframework.stereotype.Service;
import uol_host_backend.application.interfaces.NicknameRepository;
import uol_host_backend.domain.entities.Player;
import uol_host_backend.domain.enums.GroupNickname;
import uol_host_backend.domain.repository.PlayerRepository;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final NicknameService nicknameService;

    public PlayerService(PlayerRepository playerRepository, NicknameService nicknameService) {
        this.playerRepository = playerRepository;
        this.nicknameService = nicknameService;
    }

    public Player registerPlayer(Player player) throws Exception {
        var nicknamesUsed = listNicknamesUsed(player.groupNickname());
        var newNickname = nicknameService.generateNickname(player.groupNickname(), nicknamesUsed);

        var newPlayer = new Player(
                player.name(),
                player.email(),
                player.phoneNumber(),
                newNickname,
                player.groupNickname()
        );

        return playerRepository.save(newPlayer);
    }

    private List<String> listNicknamesUsed(GroupNickname groupNickname) {
        return playerRepository.findAllByGroupNickname(groupNickname)
                .stream()
                .map(Player::getNickname)
                .toList();
    }
}
