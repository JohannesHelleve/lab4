package gui;

import cellular.CellAutomaton;
import cellular.GameOfLife;

public class Main {

	public static void main(String[] args) {
		CellAutomaton ca = new GameOfLife(100,100);
		//CellAutomaton ca = new BriansBrain(100, 100);
		CellAutomataGUI.run(ca);
	}

}
