package uol_host_backend.application.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface NicknameRepository {
    List<String> getNicknamesByGroup() throws Exception;
}
