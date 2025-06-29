package uol_host_backend.application.services.nickname;

import org.springframework.stereotype.Service;
import uol_host_backend.application.repositories.NicknameRepositoryFactory;
import uol_host_backend.domain.enums.GroupNickname;

import java.util.List;

@Service
public class NickNameService {

    public final NicknameRepositoryFactory nicknameRepositoryFactory;

    public NickNameService(NicknameRepositoryFactory nicknameRepositoryFactory) {
        this.nicknameRepositoryFactory = nicknameRepositoryFactory;
    }

    private List<String> searchNicknames(GroupNickname groupNickname) {
        var nicknameRepository = nicknameRepositoryFactory.create(groupNickname);
    }

    private List<String> listAllAvailableNicknames(GroupNickname groupNickname, List<String> usedNicknames) {
        List<String> searchedNicknames = searchNicknames(groupNickname);

        List<String> availableNicknames = searchedNicknames
                .stream()
                .filter((nickname) -> !usedNicknames.contains(nickname))
                .toList();
    }

    private String sortedNickname(List<String> availableNicknames) {
    }

    public String generateNickname(GroupNickname groupNickname, List<String> usedNicknames) {
        List<String> availableNicknames = listAllAvailableNicknames(groupNickname, usedNicknames);

        if (availableNicknames.isEmpty()) {
            throw new RuntimeException("There are no available nicknames for this group.");
        }

        return sortedNickname(availableNicknames);
    }
}
