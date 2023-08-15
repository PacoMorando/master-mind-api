package sas.mastermind.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mastermind")
public class MasterMindRestController {

    @GetMapping("/hello")
    public String helloMasterMind () {
        return "HELLO MASTER MIND TEST";
    }
}
