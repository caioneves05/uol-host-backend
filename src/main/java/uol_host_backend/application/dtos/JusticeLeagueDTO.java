package uol_host_backend.application.dtos;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "liga_da_justica")
public record JusticeLeagueDTO(
        @JacksonXmlProperty(localName = "codinomes") NicknamesDTO codinomes
) implements NicknameDTO {

    @Override
    public List<String> getNicknames() {
        return codinomes.codinomes();
    }
}

record NicknamesDTO(
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "codinome")
        List<String> codinomes
) {}