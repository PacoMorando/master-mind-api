package sas.mastermind.api.dto;

import sas.mastermind.core.controllers.PlayController;
import sas.mastermind.core.models.ProposedCombination;

import java.util.ArrayList;

public class BoardDTO {
    private final PlayController playController;

    public BoardDTO(PlayController playController) {
        this.playController = playController;
    }

    public int getCurrentAttempt() {
        return this.playController.getCurrentAttempt();
    }

    public String getSecretCombination() {
        return this.playController.getSecretCombination().toString();
    }

    public ArrayList<String> getProposedCombinations() {
        ArrayList<String> proposedCombinations = new ArrayList<>();
        for (ProposedCombination combination : this.playController.getProposeCombinations()) {
            proposedCombinations.add(combination.toString());
        }
        return proposedCombinations;
    }

    public ArrayList<Integer> getBlacks() {
        ArrayList<Integer> blacks = new ArrayList<>();
        for (ProposedCombination combination : this.playController.getProposeCombinations()) {
            blacks.add(this.playController.calculateBlacks(combination));
        }
        return blacks;
    }

    public ArrayList<Integer> getWhites() {
        ArrayList<Integer> whites = new ArrayList<>();
        for (ProposedCombination combination : this.playController.getProposeCombinations()) {
            whites.add(this.playController.calculateWhites(combination));
        }
        return whites;
    }

    public boolean isFinished() {
        return this.playController.isFinished();
    }

    public boolean isWinner() {
        return this.playController.getCurrentAttempt() > 0 && this.playController.isWinner();
    }

    public void addProposedCombination(String proposedCombination) {
        this.playController.addProposedCombination(proposedCombination);
    }

    public boolean isUndoable() {
        return this.playController.isUndoable();
    }

    public boolean isRedoable() {
        return this.playController.isRedoable();
    }

    public void undo() {
        this.playController.undo();
    }

    public void redo() {
        this.playController.redo();
    }

    public void next() {
        this.playController.next();
    }
}