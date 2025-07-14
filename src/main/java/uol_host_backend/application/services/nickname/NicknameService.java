package uol_host_backend.application.services.nickname;

import org.springframework.stereotype.Service;
import uol_host_backend.domain.repositories.NicknameRepositoryFactory;
import uol_host_backend.domain.enums.GroupNickname;

import java.util.List;

@Service
public class NicknameService {

    public final NicknameRepositoryFactory nicknameRepositoryFactory;

    public NicknameService(NicknameRepositoryFactory nicknameRepositoryFactory) {
        this.nicknameRepositoryFactory = nicknameRepositoryFactory;
    }

    private List<String> searchNicknames(GroupNickname groupNickname) throws Exception {
        var nicknameRepository = nicknameRepositoryFactory.create(groupNickname);

        return  nicknameRepository.getNicknamesByGroup();
    }

    private List<String> listAllAvailableNicknames(GroupNickname groupNickname, List<String> usedNicknames) throws Exception {
        List<String> searchedNicknames = searchNicknames(groupNickname);

        return searchedNicknames
                .stream()
                .filter((nickname) -> !usedNicknames.contains(nickname))
                .toList();
    }

    private String sortedNickname(List<String> availableNicknames) {
        return availableNicknames.get((int) (Math.random() * availableNicknames.size()));
    }

    public String generateNickname(GroupNickname groupNickname, List<String> usedNicknames) throws Exception {
        List<String> availableNicknames = listAllAvailableNicknames(groupNickname, usedNicknames);

        if (availableNicknames.isEmpty()) {
            throw new RuntimeException("There are no available nicknames for this group.");
        }

        return sortedNickname(availableNicknames);
    }

    public Object generateNickname() {
        return null;
    }
}
