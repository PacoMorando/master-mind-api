package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import sas.mastermind.core.controllers.SaveController;

@RestController
@RequestMapping("/mastermind")
@CrossOrigin("http://localhost:4200")
public class SaveView {
    private SaveController saveController;

    public void interact(SaveController saveController) {
        this.saveController = saveController;
        System.out.println("Interact del SaveView");
    }

    @GetMapping("/save")
    public void save() {
        System.out.println("Llegaste al SaveView");
    }

    @GetMapping("/save/saving")
    public RedirectView saving(@RequestParam String gameName) {
        this.saveController.save(gameName);
        this.saveController.next();
        System.out.println("Guardaste la partida con el nombre: " + gameName);
        return new RedirectView("../main");
    }
}
