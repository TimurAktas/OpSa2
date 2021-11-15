package fabrik;

import java.io.IOException;
import business.Freizeitbad;

public abstract class Product {
	public abstract void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException;
	public abstract void schliesseDatei() throws IOException;
}
		
	

