package business;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FreizeitbadTest {
	BooleanSupplier bs;
	Freizeitbad freizeitbad;
	
	@BeforeEach
	void setUp() throws Exception{
		this.freizeitbad = new Freizeitbad("Stadtbad","7.0", "17.0", "25", "24");
	}
	@AfterEach
	void tearDown() throws Exception{
		this.freizeitbad = null;
	}
	

	@Test
	void test() {
		bs = () -> freizeitbad.getBeckenlaenge()==25;
		assertTrue(bs.getAsBoolean());
	}

}
