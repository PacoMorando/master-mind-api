package sas.mastermind.api.dto;

import sas.mastermind.core.controllers.PlayController;

public class PlayViewDTO {
    private PlayController playController;

    public PlayViewDTO(PlayController playController) {
        this.playController = playController;
    }


    public boolean isWinner(){
        return false;//TODO arreglar
    }

    public boolean isFinished() {
        return this.playController.isFinished();
    }

    public boolean isUndoable(){
        return this.playController.isUndoable();
    }

    public boolean isRedoable(){
        return this.playController.isRedoable();
    }

    public int getCurrentAttempt() {
        return this.playController.getCurrentAttempt();
    }

    public String getSecretCombination() {
        return this.playController.getSecretCombination().toString();
    }
}
