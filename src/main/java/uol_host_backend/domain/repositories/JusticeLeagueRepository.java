package uol_host_backend.domain.repositories;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;
import uol_host_backend.application.dtos.JusticeLeagueDTO;
import uol_host_backend.application.dtos.NicknameDTO;
import uol_host_backend.application.interfaces.NicknameRepository;
import uol_host_backend.domain.enums.GroupNickname;

import java.util.List;

@Repository
public class JusticeLeagueRepository implements NicknameRepository {
    @Override
    public NicknameDTO getNicknamesByGroup() throws Exception {
        var nicknames = RestClient
                .builder()
                .baseUrl(GroupNickname.JUSTICE_LEAGUE.getUri())
                .build()
                .get()
                .retrieve()
                .body(String.class);

        var xmlMapper = new XmlMapper();

        return xmlMapper.readValue(nicknames, JusticeLeagueDTO.class);
    }
}
