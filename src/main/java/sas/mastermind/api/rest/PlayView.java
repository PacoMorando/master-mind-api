package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import sas.mastermind.core.controllers.PlayController;
import sas.mastermind.core.models.ProposedCombination;

import java.util.ArrayList;

@RestController
@RequestMapping("/mastermind")
@CrossOrigin("http://localhost:4200")
public class PlayView {
    private PlayController playController;
    //private PlayViewDTO playViewDTO; TODO si tengo que hacer un objeto boardDTO se deberia de llamar

    public void interact(PlayController playController) {
        this.playController = playController;
    }

    @GetMapping("/play")
    public PlayView show() {
        System.out.println("Llegaste al PlayView");
        return this;
    }

    @PutMapping("/play/addProposedCombination")//TODO este no esta redirigiendo...
    public PlayView addProposedCombination(@RequestBody String proposedCombination) {
        this.playController.addProposedCombination(proposedCombination);
        System.out.println("Agregaste la combination: " + proposedCombination);
        return this;
    }

    @GetMapping("/play/undo")
    public PlayView undo() {
        if (this.isUndoable()) {
            this.playController.undo();
            System.out.println("Undo");
        }
        return this;
    }

    @GetMapping("/play/redo")
    public PlayView redo() {
        if (this.isRedoable()) {
            this.playController.redo();
            System.out.println("Redo");
        }
        return this;
    }

    @GetMapping("/play/exit")
    private RedirectView exit() {
        System.out.println("Dirigiendo al Resume");
        this.playController.next();
        return new RedirectView("../main");
    }


    public boolean isWinner() {
        return this.playController.getCurrentAttempt() > 0 && this.playController.isWinner();
    }

    public boolean isFinished() {
        return this.playController.isFinished();
    }

    public boolean isUndoable() {
        return this.playController.isUndoable();
    }

    public boolean isRedoable() {
        return this.playController.isRedoable();
    }

    public int getCurrentAttempt() {
        return this.playController.getCurrentAttempt();
    }

    public String getSecretCombination() { //TODO este metodo se borra, es para pruebas
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
}