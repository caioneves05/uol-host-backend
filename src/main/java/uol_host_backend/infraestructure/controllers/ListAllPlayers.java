package uol_host_backend.infraestructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uol_host_backend.application.services.player.PlayerService;
import uol_host_backend.domain.entities.Player;

@Controller
@RequestMapping("list-all-players")
public class ListAllPlayers {

    final public PlayerService playerService;

    public ListAllPlayers(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String listAllPlayers(Model model) {
        model.addAttribute("player", playerService.allPlayers());
        System.out.println(playerService.allPlayers());
        return "list_all_players";
    }
}
