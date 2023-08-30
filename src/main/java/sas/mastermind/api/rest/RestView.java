package sas.mastermind.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sas.mastermind.api.dto.SessionViewDTO;
import sas.mastermind.core.controllers.PlayController;
import sas.mastermind.core.controllers.ResumeController;
import sas.mastermind.core.controllers.SaveController;
import sas.mastermind.core.controllers.StartController;
import sas.mastermind.core.views.View;

@Component
public class RestView extends View {
    private StartView startView;
    private PlayView playView;
    private SaveView saveView;
    private ResumeView resumeView;
    private SessionViewDTO sessionViewDTO;
    private String currentView; //TODO definir un mejor nombrre si es posible

    public RestView() {
        System.out.println("RestView Creada   " + this.toString());
    }

    @Override
    public void visit(StartController startController) {
        this.startView.interact(startController);
        this.currentView = "./start";
    }

    @Override
    public void visit(PlayController playController) {
        this.playView.interact(playController);
        this.currentView = "./play";
    }

    @Override
    public void visit(ResumeController resumeController) {
        this.resumeView.interact(resumeController);
        this.currentView = "./resume";
    }

    @Override
    public void visit(SaveController saveController) {
        this.saveView.interact(saveController);
        this.currentView = "./save";
    }

    public String getCurrentView() {
        return this.currentView;
    }


    @Autowired
    public void setStartView(StartView startView) {
        this.startView = startView;
    }

    @Autowired
    public void setPlayView(PlayView playView) {
        this.playView = playView;
    }

    @Autowired
    public void setSaveView(SaveView saveView) {
        this.saveView = saveView;
    }

    @Autowired
    public void setResumeView(ResumeView resumeView) {
        this.resumeView = resumeView;
    }

}
