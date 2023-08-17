package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sas.mastermind.core.controllers.PlayController;

@RestController
@RequestMapping("/mastermind")
public class PlayView {
    @GetMapping("/play")
    public void interact(PlayController playController){

    }
}
