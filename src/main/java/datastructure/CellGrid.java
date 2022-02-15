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
                grid.add(initialState);
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
        if (((0 <= row) && (row < rows)) && ((0 <= column) && (column < columns))){
            int index = column+row*columns;
            grid.set(index, element);
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public CellState get(int row, int column) {
        if (((0 <= row) && (row < rows)) && ((0 <= column) && (column < columns))){
            int index = column+row*columns;
            return grid.get(index);
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public IGrid copy() {
        IGrid copy = new CellGrid(rows,columns,initialState);
        return copy;
    }
    
}
