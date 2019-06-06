import java.awt.Container;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import static javax.swing.GroupLayout.Alignment.*;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

// Note, these demos are ment to be resized to see effect it
// has on control placement.

public class GroupExample2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("GroupLayoutExample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //This Works here!
		Container myPanel = frame.getContentPane();

		GroupLayout groupLayout = new GroupLayout(myPanel);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		myPanel.setLayout(groupLayout);

		JButton b1 = new JButton("Button One");
		JButton b2 = new JButton("Button Two");
		JButton b3 = new JButton("Button Three");

		groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(LEADING).addComponent(b1).addComponent(b3))
				.addGroup(groupLayout.createParallelGroup(TRAILING).addComponent(b2)));

		groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(b1).addComponent(b2))
				.addGroup(groupLayout.createParallelGroup(BASELINE).addComponent(b3)));

		frame.pack();
		frame.setVisible(true);
		frame.setLocation(1330, 225);
		new GroupExample();
		new MySpringDemo();
		new ScrollPaneDemo();
	}
}

class GroupExample {
	GroupExample() {
		this.main2(); // This is how i converted static main mthd to run here
	}

	public void main2() { // this used to be static main method
		JFrame frame = new JFrame("GroupLayoutExample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPanel = frame.getContentPane();
		GroupLayout groupLayout = new GroupLayout(contentPanel);

		contentPanel.setLayout(groupLayout);

		JLabel clickMe = new JLabel("Click Here");
		JButton button = new JButton("This Button");

		groupLayout.setHorizontalGroup(
				groupLayout.createSequentialGroup().addComponent(clickMe).addGap(10, 20, 100).addComponent(button));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				.addComponent(clickMe).addComponent(button));
		frame.pack();
		frame.setLocation(330, 225);
		frame.setVisible(true);
	}
}

class MySpringDemo {
	MySpringDemo() {
		main();
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("MySpringDemp");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = frame.getContentPane();
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);

		JLabel label = new JLabel("Label: ");
		JTextField textField = new JTextField("My Text Field", 15);
		contentPane.add(label);
		contentPane.add(textField);

		layout.putConstraint(SpringLayout.WEST, label, 6, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, label, 6, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, label);
		layout.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, contentPane, 6, SpringLayout.EAST, textField);
		layout.putConstraint(SpringLayout.SOUTH, contentPane, 6, SpringLayout.SOUTH, textField);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}

class ScrollPaneDemo extends JFrame {
	public ScrollPaneDemo() {
		super("ScrollPane Demo");
		ImageIcon img = new ImageIcon("Untitled.jpg");

		JScrollPane png = new JScrollPane(new JLabel(img));
		setLocation(333, 222);
		getContentPane().add(png);
		setSize(300, 250);
		setVisible(true);
	}

}