package gui.guiSportstaetten;



import java.io.IOException;

import business.FreizeitbaederModel;
import businessSporthallen.SporthallenModel;
import javafx.stage.Stage;
import observer.Observer;
import ownUtil.PlausiException;

public class SportstaettenControl implements Observer {

	private SportstaettenView sportstaettenView;
	private FreizeitbaederModel freizeitbaederModel;
	private SporthallenModel sporthallenModel;
	

	public SportstaettenControl(Stage fensterSportstaetten) {
		// TODO Auto-generated constructor stub
		this.freizeitbaederModel = FreizeitbaederModel.getInstance();
		this.sporthallenModel		= SporthallenModel.getInstance();
		this.sportstaettenView = new SportstaettenView(this, fensterSportstaetten, freizeitbaederModel, sporthallenModel);

		freizeitbaederModel.addObserver(this);
	}
	
	void leseSporthallenAusDatei(String typ) {
		try {
			if(typ.equals("csv")) {
				sporthallenModel.leseSporthallenAusCsvDatei();
				this.sportstaettenView.zeigeInformationsfensterAn("Die Daten aus Sporthallen.csv wurden erfolgreich importiert.");
			}
			else {
				this.sportstaettenView.zeigeInformationsfensterAn("Die Datei existiert nicht.");
			}
		} catch (IOException | PlausiException e) {
			this.sportstaettenView.zeigeFehlermeldungAn("Fehler nicht bekannt", "Beim Importieren des ist ein Unbekannter Fehler aufgetaucht");
			e.printStackTrace();
		}
	}


	public void update() {
		sportstaettenView.zeigeFreizeitbaederAn();
	}
}
