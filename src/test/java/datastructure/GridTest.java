package datastructure;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import cellular.CellState;
import datastructure.CellGrid;
import datastructure.IGrid;

public class GridTest {
	Random random = new Random();

	@Test
	public void constructTest() {
		int rows = random.nextInt(100)+1, columns = random.nextInt(100)+1;
		IGrid grid = new CellGrid(rows, columns, CellState.DEAD);
		assertEquals(grid.numRows(), rows);
		assertEquals(grid.numColumns(), columns);
	}
	
	/**
	 * Tests that trying to access outside of the dimensions of the grid throws
	 * an IndexOutOfBoundsException.
	 */
	@Test
	public void outOfBoundsSetTest() {
		IGrid grid = new CellGrid(10, 10, CellState.DEAD);

		try {
			grid.set(11, 0, CellState.DEAD);
			fail("Should throw exception");
		} catch (IndexOutOfBoundsException e) {
			;
		}
		try {
			grid.set(0, 11, CellState.DEAD);
			fail("Should throw exception");
		} catch (IndexOutOfBoundsException e) {
			;
		}
	}
	
	/**
	 * Tests that trying to access outside of the dimensions of the grid throws
	 * an IndexOutOfBoundsException.
	 */
	@Test
	public void outOfBoundsGetTest() {
		IGrid grid = new CellGrid(10, 10, CellState.DEAD);

		try {
			grid.get(11, 0);
			fail("Should throw exception");
		} catch (IndexOutOfBoundsException e) {
			;
		}
		try {
			grid.get(0, 11);
			fail("Should throw exception");
		} catch (IndexOutOfBoundsException e) {
			;
		}
	}

	@Test
	public void setGetTest() {
		IGrid grid = new CellGrid(100, 100, CellState.DEAD);

		for (int row = 0; row < 100; row++)
			for (int col = 0; col < 100; col++) {
				CellState cs = CellState.random(random);
				grid.set(row, col, cs);
				assertEquals(cs, grid.get(row, col));
			}
	}
	
	@Test
	public void getSetIndependentCellsTest() {
		IGrid grid = new CellGrid(100, 100, random.nextBoolean() ? CellState.DEAD : CellState.ALIVE);

		for (int row = 0; row < 100; row++)
			for (int col = 0; col < 100; col++) {
				CellState current = grid.get(row, col);
				CellState cs = CellState.random(random);
				int i = row<100-1 ? row+1 : row-1;
				int j = col<100-1 ? col+1 : col-1;
				grid.set(i, j, cs);
				assertEquals(current, grid.get(row, col));
			}
	}

	@Test
	public void setGetIndependentTest() {
		IGrid grid = new CellGrid(100, 100, CellState.DEAD);

		for (int row = 0; row < 100; row++) {
			for (int col = 0; col < 100; col++) {
				grid.set(row, col, CellState.random(random));
			}
		}

		for (int row = 0; row < 100; row++)
			for (int col = 0; col < 100; col++) {
				CellState cs = CellState.random(random);
				grid.set(row, col, cs);
				assertEquals(cs, grid.get(row, col));
			}
	}

	@Test
	public void copyTest() {
		IGrid grid = new CellGrid(100, 100, CellState.DEAD);

		for (int row = 0; row < 100; row++) {
			for (int col = 0; col < 100; col++) {
				CellState cs = CellState.random(random);
				grid.set(row, col, cs);
			}
		}

		IGrid newGrid = grid.copy();
		for (int row = 0; row < 100; row++) {
			for (int col = 0; col < 100; col++) {
				assertEquals(grid.get(row, col), newGrid.get(row, col));
			}
		}
	}
}
