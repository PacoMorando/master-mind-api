package sas.mastermind.api.dao;

import jakarta.persistence.*;

@Entity
@Table(name = "proposed_combinations")
public class ProposedCombination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    @Column(name = "combination")
    private String combination;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "game_name")
    private Game game;//Este nombre es el que va en ONE mappedBy

    public ProposedCombination(Game game, String combination) {
        this.game = game;
        this.combination = combination;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCombination() {
        return combination;
    }

    public void setCombination(String combination) {
        this.combination = combination;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
