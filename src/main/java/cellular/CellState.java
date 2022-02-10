package cellular;

import java.awt.Color;
import java.util.Random;

/**
 * The State of a cell, either Alive or Dead
 * Each CellState is associated with a Color
 * 
 * ALIVE => BLACK
 * DEAD => WHITE
 * 
 */
public enum CellState {
	// make the instances this enum should hold
	ALIVE(Color.BLACK),
	DEAD(Color.WHITE);

	private Color color;

	/**
	 * Constructor which makes a CellState with a given color
	 * Note that the constructor is private so you can not make new CellStates.
	 * You can only use the two that are already made, ALIVE or DEAD
	 * 
	 * @param color
	 */
	private CellState(Color color) {
		this.color = color;
	}

	public static CellState random(Random rand) {
		return CellState.values()[rand.nextInt(2)];
	}

	/**
	 * Returns the cell state represented as a color
	 * 
	 * @return black if the cell is alive, white otherwise
	 */
	public Color getColor() {
		return color;
	}
}
