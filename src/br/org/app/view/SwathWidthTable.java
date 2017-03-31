package br.org.app.view;

import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SwathWidthTable extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double subSatellitePoints;
	private List<Double> centerLat;
	private List<Double> centerLon;
	private List<Double> latRight;
	private List<Double> latLeft;
	private List<Double> lonRight;
	private List<Double> lonLeft;
	private List<Double> sensorCenterLat;
	private List<Double> sensorCenterLon;
	private Object[][] table;
	private String[] columnNames = {"Center Latitude", "Center Longitude", "LatRight", "LonRight", "LatLeft", "LonLeft", "LatCentral", "LonCentral"};
	private JTable jTable;
	private JScrollPane scrollPane;
	
	private final String precisao = "%.4f";
	private JLabel label; 

	public SwathWidthTable() {
		super("Table");
		
	}
	
	public SwathWidthTable(List<Double> centerLat, List<Double> centerLon, List<Double> latRight, List<Double> lonRight, List<Double> latLeft,  List<Double> lonLeft, double subSatellitePoints, List<Double> sensorCentralLat, List<Double> sensorCenterLon) {
		super();
		this.subSatellitePoints = subSatellitePoints;
		this.centerLat = centerLat;
		this.centerLon = centerLon;
		this.latRight = latRight;
		this.lonRight = lonRight;
		this.latLeft = latLeft;
		this.lonLeft = lonLeft;
		this.sensorCenterLat = sensorCentralLat;
		this.sensorCenterLon = sensorCenterLon;
		
		this.table = new Object[(int) subSatellitePoints][8];
		

		setTable();
		jTable = new JTable(table, columnNames);
		jTable.setFont(new Font("Arial", 1, 20));
		jTable.setRowHeight(30);
		scrollPane = new JScrollPane(jTable);
		this.getContentPane().add(scrollPane);	
	}
	
	public void setTable(){

		for(int x = 0; x < subSatellitePoints; x++){
			int y = 0;
				table[x][y] = Double.valueOf(String.format(precisao, centerLat.get(x)).replace(",", "."));
				table[x][++y] = Double.valueOf(String.format(precisao, centerLon.get(x)).replace(",", "."));
				table[x][++y] = Double.valueOf(String.format(precisao, latRight.get(x)).replace(",", "."));
				table[x][++y] = Double.valueOf(String.format(precisao, lonRight.get(x)).replace(",", "."));
				table[x][++y] = Double.valueOf(String.format(precisao, latLeft.get(x)).replace(",", "."));
				table[x][++y] = Double.valueOf(String.format(precisao, lonLeft.get(x)).replace(",", "."));
				table[x][++y] = Double.valueOf(String.format(precisao, sensorCenterLat.get(x)).replace(",", "."));
				table[x][++y] = Double.valueOf(String.format(precisao, sensorCenterLon.get(x)).replace(",", "."));
		}
	}
}
