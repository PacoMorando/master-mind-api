package sas.mastermind.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import sas.mastermind.api.ApiMasterMind;

@RestController
@RequestMapping("/mastermind")
public class MasterMindRestController {
    private ApiMasterMind apiMasterMind;

    @Autowired
    public MasterMindRestController(ApiMasterMind apiMasterMind) {
        this.apiMasterMind = apiMasterMind;
        System.out.println("API INSTANCIADA   " + this.apiMasterMind.toString());
    }
/*
    @GetMapping("/main")
    public RedirectView main() {
        this.apiMasterMind.play();
        return new RedirectView(this.apiMasterMind.getCurrentView());
    }*/

    @GetMapping("/main")
    public RedirectView main(@RequestParam int view) {
        this.apiMasterMind.play();
        return new RedirectView(this.apiMasterMind.getCurrentView(view));
    }
}
