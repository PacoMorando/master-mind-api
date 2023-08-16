package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import sas.mastermind.core.controllers.StartController;

@RestController
@RequestMapping("/mastermind")
public class StartView {
    @GetMapping("/start")
    public String interact(StartController startController){
        return "Start View";
    }
}
