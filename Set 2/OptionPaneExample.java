import javax.swing.*;
import java.awt.event.*;

public class OptionPaneExample extends WindowAdapter {
	JFrame f;
	JFrame f1;

	OptionPaneExample() {
		f = new JFrame();
		JOptionPane.showMessageDialog(f, "Hello, Welcome to Javatpoint.");
		JOptionPane.showMessageDialog(f, "Successfully Updated.", "Alert", JOptionPane.WARNING_MESSAGE);
		String name = JOptionPane.showInputDialog(f, "Enter Name");
		System.out.println("You entered: " + name);
		f1 = new JFrame();
		f1.addWindowListener(this);
		f1.setSize(300, 300);
		f1.setLayout(null);
		f1.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f1.setVisible(true);

	}

	public void windowClosing(WindowEvent e) {
		int a = JOptionPane.showConfirmDialog(f1, "Are you sure?");
		if (a == JOptionPane.YES_OPTION) {
			f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

	public static void main(String[] args) {
		new OptionPaneExample();
	}
}