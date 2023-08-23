package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import sas.mastermind.core.controllers.ResumeController;

@RestController
@RequestMapping("/mastermind")
@CrossOrigin("http://localhost:4200")
public class ResumeView {
    private ResumeController resumeController;

    public void interact (ResumeController resumeController){
        this.resumeController = resumeController;
    }

    @GetMapping("/resume")
    public void show(){
        System.out.println("Llegaste al ResumeView");
        //return "MASTER MIND Resume View  you can access to:  ./continue or ./exit";
    }

    @GetMapping("/resume/continue")
    public RedirectView continueGame (){
        this.resumeController.resume(true);
        return new RedirectView("../start");
    }

    @GetMapping("/resume/exit")
    public RedirectView exitGame (){
        this.resumeController.resume(false);
        return new RedirectView("../main");
    }
}