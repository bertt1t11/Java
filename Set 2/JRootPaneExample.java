import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRootPane;
import javax.swing.*;
import java.awt.*;

public class JRootPaneExample {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JRootPane root = f.getRootPane();

		// Create a menu bar  
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("File");
		bar.add(menu);
		menu.add("Open");
		menu.add("Close");
		root.setJMenuBar(bar);

		// Add a button to the content pane  
		root.getContentPane().add(new JButton("Press Me"));

		// Display the UI  
		f.pack();
		Image icon = Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\frig\\OneDrive\\Documents\\A Programming\\Java\\VSCode Java\\icon.png");
		f.setIconImage(icon);
		f.setLocation(100, 100);
		f.setVisible(true);

		JFrame fX = new JFrame("Password Field Example");
		//Creating PasswordField and label  
		JPasswordField value = new JPasswordField();
		value.setBounds(100, 100, 100, 30);
		value.setToolTipText("Enter your Password");
		JLabel l1 = new JLabel("Password:");
		l1.setBounds(20, 100, 80, 30);
		//Adding components to frame  
		fX.add(value);
		fX.add(l1);
		fX.setSize(300, 300);
		fX.setLayout(null);
		fX.setLocation(400, 100);
		fX.setVisible(true);

	}
}