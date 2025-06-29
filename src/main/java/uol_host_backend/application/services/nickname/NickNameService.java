package uol_host_backend.application.services.nickname;

import org.springframework.stereotype.Service;
import uol_host_backend.domain.enums.GroupNickname;

import java.util.List;

@Service
public class NickNameService {

    private List<String> listAllAvailableNicknames(GroupNickname groupNickname, List<String> usedNicknames) {
        List<String> searcheredNicknames = searchNicknames(groupNickname);

        List<String> availableNicknames = searcheredNicknames
                .stream()
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
