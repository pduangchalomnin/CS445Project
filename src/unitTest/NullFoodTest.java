package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.NullFood;

public class NullFoodTest {

	@Test
	public void testIsNil() {
		assertTrue(NullFood.getinstance().isNil());
	}

}
