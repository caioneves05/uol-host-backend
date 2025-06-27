package uol_host_backend.demo.domain.repository;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import uol_host_backend.demo.domain.entities.Player;

@Repository
public class PlayerRepository {
    private JdbcClient jdbcClient;

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
                .param("nickname", player.nickname())
                .update();
        return player;
    }
}