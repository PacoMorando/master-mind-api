package sas.mastermind.api.rest;

import org.springframework.web.servlet.view.RedirectView;
import sas.mastermind.core.controllers.PlayController;
import sas.mastermind.core.controllers.ResumeController;
import sas.mastermind.core.controllers.SaveController;
import sas.mastermind.core.controllers.StartController;
import sas.mastermind.core.views.View;

public class RestView extends View {
    private StartView startView;
    private PlayView playView;
    private SaveView saveView;
    private ResumeView resumeView;

    public RestView() {
        this.startView = new StartView();
        this.playView = new PlayView();
        this.saveView = new SaveView();
        this.resumeView = new ResumeView();
    }


    @Override
    public void visit(StartController startController) {

    }

    @Override
    public void visit(PlayController playController) {

    }

    @Override
    public void visit(ResumeController resumeController) {

    }

    @Override
    public void visit(SaveController saveController) {

    }
}
