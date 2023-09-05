package sas.mastermind.api.dao;

import sas.mastermind.core.models.Game;
import sas.mastermind.core.models.SecretCombination;

import java.util.ArrayList;
import java.util.List;

public class GameDTO{
    private String secretCombination;
    private List<ProposedCombination> proposedCombinations;
    public GameDTO(String secretCombination, List<ProposedCombination> proposedCombinations) {
        this.secretCombination = secretCombination;
        this.proposedCombinations = proposedCombinations;
    }

    public Game getLoadedGame() {
        return new Game(this.getSecretCombination(),this.getProposeCombinations());
    }

    private SecretCombination getSecretCombination() {
        return new SecretCombination(this.secretCombination);
    }

    private ArrayList<sas.mastermind.core.models.ProposedCombination> getProposeCombinations() {
        ArrayList<sas.mastermind.core.models.ProposedCombination> proposedCombinations = new ArrayList<>();
        for (ProposedCombination proposedCombination : this.proposedCombinations) {
            proposedCombinations.add(new sas.mastermind.core.models.ProposedCombination(proposedCombination.getCombination()));
        }
        return proposedCombinations;
    }
}
