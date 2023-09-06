package sas.mastermind.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sas.mastermind.api.dao.SessionAPIDAO;
import sas.mastermind.api.rest.RestView;
import sas.mastermind.core.controllers.AcceptorController;
import sas.mastermind.core.controllers.Logic;
import sas.mastermind.core.controllers.LogicImplementation;
import sas.mastermind.core.views.View;

@Component
public class ApiMasterMind {
    private final Logic logic;//TODO Falta implementar el DAO
    private final View view;

    @Autowired
    public ApiMasterMind(RestView restView, SessionAPIDAO sessionAPIDAO){
        this.logic = new LogicImplementation(sessionAPIDAO);//TODO Falta implementar el DAO
        this.view = restView;
        System.out.println("API CREAADA " + this.toString());
    }

    public void play() {
        AcceptorController acceptorController;
        acceptorController = this.logic.getController();
        if (acceptorController != null) {
            this.view.interact(acceptorController);
        }
    }

    public String getCurrentView() {
        return ((RestView)this.view).getCurrentView();
    }
}
