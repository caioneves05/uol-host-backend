package uol_host_backend.application.interfaces;

import uol_host_backend.application.dtos.NicknameDTO;

import java.util.List;

public interface NicknameRepository {
    NicknameDTO getNicknamesByGroup() throws Exception;
}
