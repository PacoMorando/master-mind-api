package sas.mastermind.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sas.mastermind.api.dao.SessionAPIDAO;
import sas.mastermind.core.MasterMind;
import sas.mastermind.core.controllers.Logic;
import sas.mastermind.core.controllers.LogicImplementation;
import sas.mastermind.core.views.View;

@SpringBootApplication
public class MasterMindApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterMindApiApplication.class, args);
	}
}
