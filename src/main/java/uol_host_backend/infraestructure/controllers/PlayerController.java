package uol_host_backend.infraestructure.controllers;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uol_host_backend.application.services.player.PlayerService;
import uol_host_backend.domain.entities.Player;
import uol_host_backend.domain.enums.GroupNickname;
import uol_host_backend.exception.GroupNicknameUnavailableException;

@Controller
@RequestMapping("/register-players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public String registerPlayer(Model model) {
        return getViewAndModel(model, new Player(null, null, null, null, null));
    }

    @PostMapping("/new-player")
    public String registerPlayer(@ModelAttribute @Valid Player player, BindingResult result, Model model) throws Exception {

        if(result.hasErrors())
            return getViewAndModel(model, player);

        try {
            playerService.registerPlayer(player);
            return "redirect:/register-players";
        } catch (GroupNicknameUnavailableException e) {
            result.rejectValue("groupNickname", "groupNicknameUnavailable", e.getMessage());
            return getViewAndModel(model, player);
        }

    }

    private String getViewAndModel(Model model, Player player) {
        model.addAttribute("player", player);
        model.addAttribute("groupsNicknames", GroupNickname.values());
        return "register_players";
    }
}
