package vista;

import java.awt.BorderLayout;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class UIRaces {

	public static void run() {

		JFrame frame = new JFrame();
		frame.add(new JLabel("CARRERAS EN CURSO"), BorderLayout.NORTH);

		JTextArea ta = new JTextArea();
		TextAreaOutputStream taos = new TextAreaOutputStream(ta, 60);
		PrintStream ps = new PrintStream(taos);

		System.setErr(ps);
		frame.add(new JScrollPane(ta));

		frame.pack();
		frame.setVisible(true);
		frame.setSize(800, 600);
	}
}
