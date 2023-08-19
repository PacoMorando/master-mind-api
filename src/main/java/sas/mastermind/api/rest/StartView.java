package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sas.mastermind.core.controllers.StartController;


@RestController
@RequestMapping("/mastermind")
public class StartView {
    private String name = "No se quien soy";//TODO eliminar, era para pruebas
    public StartView(){
        System.out.println("Bean Creado  " + this.toString());
    }

    public void interact(StartController startController){
        startController.start();
        this.name = "Soy el de la API";
    }

    @GetMapping("/start")
    public String show(){
        System.out.println("Llegaste al StartView");
        System.out.println(name);
        return "MASTER MIND Start View  ";
    }
}