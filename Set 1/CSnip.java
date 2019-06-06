import java.awt.*;
import java.awt.event.*;

class CSnip { // This is not a program, just ctrl examples
	Frame f = new Frame("Button Example");
	Label l1;

	CSnip() {
		// Label 
		l1 = new Label("First Label.");
		l1.setBounds(50, 100, 100, 30);
		f.add(l1);

		// Textfield
		TextField tf;
		tf = new TextField("Welcome to Javatpoint.");
		tf.setBounds(50, 100, 200, 30);
		f.add(tf);
		tf.setEditable(false);

		// Button
		Button b = new Button("Click Here");
		b.setBounds(50, 100, 60, 30);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf.setText("Welcome to Javatpoint.");
			}
		});
		f.add(b);

		// Textarea
		TextArea area = new TextArea("Welcome to javatpoint");
		area.setBounds(10, 30, 300, 300);
		f.add(area);

		//Checkbox (also see CheckboxExample.java)
		Checkbox checkbox1 = new Checkbox("C++");
		checkbox1.setBounds(100, 100, 50, 50);
		f.add(checkbox1);

		// Choice box
		Choice c = new Choice();
		c.setBounds(100, 100, 75, 75);
		c.add("Item 1");
		c.add("Item 2");
		c.add("Item 3");
		c.add("Item 4");
		c.add("Item 5");
		f.add(c);

		// List
		final List l2 = new List(4, true);
		l2.setBounds(100, 200, 70, 70);
		l2.add("Turbo C++");
		l2.add("Spring");
		l2.add("Hibernate");
		l2.add("CodeIgniter");
		f.add(l2);

		// Scrollbar
		Scrollbar s = new Scrollbar();
		s.setBounds(100, 100, 30, 500);
		f.add(s);

		// Menu (also see MenuExample.java)
		MenuBar mb = new MenuBar();
		Menu menu = new Menu("Menu");
		Menu submenu = new Menu("Sub Menu");
		MenuItem i1 = new MenuItem("Item 1");
		MenuItem i2 = new MenuItem("Item 2");
		MenuItem i3 = new MenuItem("Item 3");
		MenuItem i4 = new MenuItem("Item 4");
		MenuItem i5 = new MenuItem("Item 5");
		menu.add(i1);
		menu.add(i2);
		menu.add(i3);
		submenu.add(i4);
		submenu.add(i5);
		menu.add(submenu);
		mb.add(menu);
		f.setMenuBar(mb);

		// Popup Menu (see popummenuexample.java)...not sure the 'final' thing is needed
		final PopupMenu popupmenu = new PopupMenu("Edit");
		MenuItem cut = new MenuItem("Cut");
		cut.setActionCommand("Cut");
		MenuItem copy = new MenuItem("Copy");
		copy.setActionCommand("Copy");
		MenuItem paste = new MenuItem("Paste");
		paste.setActionCommand("Paste");
		popupmenu.add(cut);
		popupmenu.add(copy);
		popupmenu.add(paste);
		f.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				popupmenu.show(f, e.getX(), e.getY());
			}
		});
		f.add(popupmenu);

		// Panel (see PanelExample.java)
		Panel panel = new Panel();
		panel.setBounds(40, 80, 200, 200);
		panel.setBackground(Color.gray);
		Button b1 = new Button("Button 1");
		b1.setBounds(50, 100, 80, 30);
		b1.setBackground(Color.yellow);
		Button b2 = new Button("Button 2");
		b2.setBounds(100, 100, 80, 30);
		b2.setBackground(Color.green);
		panel.add(b1);
		panel.add(b2);
		f.add(panel);

		// Dialog type box (see DialogExample.java)
		Dialog d = new Dialog(f, "Dialog Example", true);
		d.setLayout(new FlowLayout());

		// Toolkit (see ToolkitExample.java)
		Toolkit t = Toolkit.getDefaultToolkit();
		System.out.println("Screen resolution = " + t.getScreenResolution());
		Dimension D = t.getScreenSize();
		System.out.println("Screen width = " + D.width);
		System.out.println("Screen height = " + D.height);

	}
}