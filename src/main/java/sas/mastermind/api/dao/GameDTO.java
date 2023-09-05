package sas.mastermind.api.dao;

import sas.mastermind.core.models.Game;
import sas.mastermind.core.models.ProposedCombination;
import sas.mastermind.core.models.SecretCombination;

import java.util.ArrayList;
import java.util.List;

public class GameDTO{
    private String secretCombination;
    private List<String> proposedCombinations;
    public GameDTO(String secretCombination, List<String> proposedCombinations) {
        this.secretCombination = secretCombination;
        this.proposedCombinations = proposedCombinations;
    }

    public Game getLoadedGame() {
        return new Game(this.getSecretCombination(),this.getProposeCombinations());
    }

    private SecretCombination getSecretCombination() {
        return new SecretCombination(this.secretCombination);
    }

    private ArrayList<ProposedCombination> getProposeCombinations() {
        ArrayList<ProposedCombination> proposedCombinations = new ArrayList<>();
        for (String proposedCombination : this.proposedCombinations) {
            proposedCombinations.add(new ProposedCombination(proposedCombination));
        }
        return proposedCombinations;
    }
}
