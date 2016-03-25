import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.*;

public class CalculatorGUIDemo implements ActionListener {
	
	private Font RESULT_FONT = new Font("Helvetica", Font.PLAIN, 50);
	private Font BUTTON_FONT = new Font("Verdana", Font.BOLD, 30);
	
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, plus, minus, times, divide, equals,
			delete, clear;
	private JButton[] buttons = {b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, plus, minus, times, divide, equals,
			delete, clear};
	private String[] buttonNames = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "x", "0", "del", 
			"C", "/", "="};
	protected JTextField tField;
	
	public CalculatorGUIDemo() {
		createCalculatorGUI();
	}
	
	public void createCalculatorGUI() {
		JFrame frame = new JFrame("Random Calculator");
		frame.setSize(375, 610);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridBagConstraints c = new GridBagConstraints();
		
		//panel for display window
		JPanel panel1 = new JPanel(new GridBagLayout());
		panel1.setOpaque(true);
		panel1.setBackground(Color.GRAY);
		tField = new JTextField();
		tField.setBackground(Color.ORANGE);
		tField.setHorizontalAlignment(JTextField.RIGHT);
		tField.setFont(RESULT_FONT);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 360;		//make the text field span most of frame width
		c.ipady = 75;		//make the text field tall
		panel1.add(tField, c);
		
		JPanel panel2 = new JPanel();		
		panel2.setOpaque(false);
		panel2.setBackground(Color.BLUE);
		Dimension d1 = new Dimension(90, 100);		
		Dimension d2 = new Dimension(80, 60);
		Dimension d3 = new Dimension(90, 70);
		panel2.setLayout(new FlowLayout());
		
		b7 = new JButton("7");
		b7.setBackground(Color.RED);
		b7.setBorderPainted(true);			//this works...
		b7.setOpaque(true);					//comment this after listeners implemented...
		//b7.setOpaque(false);				//...and uncomment this
		b7.setFont(BUTTON_FONT);
		c.gridx = 0;
		c.gridy = 1;
		b7.setPreferredSize(d1);
		b7.addActionListener(this);
		panel2.add(b7, c);
		
		b8 = new JButton("8");
		b8.setBackground(Color.RED);
		b8.setOpaque(true);
		b8.setFont(BUTTON_FONT);
		c.gridx = 1;
		c.gridy = 1;
		b8.setPreferredSize(d1);
		b8.addActionListener(this);
		panel2.add(b8, c);
		
		b9 = new JButton("9");
		b9.setBackground(Color.RED);
		b9.setBorderPainted(true);			
		b9.setOpaque(true);	
		b9.setFont(BUTTON_FONT);
		c.gridx = 2;
		c.gridy = 1;
		b9.setPreferredSize(d1);
		b9.addActionListener(this);
		panel2.add(b9, c);
		
		plus = new JButton("+");
		plus.setOpaque(true);
		plus.setBackground(Color.BLUE);
		plus.setBorderPainted(true);			
		plus.setFont(BUTTON_FONT);
		c.gridx = 3;
		c.gridy = 1;
		plus.setPreferredSize(d2);
		plus.addActionListener(this);
		panel2.add(plus, c);
		
		b4 = new JButton("4");
		b4.setBackground(Color.RED);
		b4.setBorderPainted(true);			
		b4.setOpaque(true);	
		b4.setFont(BUTTON_FONT);
		c.gridx = 1;
		c.gridy = 2;
		b4.setPreferredSize(d1);
		b4.addActionListener(this);
		panel2.add(b4, c);
		
		b5 = new JButton("5");
		b5.setBackground(Color.RED);
		b5.setBorderPainted(true);			
		b5.setOpaque(true);	
		b5.setFont(BUTTON_FONT);
		c.gridx = 2;
		c.gridy = 2;
		b5.setPreferredSize(d1);
		b5.addActionListener(this);
		panel2.add(b5, c);
		
		b6 = new JButton("6");
		b6.setBackground(Color.RED);
		b6.setBorderPainted(true);			
		b6.setOpaque(true);	
		b6.setFont(BUTTON_FONT);
		c.gridx = 3;
		c.gridy = 2;
		b6.setPreferredSize(d1);
		b6.addActionListener(this);
		panel2.add(b6, c);
		
		minus = new JButton("-");
		minus.setBackground(Color.BLUE);
		minus.setBorderPainted(true);			
		minus.setOpaque(true);	
		minus.setFont(BUTTON_FONT);
		c.gridx = 4;
		c.gridy = 2;
		minus.setPreferredSize(d2);
		minus.addActionListener(this);
		panel2.add(minus, c);
		
		b1 = new JButton("1");
		b1.setBackground(Color.RED);
		b1.setBorderPainted(true);			
		b1.setOpaque(true);	
		b1.setFont(BUTTON_FONT);
		c.gridx = 1;
		c.gridy = 3;
		b1.setPreferredSize(d1);
		b1.addActionListener(this);
		panel2.add(b1, c);
		
		b2 = new JButton("2");
		b2.setBackground(Color.RED);
		b2.setBorderPainted(true);			
		b2.setOpaque(true);	
		b2.setFont(BUTTON_FONT);
		c.gridx = 2;
		c.gridy = 3;
		b2.setPreferredSize(d1);
		b2.addActionListener(this);
		panel2.add(b2, c);
		
		b3 = new JButton("3");
		b3.setBackground(Color.RED);
		b3.setBorderPainted(true);			
		b3.setOpaque(true);	
		b3.setFont(BUTTON_FONT);
		c.gridx = 3;
		c.gridy = 3;
		b3.setPreferredSize(d1);
		b3.addActionListener(this);
		panel2.add(b3, c);
		
		times = new JButton("x");
		times.setBackground(Color.BLUE);
		times.setBorderPainted(true);			
		times.setOpaque(true);	
		times.setFont(BUTTON_FONT);
		c.gridx = 4;
		c.gridy = 3;
		times.setPreferredSize(d2);
		times.addActionListener(this);
		panel2.add(times, c);
		
		b0 = new JButton("0");
		b0.setBackground(Color.RED);
		b0.setBorderPainted(true);			
		b0.setOpaque(true);	
		b0.setFont(BUTTON_FONT);
		c.gridx = 1;
		c.gridy = 4;
		b0.setPreferredSize(d3);
		b0.addActionListener(this);
		panel2.add(b0, c);
		
		delete = new JButton("del");
		delete.setBackground(Color.RED);
		delete.setBorderPainted(true);			
		delete.setOpaque(true);	
		delete.setFont(BUTTON_FONT);
		c.gridx = 2;
		c.gridy = 4;
		delete.setPreferredSize(d3);
		delete.addActionListener(this);
		panel2.add(delete, c);
		
		clear = new JButton("C");
		clear.setBackground(Color.RED);
		clear.setBorderPainted(true);			
		clear.setOpaque(true);	
		clear.setFont(BUTTON_FONT);
		c.gridx = 3;
		c.gridy = 4;
		clear.setPreferredSize(d3);
		clear.addActionListener(this);
		panel2.add(clear, c);
		
		divide = new JButton("/");
		divide.setBackground(Color.BLUE);
		divide.setBorderPainted(true);			
		divide.setOpaque(true);	
		divide.setFont(BUTTON_FONT);
		c.gridx = 4;
		c.gridy = 4;
		divide.setPreferredSize(d2);
		divide.addActionListener(this);
		panel2.add(divide, c);
		
		equals = new JButton("=");
		equals.setBackground(new Color(255, 255, 20));
		equals.setOpaque(true);
		equals.setFont(BUTTON_FONT);
		equals.setPreferredSize(new Dimension(375 / 2, 50));
		equals.setAlignmentY(Component.CENTER_ALIGNMENT);
		equals.addActionListener(this);
		panel2.add(equals);
		
		//panel to add all above panels
		JPanel panel4 = new JPanel();
		panel4.setOpaque(true);
		panel4.setBackground(Color.DARK_GRAY);
		panel4.setLayout(new BorderLayout());
		
		panel4.add(panel1, BorderLayout.NORTH);
		panel4.add(panel2);
		frame.add(panel4);
		
		//final line in class
		frame.setVisible(true);
	}
	
	//return true if parameter is an integer between 0 to 9 inclusive
	public boolean isNumber(String s) {
		return (s == "0" || s == "1" || s == "2" || s == "3" || s == "4" || s == "5"
				|| s == "6" || s == "7" || s == "8" || s == "9");
	}
	
	//returns true if parameter is an operation key, excluding equals 
	public boolean isOperation(String s) {
		return (s == "+" || s == "-" ||s == "x" || s == "/");
	}
	
	//return true if the number of values shown on text field if less then 12 inclusive
	public boolean belowTwelveVals(int c) {
		return c <= 12;
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		String keyVal = e.getActionCommand();
		int count = 0;
		
		if (belowTwelveVals(count)) {
			if (isNumber(keyVal)) {
				tField.setText(tField.getText() + keyVal);
				count++;
			} 
			if (isOperation(keyVal)) {
				
			}
		}
	}
}
