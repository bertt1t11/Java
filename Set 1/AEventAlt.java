import java.awt.*;
import java.awt.event.*;

//NOTICE:  ALREADY IN OneNote - GUI.  Did this as alternative to extending Frame class
class AEventAlt implements ActionListener, WindowListener {
	TextField tf = new TextField(); // This could have been instantiated inside constructor with it decleared here as pointer like originally it was (and still is in other version)
	Frame f = new Frame();

	AEventAlt() {

		//create components  
		tf.setBounds(60, 50, 170, 20);
		Button b = new Button("click me");
		b.setBounds(100, 120, 80, 30);

		//register listener  
		b.addActionListener(this);//passing current instance  
		f.addWindowListener(this);
		//add components and set size, layout and visibility  
		f.add(b); // This adds the button obj we created to the Frame obj
		f.add(tf);
		f.setSize(300, 300);
		f.setLayout(null);
		f.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		tf.setText("Welcome");
		f.setTitle(e.getActionCommand());
	}

	public static void main(String args[]) {
		new AEventAlt();
	}

	@Override // Again, these (auto added by vscode) arent necessary
	public void windowOpened(WindowEvent e) {

	}

	//@Override		// The rest of these were events were auto-added by vscode to fix use of interfacce
	public void windowClosing(WindowEvent e) {
		f.dispose();
	}

	//@Override
	public void windowClosed(WindowEvent e) {

	}

	//@Override
	public void windowIconified(WindowEvent e) {

	}

	//@Override
	public void windowDeiconified(WindowEvent e) {

	}

	//@Override
	public void windowActivated(WindowEvent e) {

	}

	//@Override
	public void windowDeactivated(WindowEvent e) {

	}
}