import java.awt.*;
import java.awt.event.*;
// AWT Example by Association

class First2r2 {
	Frame f = new Frame();

	//WindowAdapter wA = new WIndowsAdapter();	//WindowAdapter  is abstract class (cant be instantiated)
	First2r2() {
		Button b = new Button("click me");
		f.addWindowListener(new WindowAdapter() { // <-- so what is going on here if ^^^ is true... tought this was anonomous object or something
			public void windowClosing(WindowEvent e) { // Abstract class (in this case) only have to (re)define mthods of interest, interface would require ALL events defined
				f.dispose();
			}
		});
		b.setBounds(30, 50, 80, 30);
		f.add(b);
		f.setSize(300, 300);
		f.setLayout(null);
		f.setVisible(true);

		/* 		WindowAdapter wA = new WIndowsAdapter();
				wA.windowClosing(e) { f.dispose();} */
	}

	public void windowClosing(WindowEvent e) {
		f.dispose();
	}

	public static void main(String args[]) {
		//First2r2 f = new First2r2();  <- original... not necessary to create instance
		new First2r2();
	}
}

/*
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});



		
*/
/*
Conterast this code with the other (more natural) code
import java.awt.*;

class First extends Frame {
	First() {
		Button b = new Button("click me");
		b.setBounds(30, 100, 80, 30);// setting button position  
		add(b);//adding button into frame  
		setSize(300, 300);//frame size 300 width and 300 height  
		setLayout(null);//no layout manager  
		setVisible(true);//now frame will be visible, by default not visible  
	}

	public static void main(String args[]) {
		First f = new First();
	}
}

*/