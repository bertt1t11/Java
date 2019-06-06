import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class FileChooserExample extends JFrame implements ActionListener {
	JMenuBar mb;
	JMenu file;
	JMenuItem open;
	JTextArea ta;

	FileChooserExample() {
		open = new JMenuItem("Open File");
		open.addActionListener(this);
		file = new JMenu("File");
		file.add(open);
		mb = new JMenuBar();
		mb.setBounds(0, 0, 800, 20);
		mb.add(file);
		ta = new JTextArea(800, 800);
		ta.setBounds(0, 20, 800, 800);
		add(mb);
		add(ta);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == open) {
			JFileChooser fc = new JFileChooser();
			int i = fc.showOpenDialog(this);
			if (i == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();
				String filepath = f.getPath();
				try {
					BufferedReader br = new BufferedReader(new FileReader(filepath));
					String s1 = "", s2 = "";
					while ((s1 = br.readLine()) != null) {
						s2 += s1 + "\n";
					}
					ta.setText(s2);
					br.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		FileChooserExample om = new FileChooserExample();
		om.setSize(500, 500);
		om.setLayout(null);
		om.setVisible(true);
		om.setDefaultCloseOperation(EXIT_ON_CLOSE);
		new JToggleButtonExample();

	}
}

class JToggleButtonExample extends JFrame implements ItemListener {

	private JToggleButton button;

	JToggleButtonExample() {
		setTitle("JToggleButton with ItemListener Example");
		setLayout(new FlowLayout());
		setLocation(300, 300);
		setJToggleButton();
		setAction();
		setSize(200, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setJToggleButton() {
		button = new JToggleButton("ON");
		add(button);
	}

	private void setAction() {
		button.addItemListener(this);
	}

	public void itemStateChanged(ItemEvent eve) {
		if (button.isSelected())
			button.setText("OFF");
		else
			button.setText("ON");
	}
}
