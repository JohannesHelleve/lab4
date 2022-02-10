package datastructure;

import cellular.CellState;

/**
 * IGrid is a grid of {@link cellular.CellState CellState}.
 * A grid is a data structure much similar to a list, but each element belong to
 * a row and a column
 * 
 * @author Anna Eilertsen - anna.eilertsen@uib.no
 * @author Martin Vatshelle - martin.vatshelle@uib.no
 * @author Sondre Bolland - sondre.bolland@uib.no
 *
 */
public interface IGrid {

	/**
	 * @return The height of the grid.
	 */
	int numRows();

	/**
	 * @return The width of the grid.
	 */
	int numColumns();

	/**
	 * 
	 * Set the contents of the cell in the given row,column location.
	 * 
	 * row must be greater than or equal to 0 and less than numRows().
	 * column must be greater than or equal to 0 and less than numColumns().
	 * 
	 * If invalid values for row or column is passed, an InvallidArgumentException
	 * is thrown.
	 * 
	 * @param x       The column of the cell to change the contents of.
	 * @param y       The row of the cell to change the contents of.
	 * @param element The contents the cell is to have.
	 */
	void set(int row, int column, CellState element);

	/**
	 * 
	 * Get the contents of the cell in the given row,column location.
	 * 
	 * row must be greater than or equal to 0 and less than numRows().
	 * column must be greater than or equal to 0 and less than numColumns().
	 * 
	 * @param column The column of the cell to get the contents of.
	 * @param row    The row of the cell to get contents of.
	 */
	CellState get(int row, int column);

	/**
	 * Make a copy of this grid
	 * This is a shallow copy meaning only the grid structure is copied
	 * the elements are not copies, they are the same.
	 *
	 * @return A copy of the grid, with the same elements
	 */
	IGrid copy();

}