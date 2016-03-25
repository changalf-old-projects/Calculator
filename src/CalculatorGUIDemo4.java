import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;


public class CalculatorGUIDemo4 extends JFrame implements ActionListener {
	
	public static int WIDTH = 380;
	public static int HEIGHT = 250;

	private JPanel[] row = new JPanel[5];		//one panel for each row of components
	private JButton[] button = new JButton[19];			//19 buttons in total
	private String[] buttonValue = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*",
			".", "/", "C", "sqrt", "+/-", "=", "0"};
	private int[] dimW = {300, 45, 100, 90};		//widths for various components
	private int[] dimH = {35, 40};		//heights for various components
	
	//declare and initialize dimensions
	private Dimension displayDim = new Dimension(dimW[0], dimH[0]);
	private Dimension regularButtonDim = new Dimension(dimW[1], dimH[0]);
	private Dimension rightColumnDim = new Dimension(dimW[2], dimH[1]);
	private Dimension zeroButtonDim = new Dimension(dimW[2], dimH[1]);
	
	private boolean[] function = new boolean[4];
	private double[] temp = {0, 0};
	
	private JTextArea display = new JTextArea(1, 20);
	private Font displayFont = new Font("Helvetica", Font.PLAIN, 22);
	private Font buttonFont = new Font("Arial", Font.BOLD, 12);
	
	public CalculatorGUIDemo4() {
		super("Very nice calculator");
		setDesign();
		setSize(WIDTH, HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(5, 5));
		
		//initialize function[]
		for (int i = 1; i < 4; i++) {
			function[i] = false;
		}
		
		//initialize row[]
		for (int i = 0; i < 5; i++) {
			row[i] = new JPanel();
		}
		
		//set layout managers for each panel in row[]
		row[0].setLayout(new FlowLayout(FlowLayout.CENTER));
		for (int i = 1; i < 5; i++) {
			row[i].setLayout(new FlowLayout(FlowLayout.CENTER, 1, 1));
		}
		
		//implement buttons
		for (int i = 0; i < 19; i++) {
			button[i] = new JButton();
			button[i].setText(buttonValue[i]);
			button[i].setFont(buttonFont);
			button[i].addActionListener(this);
		}
		
		//implement display
		display.setFont(displayFont);
		display.setEditable(false);
		display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		display.setPreferredSize(displayDim);
		display.setBackground(Color.BLUE.darker());
		display.setForeground(Color.WHITE);
		
		//set sizes of components
		for (int i = 0; i < 14; i++) {
			button[i].setPreferredSize(regularButtonDim);
		}
		for (int i = 14; i < 18; i++) {
			button[i].setPreferredSize(rightColumnDim);
		}
		button[18].setPreferredSize(zeroButtonDim);
		
		//add display to top panel
		row[0].add(display);
		add(row[0]);
		//add buttons to remaining rows
		for (int i = 0; i < 4; i++) {
			row[1].add(button[i]);
		}
		row[1].add(button[14]);
		add(row[1]);
		
		for (int i = 4; i < 8; i++) {
			row[2].add(button[i]);
		}
		row[2].add(button[15]);
		add(row[2]);
		
		for (int i = 8; i < 12; i++) {
			row[3].add(button[i]);
		}
		row[3].add(button[16]);
		add(row[3]);
		
		row[4].add(button[18]);			//this is the "0" button
		
		for (int i = 12; i < 14; i++) {
			row[4].add(button[i]);
		}
		row[4].add(button[17]);
		add(row[4]);
		
		setVisible(true);
	}
	
	//set look and feel for calculator (user experience)
	public final void setDesign() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println("Something went wrong...");
		}
	}
	
	public void clear() {
		try {
			display.setText("");
			for (int i = 0; i < 4; i++) {
				function[i] = false;
			}
			for (int i = 0; i < 2; i++) {
				temp[i] = 0;
			}
		} catch (NullPointerException npe) {
			System.out.println("Something is null here...");
		}
	}
	
	public void getSquareRoot() {
		try {
			double value = Math.sqrt(Double.parseDouble(display.getText()));
			display.setText(Double.toString(value));
		} catch (NumberFormatException nfe) {
			System.out.println("Some number is not right here...");
		}
	}
	
	public void getPosNeg() {
		try {
			double value = Double.parseDouble(display.getText());
			value *= -1;
			display.setText(Double.toString(value));
		} catch (NumberFormatException nfe) {
			System.out.println("Some number is not right here...");
		}
	}
	
	public void getResult() {
		double result = 0;			//this variablae will store the final result
		temp[1] = Double.parseDouble(display.getText());
		String temp0 = Double.toString(temp[0]);
		String temp1 = Double.toString(temp[1]);
		
		try {
			if (temp0.contains("-")) {
				String[] temp00 = temp0.split("-", 2);
				temp[0] = Double.parseDouble(temp00[1]) * -1;
			}
			if (temp1.contains("-")) {
				String[] temp11 = temp1.split("-", 2);
				temp[1] = Double.parseDouble(temp11[1]) * -1;
			}
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println("The index accessed was either negative or past the index of the last element...");
		}
		try {
			if (function[2] == true) {
				result = temp[0] * temp[1];
			} else if (function[3] == true) {
				result = temp[0] / temp[1];
			} else if (function[0] == true) {
				result = temp[0] + temp[1];
			} else if (function[1] == true) {
				result = temp[0] - temp[1];
			}
			display.setText(Double.toString(result));
			
			for (int i = 0; i < 4; i++) {
				function[i] = false;
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Some number is formatted improperly here...");
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == button[0]) {
			display.append("7");
		}
		if (ae.getSource() == button[1]) {
			display.append("8");
		}
		if (ae.getSource() == button[2]) {
			display.append("9");
		}
		if (ae.getSource() == button[3]) {
			temp[0] = Double.parseDouble(display.getText());
			function[0] = true;
			display.setText("");
		}
		if (ae.getSource() == button[4]) {
			display.append("4");
		}
		if (ae.getSource() == button[5]) {
			display.append("5");
		}
		if (ae.getSource() == button[6]) {
			display.append("6");
		}
		if (ae.getSource() == button[7]) {
			temp[0] = Double.parseDouble(display.getText());
			function[1] = true;
			display.setText("");
		}
		if (ae.getSource() == button[8]) {
			display.append("1");
		}
		if (ae.getSource() == button[9]) {
			display.append("2");
		}
		if (ae.getSource() == button[10]) {
			display.append("3");
		}
		if (ae.getSource() == button[11]) {
			temp[0] = Double.parseDouble(display.getText());
			function[2] = true;
			display.setText("");
		}
		if (ae.getSource() == button[12]) {
			display.append(".");
		}
		if (ae.getSource() == button[13]) {
			temp[0] = Double.parseDouble(display.getText());
			function[3] = true;
			display.setText("");
		}
		if (ae.getSource() == button[14]) {
			clear();
		}
		if (ae.getSource() == button[15]) {
			getSquareRoot();
		}
		if (ae.getSource() == button[16]) {
			getPosNeg();
		}
		if (ae.getSource() == button[17]) {
			getResult();
		}
		if (ae.getSource() == button[18]) {
			display.append("0");
		}
		
	}
	
}
