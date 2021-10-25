package business;

import java.io.*;
import gui.FreizeitbaederView;

public class FreizeitbaederModel {
	public void schreibeFreizeitbadInCsvDatei(FreizeitbaederView freizeitbaederView) throws IOException{
		BufferedWriter aus = new BufferedWriter( new FileWriter("Freizeitbaeder.csv", true));
		aus.write(freizeitbaederView.getFreizeitbad().gibFreizeitbadZurueck(';'));
		aus.close();	
	}
}
