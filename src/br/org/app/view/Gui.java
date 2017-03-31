package br.org.app.view;


import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.scene.text.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.org.calc.area.CalculaAreaVicenty;
import br.org.controller.SatelliteTrack;
import br.org.model.swath.LateralSwathWidth;

public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel boresightAngleJLabel;
	private JLabel apertureAngleJLabel;
	private JLabel altitudeInMeterJLabel;
	private JLabel sensorHeadingJLabel;
	private JLabel subSatellitePointsJLabel;
	private JLabel latitudeJLabel;
	private JLabel longitudeJLabel;
	private JLabel nextPointAheadDistanceJLabel;
	private JLabel emptySpace1;
	private JLabel emptySpace2;
	private JLabel emptySpace3;
	private JLabel emptySpace4;
	private JLabel emptySpace5;
	private JLabel emptySpace6;
	private JLabel emptySpace7;
	private JLabel emptySpace8;
	private JLabel emptySpace9;
	private JLabel emptySpace10;
	
	//private JLabel emptySpace11;
	//private JLabel emptySpace12;

	private JTextField boresightAngleJTextField;
	private JTextField apertureAngleJTextField;
	private JTextField altitudeInMetersJTextField;
	private JTextField sensorHeadingJTextField;
	private JTextField subSatellitePointsJTextField;
	private JTextField latitudeJTextField;
	private JTextField longitudeJTextField;
	private JTextField nextPointAheadDistanceJTextField;

	private JButton calcularJButton;
	private JButton sairJButton;
	private JButton limparJButton;
	private JButton satelliteTrackButton;
	private JButton callSTKGuiButton;
	private JButton callMainSTKApp;
	private JButton getAreaButton;
	private JButton findPointButton;

	private GridLayout layout;

	private LateralSwathWidth lateralSwathWidth;
	private SatelliteTrack track;

	private double nextPointAheadDistance;
	private double subSatellitePoints;
	private double sensorHeading;
	private double latitude;
	private double longitude;
	private double apertureAngle;
	private double altitudeInMeters;
	private double boresightAngle;
	java.awt.Font font = new java.awt.Font("Arial", 1, 20);

	public Gui() {
		super("Satellite Swath Width");
		
		

		this.boresightAngleJLabel = new JLabel("Boresight angle");
		this.apertureAngleJLabel = new JLabel("Aperture angle");
		this.altitudeInMeterJLabel = new JLabel("Altitude in meters");
		this.sensorHeadingJLabel = new JLabel("Heading angle");
		this.subSatellitePointsJLabel = new JLabel("Sub-satellite points");
		this.latitudeJLabel = new JLabel("Latitude");
		this.longitudeJLabel = new JLabel("Longitude");
		this.nextPointAheadDistanceJLabel = new JLabel("Path Distance in meters");		
		this.emptySpace1 = new JLabel("");
		this.emptySpace2 = new JLabel("");
		this.emptySpace3 = new JLabel("");
		this.emptySpace4 = new JLabel("");
		this.emptySpace5 = new JLabel("");
		this.emptySpace6 = new JLabel("");
		this.emptySpace7 = new JLabel("");
		this.emptySpace8 = new JLabel("");
		this.emptySpace9 = new JLabel("");
		this.emptySpace10 = new JLabel("");
		

		
		/**

   



		 * **/

		
		//this.emptySpace11 = new JLabel("");
		// this.emptySpace12 = new JLabel("");

		this.boresightAngleJTextField = new JTextField();
		this.boresightAngleJTextField.setToolTipText("Sensor boresight angle\n "
				+ "which axis determines the direction\n "
				+ "the sensor points to");

		this.apertureAngleJTextField = new JTextField();
		this.apertureAngleJTextField.setToolTipText("Sensor aperture angle");

		this.altitudeInMetersJTextField = new JTextField();
		this.altitudeInMetersJTextField.setToolTipText("Sensor altitude in meters");

		this.sensorHeadingJTextField = new JTextField();
		this.sensorHeadingJTextField
				.setToolTipText("Sensor direction angle starting from North");

		this.subSatellitePointsJTextField = new JTextField();
		this.subSatellitePointsJTextField
				.setToolTipText("How many sub-satellite positions should be counted");

		this.latitudeJTextField = new JTextField();
		this.latitudeJTextField.setToolTipText("Sensor initial latitude");

		this.longitudeJTextField = new JTextField();
		this.longitudeJTextField.setToolTipText("Sensor initial longitude");

		this.nextPointAheadDistanceJTextField = new JTextField();
		this.nextPointAheadDistanceJTextField
				.setToolTipText("Path distance given in meters");

		this.calcularJButton = new JButton("Swath width");
		this.sairJButton = new JButton("Exit");
		this.limparJButton = new JButton("Clean");
		this.satelliteTrackButton = new JButton("Get track");
		this.callSTKGuiButton = new JButton("STK GUI");
		this.callMainSTKApp = new JButton("STK App");
		this.getAreaButton = new JButton("Get Area");
		this.findPointButton = new JButton("Find point");

		this.layout = new GridLayout(8, 4, 5, 5);
		this.setLayout(layout);

		// row 1
		this.getContentPane().add(boresightAngleJLabel);
		this.getContentPane().add(boresightAngleJTextField);
		this.getContentPane().add(emptySpace1);
		this.getContentPane().add(calcularJButton);
		// row 2
		this.getContentPane().add(apertureAngleJLabel);
		this.getContentPane().add(apertureAngleJTextField);
		this.getContentPane().add(emptySpace2);
		this.getContentPane().add(satelliteTrackButton);

		// row 3
		this.getContentPane().add(altitudeInMeterJLabel);
		this.getContentPane().add(altitudeInMetersJTextField);
		this.getContentPane().add(emptySpace3);
		this.getContentPane().add(callSTKGuiButton);

		// row 4
		this.getContentPane().add(sensorHeadingJLabel);
		this.getContentPane().add(sensorHeadingJTextField);
		this.getContentPane().add(emptySpace4);
		this.getContentPane().add(getAreaButton);
		//this.getContentPane().add(callMainSTKApp);

		// row 5
		this.getContentPane().add(subSatellitePointsJLabel);
		this.getContentPane().add(subSatellitePointsJTextField);
		this.getContentPane().add(emptySpace5);
		this.getContentPane().add(findPointButton);
		//this.getContentPane().add(emptySpace6);

		// row 6
		this.getContentPane().add(latitudeJLabel);
		this.getContentPane().add(latitudeJTextField);
		this.getContentPane().add(emptySpace7);
		this.getContentPane().add(emptySpace8);

		// row 7
		this.getContentPane().add(longitudeJLabel);
		this.getContentPane().add(longitudeJTextField);
		this.getContentPane().add(emptySpace9);
		this.getContentPane().add(limparJButton);

		// row 8
		this.getContentPane().add(nextPointAheadDistanceJLabel);
		this.getContentPane().add(nextPointAheadDistanceJTextField);
		this.getContentPane().add(emptySpace10);
		this.getContentPane().add(sairJButton);
		
		
		//setting the font size to the GUI elements
		this.boresightAngleJLabel.setFont(font);
		this.apertureAngleJLabel.setFont(font);
		this.altitudeInMeterJLabel.setFont(font);
		this.sensorHeadingJLabel.setFont(font);
		this.subSatellitePointsJLabel.setFont(font);
		this.latitudeJLabel.setFont(font);
		this.longitudeJLabel.setFont(font);
		this.nextPointAheadDistanceJLabel.setFont(font);
		this.calcularJButton.setFont(font);
		this.sairJButton.setFont(font);
		this.limparJButton.setFont(font);
		this.satelliteTrackButton.setFont(font);
		this.callSTKGuiButton.setFont(font);
		this.callMainSTKApp.setFont(font);
		this.getAreaButton.setFont(font);
		this.findPointButton.setFont(font);
	    this.boresightAngleJTextField.setFont(font);
		this.apertureAngleJTextField.setFont(font);
		this.altitudeInMetersJTextField.setFont(font);
		this.altitudeInMetersJTextField.setFont(font);
		this.sensorHeadingJTextField.setFont(font);
		this.sensorHeadingJTextField.setFont(font);
		this.subSatellitePointsJTextField.setFont(font);
		this.subSatellitePointsJTextField.setFont(font);
		this.latitudeJTextField.setFont(font);
		this.latitudeJTextField.setFont(font);
		this.longitudeJTextField.setFont(font);
		this.longitudeJTextField.setFont(font);
		this.nextPointAheadDistanceJTextField.setFont(font);
		this.nextPointAheadDistanceJTextField.setFont(font);
		

		ButtonHandler handler = new ButtonHandler();

		calcularJButton.addActionListener(handler);
		sairJButton.addActionListener(handler);
		limparJButton.addActionListener(handler);
		satelliteTrackButton.addActionListener(handler);
		callSTKGuiButton.addActionListener(handler);
		callMainSTKApp.addActionListener(handler);
		getAreaButton.addActionListener(handler);
		findPointButton.addActionListener(handler);
	}

	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == limparJButton) {
				cleanFields();
			} else if (e.getSource() == sairJButton) {
				sair();
			} else if (e.getSource() == calcularJButton) {
				calcularSwathWidth();
			} else if (e.getSource() == satelliteTrackButton) {
				getSatelliteTrack();
			} else if(e.getSource() == getAreaButton){
				getArea();
			} else if (e.getSource() == findPointButton) {
				findPointMethod();
			}
		}

		private void findPointMethod() {
			if(track != null){
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PointTestGui window = new PointTestGui(track);
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			} else {
				JLabel label = new JLabel("First calculates the satellite swath width");
				label.setFont(font);
				JOptionPane.showMessageDialog(null, label);
			}		
		}

		private void getArea() {
			JLabel label;
			if(track != null){
				CalculaAreaVicenty distancia = new CalculaAreaVicenty(track.getLatitudeFirstLastRightLeft(), track.getLongitudeFirstLastRightLeft());
				double area = distancia.getArea();
				
				
				
				String result = String.format("The total covered area is %.2f km²", area);
				label = new JLabel(result);
				label.setFont(font);
				JOptionPane.showMessageDialog(null, label, "Covered area", JOptionPane.INFORMATION_MESSAGE);
			} else {
				label = new JLabel("First calculates the satellite swath width");
				label.setFont(font);
				JOptionPane.showMessageDialog(null, label);
			}
			
		}

		private void getSatelliteTrack() {
			JLabel label;
			boolean go = true;
			// entrada de dados
			try {
				nextPointAheadDistance = Double.parseDouble(nextPointAheadDistanceJTextField.getText());
				subSatellitePoints = Double.parseDouble(subSatellitePointsJTextField.getText());
				sensorHeading = Double.parseDouble(sensorHeadingJTextField.getText());
				latitude = Double.parseDouble(latitudeJTextField.getText());
				longitude = Double.parseDouble(longitudeJTextField.getText());
				apertureAngle = Double.parseDouble(apertureAngleJTextField.getText());
				altitudeInMeters = Double.parseDouble(altitudeInMetersJTextField.getText());
				boresightAngle = Double.parseDouble(boresightAngleJTextField.getText());
			} catch (IllegalArgumentException e) {
				label = new JLabel("Input values failed. Try again");
				label.setFont(font);
				JOptionPane.showMessageDialog(null, label);
				go = false;
			}

			if (go) {
				// calcular a distï¿½ncia do boresight e das laterais da
				// cobertura referente ao centro do trajeto do sensor+satelite
				lateralSwathWidth = new LateralSwathWidth(boresightAngle, apertureAngle, altitudeInMeters);

				// boresight distance
				double boresightDistance = lateralSwathWidth.getBoresightDistance();

				// distancias entre a trajetï¿½ria do satelite e a trajetï¿½ria das
				// laterais limites da cobertura
				double lateralDistanceToRight = lateralSwathWidth.getLateralDistanceToRight();
				double lateralDistanceToLeft = lateralSwathWidth.getLateralDistanceToLeft();

				track = new SatelliteTrack(subSatellitePoints, sensorHeading, latitude, longitude, 
						boresightDistance, nextPointAheadDistance, apertureAngle, 
						altitudeInMeters, boresightAngle, lateralDistanceToRight, lateralDistanceToLeft);
				track.getTrack();
			}

		}

		private void sair() {
			System.exit(1);

		}

		/**
		 * metodo que calcular a largura cobertura e armazena este valor na
		 * variÃ¡vel swathValue
		 */
		private void calcularSwathWidth() {
			JLabel label;
			try {
				double boresight = Double.parseDouble(boresightAngleJTextField
						.getText());
				double aperture = Double.parseDouble(apertureAngleJTextField
						.getText());
				double altitude = Double.parseDouble(altitudeInMetersJTextField
						.getText());
				lateralSwathWidth = new LateralSwathWidth(boresight, aperture, altitude);
				String result = String.format("Swath width: %f metros", +(lateralSwathWidth.getLateralDistanceToRight() + lateralSwathWidth.getLateralDistanceToLeft()));
				JOptionPane.showMessageDialog(null, result);
			} catch (Exception e) {
				label = new JLabel("Type only numbers here");
				label.setFont(font);
				JOptionPane.showMessageDialog(null, label,
						"Error on data input", JOptionPane.ERROR_MESSAGE);
				cleanFields();
			}
		}

		private void cleanFields() {
			boresightAngleJTextField.setText("");
			apertureAngleJTextField.setText("");
			altitudeInMetersJTextField.setText("");
			sensorHeadingJTextField.setText("");
			subSatellitePointsJTextField.setText("");
			latitudeJTextField.setText("");
			longitudeJTextField.setText("");
			nextPointAheadDistanceJTextField.setText("");
		}
	}

}
