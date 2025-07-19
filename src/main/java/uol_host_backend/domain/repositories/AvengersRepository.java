package uol_host_backend.domain.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClient;
import uol_host_backend.application.dtos.AvengersDTO;
import uol_host_backend.application.dtos.NicknameDTO;
import uol_host_backend.application.interfaces.NicknameRepository;
import uol_host_backend.domain.enums.GroupNickname;

import java.util.List;

@Repository
public class AvengersRepository implements NicknameRepository {
    @Override
    public NicknameDTO getNicknamesByGroup() throws Exception {
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

        return objectMapper.readValue(nicknames, AvengersDTO.class);

    }
}
