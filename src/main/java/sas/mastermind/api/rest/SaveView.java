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

    @GetMapping("/save/hasName")
    public boolean hasName() {
        System.out.println("Tiene Nombre " + this.saveController.hasName());
        if (this.saveController.hasName()) {
            this.saveController.save();
            this.saveController.next();
            System.out.println("Partida guardad, ya tenia nombre" );
        }
        return  this.saveController.hasName();
    }

    @GetMapping("/save/saving")
    public RedirectView saving(@RequestParam String gameName) {
        if (this.saveController.hasName()) {
            this.saveController.save();
        }
        this.saveController.save(gameName);
        this.saveController.next();
        System.out.println("Guardaste la partida con el nombre: " + gameName);
        return new RedirectView("../main");
    }

    @GetMapping("/save/exist")
    public boolean exist(@RequestParam String gameName) {
        /*this.saveController.save(gameName);
        this.saveController.next();*/
        System.out.println("Preguntaste si existe: " + gameName);
        System.out.println(this.saveController.exists(gameName));
        /*return false;*/
        return this.saveController.exists(gameName);
    }
}
