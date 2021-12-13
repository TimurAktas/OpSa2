package gui.guiFreizeitbaeder;

import java.io.IOException;

import business.FreizeitbaederModel;
import javafx.stage.Stage;
import observer.Observer;

public class FreizeitbaederControl implements Observer {

	private FreizeitbaederView freizeitbaederView;
	private FreizeitbaederModel freizeitbaederModel;

	public FreizeitbaederControl(Stage primaryStage) {
		this.freizeitbaederModel = freizeitbaederModel.getInstance();
		this.freizeitbaederView = new FreizeitbaederView(this, primaryStage, freizeitbaederModel);

		freizeitbaederModel.addObserver(this);

	}

	void schreibeFreizeitbadInDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				this.freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
				this.freizeitbaederView.zeigeInformationsfensterAn("Das Freizeitbad wurde gespeichert!");
			} else if ("txt".equals(typ)) {
				freizeitbaederModel.schreibeFreizeitbaederInTxTDatei();
				freizeitbaederView.zeigeInformationsfensterAn("Das Freizeitbad wurde gespeichert!");
			}

			else {
				this.freizeitbaederView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		} catch (IOException exc) {
			this.freizeitbaederView.zeigeFehlermeldungsfensterAn("IOEXCEPTION", "IOException beim Speichern!");
		} catch (Exception exc) {
			this.freizeitbaederView.zeigeFehlermeldungsfensterAn("EXCEPTION", "Unbekannter Fehler beim Speichern!");
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		freizeitbaederView.zeigeFreizeitbaederAn();
	}
}
