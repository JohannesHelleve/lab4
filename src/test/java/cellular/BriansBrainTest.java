

package cellular;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datastructure.IGrid;

public class BriansBrainTest {
    CellAutomaton ca;

	@BeforeEach
	void setUp() throws Exception {
		ca = new BriansBrain(100, 100);
	}

	@Test
	void testInitializeCells() {
		for (int row = 0; row < ca.numberOfRows(); row++) {
			for (int col = 0; col < ca.numberOfColumns(); col++) {
				assertNotNull(ca.getCellState(row, col));
			}
		}
	}

	@Test
	void testNumberOfRowsAndColumns() {
		for (int rows = 1; rows < 200; rows += 10) {
			for (int cols = 1; cols < 200; cols += 10) {
				ca = new BriansBrain(rows, cols);
				assertEquals(rows, ca.numberOfRows());
				assertEquals(cols, ca.numberOfColumns());
			}
		}
	}

	/**
	 * On a 3x3 board check if GameOfLife::getNextCell return correct CellState
	 * given how many of the neighbouring cells are alive
	 */
	@Test
	public void briansBrainRules() {
		CellAutomaton ca = new BriansBrain(3, 3);
		// Alive center
        for (int i = 0; i < 8; i++) {
            aliveWithNNeighbours(ca, i, CellState.ALIVE);
            assertEquals(CellState.DYING, ca.getNextCell(1, 1));
        }

        // Dying Center
        for (int i = 0; i < 8; i++) {
            aliveWithNNeighbours(ca, i, CellState.DYING);
            assertEquals(CellState.DEAD, ca.getNextCell(1, 1));
        }

        // Dead Center
        for (int i = 0; i < 8; i++) {
            if (i == 2) {
                continue;
            }
            aliveWithNNeighbours(ca, i, CellState.DEAD);
            assertEquals(CellState.DEAD, ca.getNextCell(1, 1));
        }
        aliveWithNNeighbours(ca, 2, CellState.DEAD);
        assertEquals(CellState.ALIVE, ca.getNextCell(1, 1));

	}

	/**
	 * Create GameOfLife grid with <code>aliveCells</code> number of alive cells.
	 * The center cell has the value of <code>centerState</code>
	 */

	public void aliveWithNNeighbours(CellAutomaton ca, int aliveCells, CellState centerState) {
		IGrid grid = ca.getGrid();
		CellState currentState = CellState.ALIVE;
		int aliveCounter = 0;
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				if (i == 1 && j == 1) {
					grid.set(i, j, centerState);
					continue;
				}

				if (aliveCounter >= aliveCells)
					currentState = CellState.DEAD;

				grid.set(i, j, currentState);
				aliveCounter++;
			}
		}
	}

}
