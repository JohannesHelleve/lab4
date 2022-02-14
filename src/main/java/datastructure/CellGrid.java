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
        // TODO Auto-generated method stub
        return rows;
    }

    @Override
    public int numColumns() {
        // TODO Auto-generated method stub
        return columns;
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
