package sas.mastermind.api.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GameDAO {
    private EntityManager entityManager;

    @Autowired
    public GameDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void insert(Game game) {
        this.entityManager.persist(game);
    }
}
