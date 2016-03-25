import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.*;

/*
 * Similar to CalculatorGUIDemo2 class, but the buttons are smaller.  Overall, a different 
 * feel to the calculator.  The only different is how the buttons are initialized -- GUI2 
 * has each buttons initialized separately, with each button's size set, while GUI3's buttons
 * aren't set with an exact size.
 */

public class CalculatorGUIDemo3 {
	
	private final Font RESULT_FONT = new Font("Helvetica", Font.PLAIN, 50);
	private final Font BUTTON_FONT = new Font("Verdana", Font.BOLD, 30);
	private JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, plus, minus, times, divide, equals,
			delete, clear;
	private JButton[] buttons = {b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, plus, minus, times, divide, equals,
			delete, clear};
	private String[] buttonNames = {"7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "x", "0", "del", 
			"C", "/", "="};
	protected JTextField tField;
	
	public CalculatorGUIDemo3() {
		createCalculatorGUI();
	}
	
	public void createCalculatorGUI() {
		JFrame frame = new JFrame("Random Calculator");
		frame.setSize(375, 550);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridBagConstraints c = new GridBagConstraints();
		
		//panel for display window
		JPanel panel1 = new JPanel(new GridBagLayout());
		panel1.setOpaque(true);
		panel1.setBackground(Color.YELLOW);
		tField = new JTextField();
		tField.setBackground(Color.CYAN);
		tField.setHorizontalAlignment(JTextField.RIGHT);
		tField.setFont(RESULT_FONT);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 360;		//make the text field span most of frame width
		c.ipady = 75;		//make the text field tall
		panel1.add(tField, c);
		
		JPanel panel2 = new JPanel();		
		panel2.setOpaque(true);
		panel2.setBackground(Color.GREEN);
		Dimension d1 = new Dimension(90, 100);		
		Dimension d2 = new Dimension(80, 60);
		Dimension d3 = new Dimension(90, 70);
		panel2.setLayout(new FlowLayout());
		
		/*
		b7 = new JButton("7");
		b7.setBackground(Color.RED);
		b7.setBorderPainted(true);			//this works...
		b7.setOpaque(true);					//comment this after listeners implemented...
		//b7.setOpaque(false);				//...and uncomment this
		b7.setFont(BUTTON_FONT);
		c.gridx = 0;
		c.gridy = 1;
		b7.setPreferredSize(d1);
		panel2.add(b7, c);
		
		b8 = new JButton("8");
		b8.setBackground(Color.RED);
		b8.setOpaque(true);
		b8.setFont(BUTTON_FONT);
		c.gridx = 1;
		c.gridy = 1;
		b8.setPreferredSize(d1);
		panel2.add(b8, c);
		
		b9 = new JButton("9");
		b9.setFont(BUTTON_FONT);
		c.gridx = 2;
		c.gridy = 1;
		b9.setPreferredSize(d1);
		panel2.add(b9, c);
		
		plus = new JButton("+");
		plus.setFont(BUTTON_FONT);
		c.gridx = 3;
		c.gridy = 1;
		plus.setPreferredSize(d2);
		panel2.add(plus, c);
		
		b4 = new JButton("4");
		b4.setFont(BUTTON_FONT);
		c.gridx = 1;
		c.gridy = 2;
		b4.setPreferredSize(d1);
		panel2.add(b4, c);
		
		b5 = new JButton("5");
		b5.setFont(BUTTON_FONT);
		c.gridx = 2;
		c.gridy = 2;
		b5.setPreferredSize(d1);
		panel2.add(b5, c);
		
		b6 = new JButton("6");
		b6.setFont(BUTTON_FONT);
		c.gridx = 3;
		c.gridy = 2;
		b6.setPreferredSize(d1);
		panel2.add(b6, c);
		
		minus = new JButton("-");
		minus.setFont(BUTTON_FONT);
		c.gridx = 4;
		c.gridy = 2;
		minus.setPreferredSize(d2);
		panel2.add(minus, c);
		
		b1 = new JButton("1");
		b1.setFont(BUTTON_FONT);
		c.gridx = 1;
		c.gridy = 3;
		b1.setPreferredSize(d1);
		panel2.add(b1, c);
		
		b2 = new JButton("2");
		b2.setFont(BUTTON_FONT);
		c.gridx = 2;
		c.gridy = 3;
		b2.setPreferredSize(d1);
		panel2.add(b2, c);
		
		b3 = new JButton("3");
		b3.setFont(BUTTON_FONT);
		c.gridx = 3;
		c.gridy = 3;
		b3.setPreferredSize(d1);
		panel2.add(b3, c);
		
		times = new JButton("x");
		times.setFont(BUTTON_FONT);
		c.gridx = 4;
		c.gridy = 3;
		times.setPreferredSize(d2);
		panel2.add(times, c);
		
		b0 = new JButton("0");
		b0.setFont(BUTTON_FONT);
		c.gridx = 1;
		c.gridy = 4;
		b0.setPreferredSize(d3);
		panel2.add(b0, c);
		
		delete = new JButton("del");
		delete.setFont(BUTTON_FONT);
		c.gridx = 2;
		c.gridy = 4;
		delete.setPreferredSize(d3);
		panel2.add(delete, c);
		
		clear = new JButton("C");
		clear.setFont(BUTTON_FONT);
		c.gridx = 3;
		c.gridy = 4;
		clear.setPreferredSize(d3);
		panel2.add(clear, c);
		
		divide = new JButton("/");
		divide.setFont(BUTTON_FONT);
		c.gridx = 4;
		c.gridy = 4;
		divide.setPreferredSize(d2);
		panel2.add(divide, c);
		*/
		
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton(buttonNames[i]);
			panel2.add(buttons[i]);
		}
		
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
	
}
