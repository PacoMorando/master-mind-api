package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import sas.mastermind.core.controllers.StartController;

import java.util.ArrayList;


@RestController
@RequestMapping("/mastermind")
@CrossOrigin("http://localhost:4200")
public class StartView {
    private StartController startController;

    public void interact(StartController startController) {
        this.startController = startController;
    }

    @GetMapping("/start")
    public void show() {
        //this.startController.start();
        System.out.println("Llgaste al start");
    }

    @GetMapping("/start/newGame")
    public RedirectView newGame() {
        this.startController.start();
        System.out.println("New Game");
        return new RedirectView("../main");
    }
    @GetMapping("/start/openGame")
    public RedirectView openGame(@RequestParam String gameName) {
        this.startController.start(gameName);
        System.out.println("Open Game");
        return new RedirectView("../main");
    }

    @GetMapping("/start/getGamesNames")
    public String[] getGamesNames() {
        System.out.println("Obteniendo Array de Games Names");
        return this.startController.getGamesNames();
    }
}