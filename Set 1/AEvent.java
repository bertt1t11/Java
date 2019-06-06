import java.awt.*;
import java.awt.event.*;

//NOTICE:  ALREADY IN OneNote - GUI
class AEvent extends Frame implements ActionListener, WindowListener {
	TextField tf;

	AEvent() {

		//create components  
		tf = new TextField();
		tf.setBounds(60, 50, 170, 20);
		Button b = new Button("click me");
		b.setBounds(100, 120, 80, 30);

		//register listener  
		b.addActionListener(this);//passing current instance  
		addWindowListener(this);
		//add components and set size, layout and visibility  
		add(b);
		add(tf);
		setSize(300, 300);
		setLayout(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		tf.setText("Welcome");
	}

	public static void main(String args[]) {
		new AEvent();
	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		dispose();
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}
}