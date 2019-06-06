import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.*;
import java.awt.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class JavaCheckBoxMenuItem {
	public static void main(final String args[]) {
		JFrame frame = new JFrame("Jmenu Example");
		frame.setLocation(100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		// File Menu, F - Mnemonic  
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);
		// File->New, N - Mnemonic  
		JMenuItem menuItem1 = new JMenuItem("Open", KeyEvent.VK_N);
		fileMenu.add(menuItem1);

		JCheckBoxMenuItem caseMenuItem = new JCheckBoxMenuItem("Option_1");
		caseMenuItem.setMnemonic(KeyEvent.VK_C);
		fileMenu.add(caseMenuItem);

		ActionListener aListener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				AbstractButton aButton = (AbstractButton) event.getSource();
				boolean selected = aButton.getModel().isSelected();
				String newLabel;
				Icon newIcon;
				if (selected) {
					newLabel = "Value-1";
				} else {
					newLabel = "Value-2";
				}
				aButton.setText(newLabel);
			}
		};
		JFrame f = new JFrame("Separator Example");
		f.setLocation(300, 300);
		f.setLayout(new GridLayout(0, 1));
		JLabel l1 = new JLabel("Above Separator");
		f.add(l1);
		JSeparator sep = new JSeparator();
		f.add(sep);
		JLabel l2 = new JLabel("Below Separator");
		f.add(l2);
		f.setSize(400, 100);
		f.setVisible(true);

		new SeparatorExample();
		new TreeExample();
		new ColorChooserExample();
		new TabbedPaneExample();
		SliderExample frame2 = new SliderExample();
		frame2.pack();
		frame2.setVisible(true);

		caseMenuItem.addActionListener(aListener);
		frame.setJMenuBar(menuBar);
		frame.setSize(350, 250);
		frame.setVisible(true);

	}
}

class SeparatorExample {
	JMenu menu, submenu;
	JMenuItem i1, i2, i3, i4, i5;

	SeparatorExample() {
		JFrame f = new JFrame("Separator Example");
		f.setLocation(600, 200);
		JMenuBar mb = new JMenuBar();
		menu = new JMenu("Menu");
		i1 = new JMenuItem("Item 1");
		i2 = new JMenuItem("Item 2");
		menu.add(i1);
		menu.addSeparator();
		menu.add(i2);
		mb.add(menu);
		f.setJMenuBar(mb);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
	}
}

class TreeExample {
	JFrame f;

	TreeExample() {
		f = new JFrame();
		f.setLocation(500, 500);
		DefaultMutableTreeNode style = new DefaultMutableTreeNode("Style");
		DefaultMutableTreeNode color = new DefaultMutableTreeNode("color");
		DefaultMutableTreeNode font = new DefaultMutableTreeNode("font");
		style.add(color);
		style.add(font);
		DefaultMutableTreeNode red = new DefaultMutableTreeNode("red");
		DefaultMutableTreeNode blue = new DefaultMutableTreeNode("blue");
		DefaultMutableTreeNode black = new DefaultMutableTreeNode("black");
		DefaultMutableTreeNode green = new DefaultMutableTreeNode("green");
		color.add(red);
		color.add(blue);
		color.add(black);
		color.add(green);
		JTree jt = new JTree(style);
		f.add(jt);
		f.setSize(200, 200);
		f.setVisible(true);
	}
}

class ColorChooserExample extends JFrame implements ActionListener {
	JFrame f;
	JButton b;
	JTextArea ta;

	ColorChooserExample() {
		f = new JFrame("Color Chooser Example.");
		f.setLocation(50, 50);
		b = new JButton("Pad Color");
		b.setBounds(200, 250, 100, 30);
		ta = new JTextArea();
		ta.setBounds(10, 10, 300, 200);
		b.addActionListener(this);
		f.add(b);
		f.add(ta);
		f.setLayout(null);
		f.setSize(400, 400);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Color c = JColorChooser.showDialog(this, "Choose", Color.CYAN);
		ta.setBackground(c);
	}
}

class TabbedPaneExample {
	JFrame f;

	TabbedPaneExample() {
		f = new JFrame();
		JTextArea ta = new JTextArea(200, 200);
		JPanel p1 = new JPanel();
		p1.add(ta);
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JTabbedPane tp = new JTabbedPane();
		tp.setBounds(50, 50, 200, 200);
		tp.add("main", p1);
		tp.add("visit", p2);
		tp.add("help", p3);
		f.add(tp);
		f.setSize(400, 400);
		f.setLayout(null);
		f.setVisible(true);
	}
}

class SliderExample extends JFrame {
	public SliderExample() {
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
		slider.setMinorTickSpacing(2);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);

		JPanel panel = new JPanel();
		panel.add(slider);
		add(panel);
	}
}