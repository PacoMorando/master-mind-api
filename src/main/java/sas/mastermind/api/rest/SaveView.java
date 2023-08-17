package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sas.mastermind.core.controllers.SaveController;

@RestController
@RequestMapping("/mastermind")
public class SaveView {
    @GetMapping("/save")
    public void interact(SaveController saveController){

    }
}
