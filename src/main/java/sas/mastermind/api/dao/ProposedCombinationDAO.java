package sas.mastermind.api.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> getProposedCombinations(String gameName) {
        System.out.println("FROM ProposedCombination WHERE game='" + gameName + "'");
        TypedQuery<ProposedCombination> query = entityManager.createQuery("FROM ProposedCombination WHERE game=:gameName", ProposedCombination.class);
        query.setParameter("gameName", gameName);
        List<ProposedCombination> proposedCombinationsQuerying = query.getResultList();
        List<String>proposedCombinations = new ArrayList<>();
        for (ProposedCombination combination : proposedCombinationsQuerying) {
            proposedCombinations.add(combination.getCombination());
        }
        return proposedCombinations;
    }
}
