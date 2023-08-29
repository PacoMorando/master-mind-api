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
    private SaveController saveController;
    public void interact(SaveController saveController){
        this.saveController = saveController;
        System.out.println("Interact del SaveView");
    }
    @GetMapping("/save")
    public void save(){
        System.out.println("Llegaste al SaveView");
    }
}
