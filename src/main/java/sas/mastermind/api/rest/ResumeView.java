package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import sas.mastermind.core.controllers.ResumeController;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:4200")
public class ResumeView {
    private ResumeController resumeController;

    public void interact(ResumeController resumeController) {
        System.out.println("Interact del ResumeView");
        this.resumeController = resumeController;
    }

    @GetMapping("/resume")
    public void show() {
        System.out.println("Llegaste al ResumeView");
    }

    @GetMapping("/resume/continue")
    public void continueGame() {
        this.resumeController.resume(true);
    }

    @GetMapping("/resume/exit")
    public void exitGame() {
        this.resumeController.resume(true);
        System.out.println("RESUME EXIT");
        /*return new RedirectView("../main");*/
    }
}