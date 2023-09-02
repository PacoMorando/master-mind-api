package sas.mastermind.api.dao;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @Column(name = "name", unique = true)
    private String name;
    @Column(name = "secret_combination")
    private String secretCombination;
    @OneToMany(mappedBy = "game", cascade = {CascadeType.ALL})
    private List<ProposedCombinations> proposedCombinations;

    public Game(String name, String secretCombination) {
        this.name = name;
        this.secretCombination = secretCombination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecretCombination() {
        return secretCombination;
    }

    public void setSecretCombination(String secretCombination) {
        this.secretCombination = secretCombination;
    }

    public List<ProposedCombinations> getProposedCombinations() {
        return proposedCombinations;
    }

    public void setProposedCombinations(List<ProposedCombinations> proposedCombinations) {
        this.proposedCombinations = proposedCombinations;
    }
}
