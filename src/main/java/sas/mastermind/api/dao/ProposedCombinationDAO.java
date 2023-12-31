package sas.mastermind.api.dao;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProposedCombinationDAO {
    private final EntityManager entityManager;

    @Autowired
    public ProposedCombinationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void insert(ProposedCombination proposedCombination) {
        this.entityManager.persist(proposedCombination);
    }
}
