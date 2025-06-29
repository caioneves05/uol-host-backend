package uol_host_backend.application.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.client.RestClient;
import uol_host_backend.application.dtos.JusticeLeagueDTO;
import uol_host_backend.application.interfaces.NicknameRepository;
import uol_host_backend.domain.enums.GroupNickname;

import java.util.List;

public class JusticeLeagueRepository  implements NicknameRepository {
    @Override
    public List<String> getNicknamesByGroup() throws Exception {
        var nicknames = RestClient
                .builder()
                .baseUrl(GroupNickname.JUSTICE_LEAGUE.getUri())
                .build()
                .get()
                .retrieve()
                .body(String.class);

        var xmlMapper = new XmlMapper();
        var justiceLeague = xmlMapper.readValue(nicknames, JusticeLeagueDTO.class);

        return justiceLeague.getNicknames();
    }
}
