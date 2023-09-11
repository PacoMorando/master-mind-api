package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import sas.mastermind.api.dto.BoardDTO;
import sas.mastermind.core.controllers.PlayController;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:4200")
public class PlayView {
    private BoardDTO boardDTO;

    public void interact(PlayController playController) {
        this.boardDTO = new BoardDTO(playController);
    }

    @GetMapping("/play")
    public BoardDTO show() {
        System.out.println("Llegaste al PlayView");
        return this.boardDTO;
    }

    @PutMapping("/play/addProposedCombination")
    public BoardDTO addProposedCombination(@RequestBody String proposedCombination) {
        this.boardDTO.addProposedCombination(proposedCombination);
        System.out.println("Agregaste la combination: " + proposedCombination);
        return this.boardDTO;
    }

    @GetMapping("/play/undo")
    public BoardDTO undo() {
        if (this.boardDTO.isUndoable()) {
            this.boardDTO.undo();
            System.out.println("Undo");
        }
        return this.boardDTO;
    }

    @GetMapping("/play/redo")
    public BoardDTO redo() {
        if (this.boardDTO.isRedoable()) {
            this.boardDTO.redo();
            System.out.println("Redo");
        }
        return this.boardDTO;
    }

    @GetMapping("/play/exit")
    private RedirectView exit() {
        System.out.println("Dirigiendo al Resume");
        this.boardDTO.next();
        return new RedirectView("../main");
    }
}