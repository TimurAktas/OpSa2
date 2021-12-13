package gui.guiSportstaetten;

import java.io.IOException;

import business.FreizeitbaederModel;
import gui.guiSportstaetten.SportstaettenView;
import javafx.stage.Stage;
import observer.Observer;

public class SportstaettenControl implements Observer {

	private SportstaettenView sportstaettenView;
	private FreizeitbaederModel freizeitbaederModel;

	public SportstaettenControl(Stage fensterSportstaetten) {
		// TODO Auto-generated constructor stub
		this.freizeitbaederModel = FreizeitbaederModel.getInstance();
		this.sportstaettenView = new SportstaettenView(this, fensterSportstaetten, freizeitbaederModel);

		freizeitbaederModel.addObserver(this);
	}


	public void update() {
		sportstaettenView.zeigeFreizeitbaederAn();
	}
}
