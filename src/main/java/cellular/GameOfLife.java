package cellular;

import java.util.Random;

import datastructure.CellGrid;
import datastructure.IGrid;

/**
 * 
 * A CellAutomata that implements Conways game of life.
 * 
 * @see CellAutomaton
 * 
 *      Every cell has two states: Alive or Dead. Each step the state of each
 *      cell is decided from its neighbors (diagonal, horizontal and lateral).
 *      If the cell has less than two alive Neighbors or more than three
 *      neighbors the cell dies. If a dead cell has exactly three neighbors it
 *      will become alive.
 * 
 * @author eivind
 * @author Martin Vatshelle - martin.vatshelle@uib.no
 * @author Sondre Bolland - sondre.bolland@uib.no
 */
public class GameOfLife implements CellAutomaton {

	/**
	 * The grid of cells
	 */
	IGrid currentGeneration;

	/**
	 * 
	 * Construct a Game Of Life Cell Automaton that holds cells in a grid of the
	 * provided size
	 * 
	 * @param height The height of the grid of cells
	 * @param width  The width of the grid of cells
	 */
	public GameOfLife(int rows, int columns) {
		currentGeneration = new CellGrid(rows, columns, CellState.DEAD);
		initializeCells();
	}

	@Override
	public void initializeCells() {
		Random random = new Random();
		for (int row = 0; row < currentGeneration.numRows(); row++) {
			for (int col = 0; col < currentGeneration.numColumns(); col++) {
				if (random.nextBoolean()) {
					currentGeneration.set(row, col, CellState.ALIVE);
				} else {
					currentGeneration.set(row, col, CellState.DEAD);
				}
			}
		}
	}

	@Override
	public int numberOfRows() {
		// TODO
		return currentGeneration.numRows();
	}

	@Override
	public int numberOfColumns() {
		// TODO
		return currentGeneration.numColumns();
	}

	@Override
	public CellState getCellState(int row, int col) {
		// TODO
		return currentGeneration.get(numberOfRows(), numberOfColumns());
	}

	@Override
	public void step() {
		IGrid nextGeneration = currentGeneration.copy();
		// TODO
	}

	@Override
	public CellState getNextCell(int row, int col) {
		// TODO
		return null;
	}

	/**
	 * Calculates the number of neighbors having a given CellState of a cell on
	 * position (row, col) on the board
	 * 
	 * Note that a cell has 8 neighbors in total, of which any number between 0 and
	 * 8 can be the given CellState. The exception are cells along the boarders of
	 * the board: these cells have anywhere between 3 neighbors (in the case of a
	 * corner-cell) and 5 neighbors in total.
	 * 
	 * @param x     the x-position of the cell
	 * @param y     the y-position of the cell
	 * @param state the Cellstate we want to count occurences of.
	 * @return the number of neighbors with given state
	 */
	private int countNeighbors(int row, int col, CellState state) {
		// TODO
		return 0;
	}

	@Override
	public IGrid getGrid() {
		return currentGeneration;
	}
}
