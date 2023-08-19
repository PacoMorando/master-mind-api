package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sas.mastermind.core.controllers.ResumeController;

@RestController
@RequestMapping("/mastermind")
public class ResumeView {

    public void interact (ResumeController resumeController){

    }

    @GetMapping("/resume")
    public String show(){
        System.out.println("Llegaste al ResumeView");
        return "MASTER MIND Resume View  ";
    }
}
