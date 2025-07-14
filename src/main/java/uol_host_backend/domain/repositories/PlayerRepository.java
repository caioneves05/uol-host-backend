package uol_host_backend.domain.repositories;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import uol_host_backend.domain.entities.Player;
import uol_host_backend.domain.enums.GroupNickname;

import java.util.List;

@Repository
public class PlayerRepository {
    private final JdbcClient jdbcClient;

    PlayerRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Player save(Player player) {
        jdbcClient.sql("""
            INSERT INTO PLAYERS (
                NAME,
                EMAIL,
                PHONE_NUMBER,
                NICKNAME
                GROUP_NICKNAME
            ) VALUES (
                :name,
                :email,
                :phoneNumber,
                :nickname
                :groupNickname
            )
            """)
                .param("name", player.name())
                .param("email", player.email())
                .param("phoneNumber", player.phoneNumber())
                .param("nickname", player.groupNickname())
                .update();
        return player;
    }

    public List<String> findAllByGroupNickname(GroupNickname groupNickname) {
        return jdbcClient.sql("SELECT DISTINCT(nicknames) FROM PLAYERS WHERE GROUP_NICKNAME = :groupNickname")
                .param("groupNickname", groupNickname.getName())
                .query(String.class)
                .list();
    }
}