package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;

import cellular.CellAutomaton;

/**
 * 
 * A Component that draws the cells in a Cell Automaton.
 * 
 * @author eivind
 */
class AutomatonComponent extends Component {
	/**
	 * The dimension of the grid containing the cells.
	 */
	private Dimension gridDim;
	/**
	 * The automaton to paint the cells of.
	 */
	private CellAutomaton automaton;

	/**
	 * The height of each cell in pixels.
	 */
	private final int cellHeight = 5;

	/**
	 * The width of each cell in pixels.
	 */
	private final int cellWidth = 5;
	/**
	 * The size of the space between each cell and between the cell and the edge
	 * of the window.
	 */
	private final int padding = 1;
	private static final long serialVersionUID = 4548104480314044678L;

	/**
	 * Construct a AutomatonComponent that will paint the given automaton.
	 * 
	 * @param grid
	 */
	public AutomatonComponent(CellAutomaton automaton) {
		this.automaton = automaton;
		gridDim = new Dimension((cellWidth + padding) * automaton.numberOfColumns()
				+ padding, (cellHeight + padding) * automaton.numberOfRows() + padding);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Component#getPreferredSize() Returns the dimensions of the
	 * grid.
	 */
	@Override
	public Dimension getPreferredSize() {
		return gridDim;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Component#paint(java.awt.Graphics) Paints the automaton.
	 */
	public void paint(Graphics g) {
		for (int row = 0; row < automaton.numberOfRows(); row++) {
			for (int col = 0; col < automaton.numberOfColumns(); col++) {
				g.setColor(automaton.getCellState(row, col).getColor());
				g.fillRect(col * (cellWidth + padding) + padding,
						row * (cellHeight + padding) + padding,
						cellHeight, cellWidth);
			}
		}
	}
}
