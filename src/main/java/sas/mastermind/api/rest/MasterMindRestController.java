package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import sas.mastermind.api.dao.SessionAPIDAO;
import sas.mastermind.core.MasterMind;
import sas.mastermind.core.controllers.Logic;
import sas.mastermind.core.controllers.LogicImplementation;
import sas.mastermind.core.views.View;

@RestController
@RequestMapping("/mastermind")
public class MasterMindRestController extends MasterMind {


    @GetMapping("/main")
    public void mainView () {
       // this.redirectToStart();
    }

    @Override
    protected Logic createLogic() {
        return new LogicImplementation(new SessionAPIDAO());
    }

    @Override
    protected View createView() {
        return new RestView();
    }
}
