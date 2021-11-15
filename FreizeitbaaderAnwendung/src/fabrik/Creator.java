package fabrik;

import java.io.IOException;

public abstract class Creator {
	//public ConcreteCreator factoryMethod() {
		//return new ConcreteCreator();
	public abstract Product factoryMethod() throws IOException;
	}

//}
