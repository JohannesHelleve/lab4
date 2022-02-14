package datastructure;

import cellular.CellState;

import java.util.ArrayList;

public class CellGrid implements IGrid {

    int rows = 0;
    int columns = 0;
    CellState initialState = CellState.DEAD;
    ArrayList<CellState> grid = new ArrayList<>();

    public CellGrid(int rows, int columns, CellState initialState) {
		this.rows = rows;
        this.columns = columns;
        this.initialState = initialState;
        for(int row = 0; row < rows; row++){
            for (int col = 0; col < columns; col++){
                grid.add(CellState.DEAD);
            }
        }
	}

    @Override
    public int numRows() {
        return rows;
    }

    @Override
    public int numColumns() {
        return columns;
    }

    @Override
    public void set(int row, int column, CellState element) {
        if (((0 <= row) && (row > rows)) && ((column <= 0) && (column > columns))){
            throw new IndexOutOfBoundsException();
        }
        int index = column+row*columns;
        grid.set(index, element);
    }

    @Override
    public CellState get(int row, int column) {
        if (((0 <= row) && (row > rows)) && ((0 <= column) && (column > columns))){
            throw new IndexOutOfBoundsException();
        }
        int index = column+row*columns;
        return grid.get(index);
    }

    @Override
    public IGrid copy() {
        return null;
    }
    
}
