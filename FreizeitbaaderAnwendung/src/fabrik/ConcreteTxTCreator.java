package fabrik;

import java.io.IOException;

public class ConcreteTxTCreator extends Creator {

	@Override
	public Product factoryMethod() throws IOException {
		// TODO Auto-generated method stub
		return new ConcreteTxTproduct();
	}
	

}
