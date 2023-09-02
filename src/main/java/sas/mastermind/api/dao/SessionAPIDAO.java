package sas.mastermind.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sas.mastermind.core.dao.SessionDAO;

@Component
public class SessionAPIDAO extends SessionDAO {
    //TODO Programar esta clase
    private GameDAO gameDAO;
    private ProposedCombinationDAO proposedCombinationDAO;

    public SessionAPIDAO (){
    }

    @Autowired
    public void setGameDao(GameDAO gameDAO){
        this.gameDAO = gameDAO;
    }

    @Autowired
    public void setProposedCombinationDAO(ProposedCombinationDAO proposedCombinationDAO){
        this.proposedCombinationDAO = proposedCombinationDAO;
    }

    @Override
    public void load(String name) {
        this.sessionDTO.setName(name);
        this.sessionDTO.loadGame(this.getLoadedGame());
    }

    private sas.mastermind.core.models.Game getLoadedGame() {
        return null;
    }

    @Override
    public void save(String name) {
        if (!this.exist(name)) {
            Game gameToSave = new Game(name, this.sessionDTO.getSecretCombination().toString());
            /*this.gameDAO.insert(new sas.mastermind.api.dao.Game(name, this.sessionDTO.getSecretCombination().toString()));*/
            this.gameDAO.insert(gameToSave);
            this.saveProposedCombinations(gameToSave);
        } else {
            this.upDateProposedCombinations(name);
        }
    }

    private void saveProposedCombinations(Game game) {
        for (sas.mastermind.core.models.ProposedCombination proposedCombination : this.sessionDTO.getProposeCombinations()) {
            this.proposedCombinationDAO.insert(new ProposedCombination(game,proposedCombination.toString()));
        }
    }

    private void upDateProposedCombinations(String name) {
    }

    @Override
    public String[] getGamesNames() {
        return new String[0];
    }

    @Override
    public boolean exist(String name) {
        return false;
    }
}
