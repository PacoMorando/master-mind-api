package sas.mastermind.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import sas.mastermind.api.ApiMasterMind;
import sas.mastermind.api.dao.SessionAPIDAO;
import sas.mastermind.core.controllers.AcceptorController;
import sas.mastermind.core.controllers.Logic;
import sas.mastermind.core.controllers.LogicImplementation;
import sas.mastermind.core.views.View;

@RestController
@RequestMapping("/mastermind")
public class MasterMindRestController {
    private ApiMasterMind apiMasterMind;

    @Autowired
    public MasterMindRestController(ApiMasterMind apiMasterMind) {
        this.apiMasterMind = apiMasterMind;
        System.out.println("API INSTANCIADA   " + this.apiMasterMind.toString());
    }

    @GetMapping("/main")
    public RedirectView main() {
        this.apiMasterMind.play();
        //this.play();
        return new RedirectView(this.apiMasterMind.getCurrentView());
    }

/*
    private void play() {
        AcceptorController acceptorController;
        acceptorController = this.logic.getController();
        if (acceptorController != null) {
            this.view.interact(acceptorController);
        }
    }
*/

    /*@Autowired
    public void setView(RestView restView) {
        this.view = restView;
        System.out.println("View Inicializada" + this.view.toString());
    }*/
}
