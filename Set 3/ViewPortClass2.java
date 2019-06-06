import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class ViewPortClass2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Tabbed Pane Sample");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("Label");
		label.setPreferredSize(new Dimension(1000, 1000));
		JScrollPane jScrollPane = new JScrollPane(label);

		JButton jButton1 = new JButton();
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane.setViewportBorder(new LineBorder(Color.RED));
		jScrollPane.getViewport().add(jButton1, null);

		frame.setLocation(500, 500);
		frame.add(jScrollPane, BorderLayout.CENTER);
		frame.setSize(400, 150);
		frame.setVisible(true);

		MyJComponent com = new MyJComponent();
		// create a basic JFrame  
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame2 = new JFrame("JComponent Example");
		frame2.setSize(300, 200);
		frame2.setLocation(800, 1500);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// add the JComponent to main frame  
		frame2.add(com);
		frame2.setVisible(true);

		LayeredPaneExample panel = new LayeredPaneExample();
		panel.setVisible(true);

		new JDPaneDemo();

	}
}

class MyJComponent extends JComponent {
	public void paint(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(30, 30, 100, 100);
	}
}

class LayeredPaneExample extends JFrame {
	public LayeredPaneExample() {
		super("LayeredPane Example");
		setSize(200, 200);
		JLayeredPane pane = getLayeredPane();
		//creating buttons  
		JButton top = new JButton();
		top.setBackground(Color.white);
		top.setBounds(20, 20, 50, 50);
		JButton middle = new JButton();
		middle.setBackground(Color.red);
		middle.setBounds(40, 40, 50, 50);
		JButton bottom = new JButton();
		bottom.setBackground(Color.cyan);
		bottom.setBounds(60, 60, 50, 50);
		//adding buttons on pane  
		pane.add(bottom, new Integer(1));
		pane.add(middle, new Integer(2));
		pane.add(top, new Integer(3));
	}
}

class JDPaneDemo extends JFrame {
	public JDPaneDemo() {
		CustomDesktopPane desktopPane = new CustomDesktopPane();
		Container contentPane = getContentPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.display(desktopPane);

		setTitle("JDesktopPane Example");
		setLocation(400, 300);
		setSize(300, 350);
		setVisible(true);
	}
}

class CustomDesktopPane extends JDesktopPane {
	int numFrames = 3, x = 30, y = 30;

	public void display(CustomDesktopPane dp) {
		for (int i = 0; i < numFrames; ++i) {
			JInternalFrame jframe = new JInternalFrame("Internal Frame " + i, true, true, true, true);

			jframe.setBounds(x, y, 250, 85);
			Container c1 = jframe.getContentPane();
			c1.add(new JLabel("I love my country"));
			dp.add(jframe);
			jframe.setVisible(true);
			y += 85;
		}
	}
}
