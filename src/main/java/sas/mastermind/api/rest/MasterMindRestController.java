package sas.mastermind.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import sas.mastermind.api.ApiMasterMind;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:4200")
public class MasterMindRestController {
    private ApiMasterMind apiMasterMind;

    @Autowired
    public MasterMindRestController(ApiMasterMind apiMasterMind) {
        this.apiMasterMind = apiMasterMind;
        System.out.println("API INSTANCIADA   " + this.apiMasterMind.toString());
    }

    @GetMapping("/main")
    public RedirectView main() {
        System.out.println("MAIN");
        this.apiMasterMind.play();
        return new RedirectView(this.apiMasterMind.getCurrentView());
    }
}