package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sas.mastermind.core.controllers.ResumeController;

@RestController
@RequestMapping("/mastermind")
public class ResumeView {
    @GetMapping("/resume")
    public void interact (ResumeController resumeController){

    }
}
