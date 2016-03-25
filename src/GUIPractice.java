import javax.swing.*;
import java.awt.*;

public class GUIPractice {
	
	public GUIPractice() {
		createPracticeGUI();
	}
	
	public void createPracticeGUI() {
		
		//don't forget to put modifiers (public, private, etc...)
		JFrame frame = new JFrame("Frame");
		frame.setSize(750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new GridBagLayout());
		
		//it is best to create a new GridBadConstraints instance for each component
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(10, 10, 10, 10);
		
		JLabel label1 = new JLabel("1");
		c.gridx = 0;
		c.gridy = 1;
		panel.add(label1, c);
		
		JLabel label2 = new JLabel("2");
		c.gridx = 0;
		c.gridy = 2;
		panel.add(label2, c);
		
		JLabel label3 = new JLabel("3");
		c.gridx = 0;
		c.gridy = 3;
		panel.add(label3, c);
		
		JLabel label4 = new JLabel("4");
		c.gridx = 0;
		c.gridy = 4;
		panel.add(label4, c);
		
		JLabel label5 = new JLabel("5");
		c.gridx = 0;
		c.gridy = 5;
		panel.add(label5, c);
		
		JButton button1 = new JButton("Button1");
		c.gridx = 1;
		c.gridy = 1;
		panel.add(button1, c);
		
		JButton button2 = new JButton("Button2");
		c.gridx = 2;
		c.gridy = 1;
		panel.add(button2, c);
		
		JButton button3 = new JButton("Button3");
		c.gridx = 3;
		c.gridy = 1;
		panel.add(button3, c);
		
		JButton button4 = new JButton("Button4");
		c.gridx = 4;
		c.gridy = 1;
		panel.add(button4, c);
		
		JButton button5 = new JButton("Button5");
		c.gridx = 5;
		c.gridy = 1;
		c.gridheight = 3;
		c.gridwidth = 3;
		panel.add(button5, c);
		
		frame.add(panel, BorderLayout.NORTH);
		
		//pack() ensures that the frame size is no larger than width and height of all components
		//use either pack() or frame.setSize(x, y) or frame.setBounds(x, y)
		//frame.pack();
		
		//this must always come last as it paints everything that's drawn beforehand
		frame.setVisible(true);
		
	}
	
}
