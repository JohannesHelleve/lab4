package datastructure;

import cellular.CellState;

public class CellGrid implements IGrid {

    int rows = 0;
    int columns = 0;
    CellState initialState = CellState.DEAD;

    public CellGrid(int rows, int columns, CellState initialState) {
		this.rows = rows;
        this.columns = columns;
        this.initialState = initialState;
	}

    @Override
    public int numRows() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int numColumns() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void set(int row, int column, CellState element) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public CellState get(int row, int column) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IGrid copy() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
