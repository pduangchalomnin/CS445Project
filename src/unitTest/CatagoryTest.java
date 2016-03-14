package unitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Catagory;

public class CatagoryTest {

	Catagory testCat;
	
	@Before
	public void createCatagory(){
		testCat = new Catagory("testCat");
	}
	@Test
	public void testToString() {
		assertEquals("testCat", testCat.toString());
	}

}
