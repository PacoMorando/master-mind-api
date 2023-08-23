package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import sas.mastermind.core.controllers.StartController;


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
        System.out.println("Llgaste al start");
    }

    @GetMapping("/start/newGame")
    public RedirectView newGame () {
        this.startController.start();
        System.out.println("New Game");
        return new RedirectView("../main");
    }
}