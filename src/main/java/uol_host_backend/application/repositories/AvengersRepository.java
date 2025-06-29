package uol_host_backend.application.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;
import uol_host_backend.application.dtos.AvengersDTO;
import uol_host_backend.application.interfaces.NicknameRepository;
import uol_host_backend.domain.enums.GroupNickname;

import java.util.List;

public class AvengersRepository implements NicknameRepository {
    @Override
    public List<String> getNicknamesByGroup() throws Exception {
        var nicknames = RestClient
                .builder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN_VALUE)
                .baseUrl(GroupNickname.AVENGERS.getUri())
                .build()
                .get()
                .retrieve()
                .body(String.class);

        var objectMapper = new ObjectMapper();

        var avengers = objectMapper.readValue(nicknames, AvengersDTO.class);

        return avengers.getNicknames();

    }
}
