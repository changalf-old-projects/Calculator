import java.awt.*;

import javax.swing.*;

public class CalculatorGUIDemo2 {
	
	private final Font BIG_FONT = new Font("Helvetica", Font.BOLD, 20);
	private JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
	private String[] operations = {"+", "-", "x", "/", "=", "del", "C"};
	
	public CalculatorGUIDemo2() {
		createCalculatorGUI2();
	}
	
	public void createCalculatorGUI2() {
		JFrame frame = new JFrame("Calculator 2");
		frame.setSize(400, 550);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Container pane = frame.getContentPane();
		//pane.setLayout(new GridBagLayout());
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(400, 70));
		text.setFont(BIG_FONT);
		text.setHorizontalAlignment(JTextField.RIGHT);
		panel1.add(text, BorderLayout.PAGE_START);
		frame.add(panel1);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		
		b7 = new JButton("7");
		b7.setPreferredSize(new Dimension(100, 120));
		c.gridx = 0;
		panel2.add(b7);
		
		frame.add(panel2);
		
		frame.revalidate();
		frame.repaint();
		frame.setVisible(true);
		
	}
}
