package br.org.app.main;

import javax.swing.JFrame;

import br.org.app.view.Gui;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Gui gui = new Gui();
		gui.setLocationRelativeTo(null);
		gui.setSize(1000, 400);
		gui.setVisible(true);
		gui.setResizable(false);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
