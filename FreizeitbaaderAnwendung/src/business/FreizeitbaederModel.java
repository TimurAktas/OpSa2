package business;

import java.io.*;
import gui.FreizeitbaederView;
import fabrik.ConcreteCreator;
import fabrik.Creator;
import fabrik.Product;
import fabrik.ConcreteTxTCreator;



public class FreizeitbaederModel {
	private Freizeitbad freizeitbad;
	
	/*public void schreibeFreizeitbadInCsvDatei(FreizeitbaederView freizeitbaederView)
		    throws IOException{
	BufferedWriter aus = new BufferedWriter(
			new FileWriter("Freizeitbaeder.csv", true));
	aus.write(freizeitbaederView.getFreizeitbad().gibFreizeitbadZurueck(';'));
	aus.close();	
		
	}
	*/
	public Freizeitbad getFreizeitbad() {
		return this.freizeitbad;
	}
	
	 public void setFreizeitbad(Freizeitbad freizeitbad) {
			this.freizeitbad = freizeitbad;

		}
	

	public void schreibeFreizeitbaederInCsvDatei() throws IOException{
		Creator c = new ConcreteCreator();
		Product writer =  c.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();
		
	}
	public void schreibeFreizeitbaederInTxTDatei() throws IOException{
		Creator c = new ConcreteTxTCreator();
		Product writer =  c.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();
	}

	
	
	
}
