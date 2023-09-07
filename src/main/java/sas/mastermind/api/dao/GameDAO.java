package sas.mastermind.api.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GameDAO {
    private final EntityManager entityManager;

    @Autowired
    public GameDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void insert(Game game) {
        this.entityManager.persist(game);
    }

    public List<Game> findAll() {
        TypedQuery<Game> query = this.entityManager.createQuery("FROM Game", Game.class);
        return query.getResultList();
    }

    public String getSecretCombination(String gameName) {
        return this.find(gameName).getSecretCombination();
    }
    public List<ProposedCombination> getProposedCombinations(String gameName) {
        return this.find(gameName).getProposedCombinations();
    }

    public Game find(String gameName) {
        return entityManager.find(Game.class, gameName);
    }
}
