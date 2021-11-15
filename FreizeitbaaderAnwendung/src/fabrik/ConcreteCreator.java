package fabrik;

import java.io.IOException;

public class ConcreteCreator extends Creator{
	public Product factoryMethod() throws IOException {
		// TODO Auto-generated method stub
		return new ConcreteProduct();
	}

}
