package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cellular.CellAutomaton;

/**
 * 
 * The application in which AutomatonComponent is displayed.
 * 
 * @author eivind
 */
public class CellAutomataGUI extends JPanel implements ActionListener {

	private static final long serialVersionUID = 8755882090377973497L;

	AutomatonComponent automatonComponent;
	CellAutomaton automaton;
	private javax.swing.Timer timer;

	private JButton startButton;
	private JButton stopButton;
	private JButton stepButton;

	private JButton setBoardButton;

	public CellAutomataGUI(CellAutomaton automata) {
		this.automaton = automata;
	}

	/**
	 * Sets up the GUI.
	 */
	public void initialize() {
		setLayout(new BorderLayout());

		automaton.initializeCells();
		automatonComponent = new AutomatonComponent(automaton);

		JPanel p = new JPanel();

		startButton = new JButton();
		startButton.addActionListener(this);
		startButton.setText("Start Automaton");

		setBoardButton = new JButton();
		setBoardButton.addActionListener(this);
		setBoardButton.setText("Reset Board");

		stopButton = new JButton();
		stopButton.addActionListener(this);
		stopButton.setText("Stop Automaton");

		stepButton = new JButton();
		stepButton.addActionListener(this);
		stepButton.setText("Next Step");

		p.add(startButton);
		p.add(stopButton);
		p.add(stepButton);
		p.add(setBoardButton);
		add(p, BorderLayout.NORTH);
		add(automatonComponent, BorderLayout.CENTER);

		timer = new javax.swing.Timer(1000 / 20, this);
	}

	/**
	 * 
	 * Initializes a JFrame in which we place the a CellAutomataGUI containing
	 * the given CellAutomaton.
	 * 
	 * @param ca a CellAutomaton
	 */
	public static void run(CellAutomaton ca) {
		JFrame f = new JFrame("INF101 Cell Automaton");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CellAutomataGUI ap = new CellAutomataGUI(ca);
		ap.initialize();
		f.add("Center", (Component) ap);
		f.pack();
		f.setVisible(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * 
	 * Called whenever a button is pressed or the timer tells us its time to
	 * make a step.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == timer) {
			timer.restart();
			automaton.step();
			automatonComponent.repaint();
		} else if (e.getSource() == startButton) {
			timer.start();
		} else if (e.getSource() == stopButton) {
			timer.stop();
		} else if (e.getSource() == stepButton) {
			timer.stop();
			automaton.step();
			automatonComponent.repaint();
		} else if (e.getSource() == setBoardButton) {
			automaton.initializeCells();
			automatonComponent.repaint();
		}
	}
}