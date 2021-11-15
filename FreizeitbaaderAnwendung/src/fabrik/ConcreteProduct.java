package fabrik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import business.Freizeitbad;

public class ConcreteProduct extends Product{
	private BufferedWriter bw;
	public ConcreteProduct() throws IOException{
		bw = new BufferedWriter(new FileWriter("Freizeitbad.csv"));
	}
	public void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException{
		bw.write(((Freizeitbad)freizeitbad).gibFreizeitbadZurueck(';'));
		bw.write("\n");
		
	}
	public void schliesseDatei() throws IOException{
		bw.close();
	}
	
}
	

