package uol_host_backend.application.interfaces;

import java.util.List;

public interface NicknameRepository {
    List<String> getNicknamesByGroup() throws Exception;
}
