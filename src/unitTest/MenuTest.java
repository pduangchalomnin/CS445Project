package unitTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Menu;

public class MenuTest {

	Menu menu;
	
	@Before
	public void createMenu() {
		menu.getInstance();
	}
	
	//TODO Check about singleton interface pattern
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
