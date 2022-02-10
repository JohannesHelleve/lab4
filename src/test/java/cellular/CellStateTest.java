package cellular;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

class CellStateTest {

	@Test
	void testGetColor() {
		Color on = CellState.ALIVE.getColor();
		Color off = CellState.DEAD.getColor();
		assertFalse(on==null, "Cell Color can not be null"); 
		assertFalse(off==null, "Cell Color can not be null"); 
		assertFalse(on.equals(off),"CellStates must have different colors");
	}

}
