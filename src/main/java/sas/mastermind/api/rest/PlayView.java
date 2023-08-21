package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import sas.mastermind.api.dto.PlayViewDTO;
import sas.mastermind.core.controllers.PlayController;
import sas.mastermind.core.models.ProposedCombination;

import java.util.ArrayList;

@RestController
@RequestMapping("/mastermind")
public class PlayView {
    private PlayController playController;
    //private PlayViewDTO playViewDTO;

    @GetMapping("/play")
    public PlayView show() {
        System.out.println("Llegaste al PlayView");
        return this;
    }

    @PutMapping("/play")
    public PlayView addProposedCombination(@RequestBody String proposedCombination) {
        this.playController.addProposedCombination(proposedCombination);
        //this.showResults();
        System.out.println("Agregaste una combination");
        return this;
    }

    private RedirectView showResults() {
        if (isFinished()) {
            this.playController.next();
            this.playController.next();//TODO borrar, esto es para brincarme el save
        }
        return new RedirectView("../main");
    }

    @GetMapping("/play/add")//TODO borrar este metodo de pruebas y usar el PutMapping
    public RedirectView add(@RequestParam String p) {
        this.playController.addProposedCombination(p);
        this.showResults();
        System.out.println("Agregaste una combination");
        return new RedirectView("../main");
    }

    @GetMapping("/play/undo")//TODO borrar este metodo de pruebas y usar el PutMapping
    public PlayView undo() {
        if (this.isUndoable()) {
            this.playController.undo();
            System.out.println("Undo");
        }
        return this;
    }

    @GetMapping("/play/redo")//TODO borrar este metodo de pruebas y usar el PutMapping
    public PlayView redo() {
        if (this.isRedoable()){
            this.playController.redo();
            System.out.println("Redo");
        }
        return this;
    }

    public void interact(PlayController playController) {
        this.playController = playController;
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