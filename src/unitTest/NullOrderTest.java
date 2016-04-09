package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.NullOrder;

public class NullOrderTest {

	@Test
	public void testIsNil() {
		assertTrue(NullOrder.getinstance().isNil());
	}

}
