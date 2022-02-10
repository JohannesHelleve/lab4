package cellular;

import datastructure.IGrid;

/**
 * 
 * An CellAutomaton represents a Cellular Automaton. The
 * automaton contains a cell generation organized in rows
 * and columns.
 * 
 * 
 * @author Anna Eilertsen - anna.eilertsen@uib.no
 */
public interface CellAutomaton {

	/**
	 * 
	 * Get the state of the cell in the provided row and column
	 * 
	 * @param row    The row of the cell, 0-indexed
	 * @param column The column of the cell, 0-indexed
	 * @return The state of the cell in the given row and column.
	 */
	CellState getCellState(int row, int column);

	/**
	 * Sets the start-state for each cell
	 */
	void initializeCells();

	/**
	 * Updates the state of the cell according to the rules of the automaton
	 */
	void step();

	/**
	 * Given the current state of the cell and the number of alive neighbours,
	 * decide the next state of the cell.
	 * 
	 * @param row    The row of the cell, 0-indexed
	 * @param column The column of the cell, 0-indexed
	 * @return state of cell for next generation
	 */
	CellState getNextCell(int row, int col);

	/**
	 * @return The number of rows in this automaton
	 */
	int numberOfRows();

	/**
	 * @return The number of columns in this automaton
	 */
	int numberOfColumns();

	IGrid getGrid();

}
