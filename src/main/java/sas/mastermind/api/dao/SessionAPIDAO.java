package sas.mastermind.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sas.mastermind.core.dao.SessionDAO;

import java.util.List;

@Component
public class SessionAPIDAO extends SessionDAO {
    //TODO Programar esta clase
    private GameDAO gameDAO;
    private ProposedCombinationDAO proposedCombinationDAO;

    public SessionAPIDAO() {
    }

    @Autowired
    public void setGameDao(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @Autowired
    public void setProposedCombinationDAO(ProposedCombinationDAO proposedCombinationDAO) {
        this.proposedCombinationDAO = proposedCombinationDAO;
    }

    @Override
    public void load(String gameName) {
        this.sessionDTO.setName(gameName);
        this.sessionDTO.loadGame(this.getLoadedGame(gameName));
    }

    private sas.mastermind.core.models.Game getLoadedGame(String gameName) {
        return new GameDTO(this.gameDAO.getSecretCombination(gameName), this.gameDAO.getProposedCombinations(gameName)).getLoadedGame();
    }

    @Override
    public void save(String name) {
        if (!this.exist(name)) {
            Game gameToSave = new Game(name, this.sessionDTO.getSecretCombination().toString());
            this.gameDAO.insert(gameToSave);
            this.saveProposedCombinations(gameToSave);
        } else {
            this.upDateProposedCombinations(name);
        }
    }

    private void saveProposedCombinations(Game game) {
        for (sas.mastermind.core.models.ProposedCombination proposedCombination : this.sessionDTO.getProposeCombinations()) {
            this.proposedCombinationDAO.insert(new ProposedCombination(game, proposedCombination.toString()));
        }
    }

    private void upDateProposedCombinations(String name) {
    }

    @Override
    public String[] getGamesNames() {
        List<Game> games = this.gameDAO.findAll();
        String[] names = new String[games.size()];
        for (int i = 0; i < names.length; i++) {
            names[i] = games.get(i).getName();
        }
        return names;
    }

    @Override
    public boolean exist(String gameName) {
        return this.gameDAO.find(gameName) != null;
    }
}
