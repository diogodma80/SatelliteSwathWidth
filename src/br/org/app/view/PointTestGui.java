package br.org.app.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.org.controller.SatelliteTrack;
import br.org.model.swath.TestPointInsideSwathPath;

public class PointTestGui {

	public JFrame frame;
	private JLabel latitude;
	private JLabel longitude;
	
	private JButton testPoint;
	private JButton clean;
	
	private JTextField latitudeTF;
	private JTextField longitudeTF;
	
	private SatelliteTrack track;
	private GridLayout layout;
	
	/**
	 * Create the application.
	 * @param track 
	 */
	public PointTestGui(SatelliteTrack track) {
		this.track = track;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("GuiTest");
		frame.setSize(350, 110);
		
		this.latitude = new JLabel("Latitude");
		this.longitude = new JLabel("Longitude");
		this.testPoint = new JButton("Test point");
		this.clean = new JButton("Clean");
		this.latitudeTF = new JTextField("");
		this.longitudeTF = new JTextField("");
		
		this.layout = new GridLayout(3, 2, 5, 5);
		frame.setLayout(layout);
		
		frame.add(latitude);
		frame.add(latitudeTF);
		frame.add(longitude);
		frame.add(longitudeTF);
		frame.add(testPoint);
		frame.add(clean);
		
		ButtonHandler handler = new ButtonHandler();
		
		clean.addActionListener(handler);
		testPoint.addActionListener(handler);
	}
	
	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == clean){
				latitudeTF.setText("");
				longitudeTF.setText("");
			} else if (e.getSource() == testPoint && latitudeTF.getText().isEmpty() != true && longitudeTF.getText().isEmpty() != true) {
				double latitudeValue = Double.parseDouble(latitudeTF.getText());
				double longitudeValue = Double.parseDouble(longitudeTF.getText());
				TestPointInsideSwathPath testPoint = new TestPointInsideSwathPath(latitudeValue, longitudeValue, track);
			}
			
		}
		
	}
	
	

}
