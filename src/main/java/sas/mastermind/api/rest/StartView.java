package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import sas.mastermind.core.controllers.StartController;


@RestController
@RequestMapping("/mastermind")
public class StartView {
    private StartController startController;

    public void interact(StartController startController) {
        this.startController = startController;
    }

    @GetMapping("/start")
    public String show() {
        return "MASTER MIND \n" + " you can access to:  ./newGame or ./openGame";
    }

    @GetMapping("/start/newGame")
    public RedirectView newGame () {
        this.startController.start();
        //return new RedirectView("https://youtube.com"); TODO ojo aqui voy a redirigir al link del front, y como todo se lo pido al main, ahi habra avanzado de state al playstate
        return new RedirectView("main");
    }
}