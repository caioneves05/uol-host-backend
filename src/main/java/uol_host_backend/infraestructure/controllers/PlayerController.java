package uol_host_backend.infraestructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uol_host_backend.application.services.player.PlayerService;
import uol_host_backend.domain.entities.Player;
import uol_host_backend.domain.enums.GroupNickname;

@Controller
@RequestMapping("/register-players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("")
    public String registerPlayer(Model model) {
        model.addAttribute("groupsNicknames", GroupNickname.values());
        return "register_players";
    }

    @PostMapping("new-player")
    public String registerPlayer(@ModelAttribute Player player) {
        try {
            playerService.registerPlayer(player);
            return "redirect:/players";
        } catch (Exception e) {
            return "redirect:/players?error=" + e.getMessage();
        }

    }

}
