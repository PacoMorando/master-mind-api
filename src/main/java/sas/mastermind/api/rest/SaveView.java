package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sas.mastermind.core.controllers.SaveController;

@RestController
@RequestMapping("/mastermind")
@CrossOrigin("http://localhost:4200")
public class SaveView {
    private int num = 0;//TODO Borrar esto que solo fue para probar
    private SaveController saveController;
    public void interact(SaveController saveController){
        this.saveController = saveController;
        System.out.println("Interact del SaveView");
    }
    @GetMapping("/save")
    public void save(){
        this.saveController.save("Game Saved_" + num);
        num++;
        this.saveController.next();
        System.out.println("Llegaste al SaveView");
    }
}
