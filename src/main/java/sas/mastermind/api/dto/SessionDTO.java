package sas.mastermind.api.dto;

import sas.mastermind.core.models.Session;

public class SessionDTO {
    private Session session;

    public SessionDTO(Session session) {
        this.session = session;
    }

    //TODO esta clase debe retornar un array de strings con las proposed combinations, y posiblemente con sus respectivos resultados
    //TODO la secretCombination no deberia de ser retornada aqui

    public String getName(){
        return this.session.getName();
    }

    public boolean isNamed(){
        return this.session.hasName();
    }

    public boolean isWinner(){
        return false;//TODO arreglar
    }

    public boolean isFinished() {
        return this.session.isFinished();
    }

    public boolean isUndoable(){
        return this.session.isUndoable();
    }

    public boolean isRedoable(){
        return this.session.isRedoable();
    }

    public int getCurrentAttempt() {
        return this.session.getCurrentAttempt();
    }

    public String getSecretCombination() {
        return this.session.getSecretCombination().toString();
    }
}
