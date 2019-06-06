import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.WindowConstants;

public class Border {
	JFrame f;
	public static final int EXIT_ON_CLOSE = 3;

	Border() {
		f = new JFrame();

		JButton b1 = new JButton("NORTH");
		;
		JButton b2 = new JButton("SOUTH");

		JButton b3 = new JButton("EAST");

		JButton b4 = new JButton("WEST");

		JButton b5 = new JButton("CENTER");

		f.add(b1, BorderLayout.NORTH);
		f.add(b2, BorderLayout.SOUTH);
		f.add(b3, BorderLayout.EAST);
		f.add(b4, BorderLayout.WEST);
		f.add(b5, BorderLayout.CENTER);
		f.setLocation(300, 400);
		f.setSize(300, 300);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Border();
		new MyGridLayout();
		new MyFlowLayout();
		BoxLayoutExample1 b = new BoxLayoutExample1();
		new BoxLayoutExample2();
		CardLayoutExample cl = new CardLayoutExample();
		cl.setSize(400, 400);
		cl.setVisible(true);
		cl.setDefaultCloseOperation(EXIT_ON_CLOSE); // THIS makes windows close SMH!!

	}
}

class MyGridLayout {
	JFrame f;

	MyGridLayout() {
		f = new JFrame();
		f.setLocation(100, 200);
		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");

		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);
		f.add(b8);
		f.add(b9);

		f.setLayout(new GridLayout(3, 3));
		//setting grid layout of 3 rows and 3 columns  

		f.setSize(300, 300);
		f.setVisible(true);
	}
}

class MyFlowLayout {
	JFrame f;

	MyFlowLayout() {
		f = new JFrame();

		JButton b1 = new JButton("1");
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");

		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);

		f.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//setting flow layout of right alignment  

		f.setLocation(50, 50);
		f.setSize(300, 300);
		f.setVisible(true);
	}
}

class BoxLayoutExample1 extends Frame {
	Button buttons[];

	public BoxLayoutExample1() {
		buttons = new Button[5];

		for (int i = 0; i < 5; i++) {
			buttons[i] = new Button("Button " + (i + 1));
			add(buttons[i]);
		}

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setLocation(150, 150);
		setSize(400, 400);
		setVisible(true);
	}

}

class BoxLayoutExample2 extends Frame {
	Button buttons[];

	public BoxLayoutExample2() {
		buttons = new Button[5];

		for (int i = 0; i < 5; i++) {
			buttons[i] = new Button("Button " + (i + 1));
			add(buttons[i]);
		}
		setLocation(350, 50);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setSize(400, 400);
		setVisible(true);
	}

}

class CardLayoutExample extends JFrame implements ActionListener {
	CardLayout card;
	JButton b1, b2, b3;
	Container c;

	CardLayoutExample() {

		c = getContentPane();
		card = new CardLayout(40, 30);
		//create CardLayout object with 40 hor space and 30 ver space  
		c.setLayout(card);

		b1 = new JButton("Apple");
		b2 = new JButton("Boy");
		b3 = new JButton("Cat");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		c.add("a", b1);
		c.add("b", b2);
		c.add("c", b3);

	}

	public void actionPerformed(ActionEvent e) {
		card.next(c);
	}

}
