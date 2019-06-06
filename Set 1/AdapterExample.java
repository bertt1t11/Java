import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;

public class AdapterExample extends WindowAdapter {
	Frame f;

	AdapterExample() {
		f = new Frame("Button Example");
		Label l1, l2;
		l1 = new Label("First Label.");
		l1.setBounds(50, 100, 300, 30);
		l2 = new Label("Second Label.");
		l2.setBounds(50, 150, 300, 30);
		f.add(l1);
		f.add(l2);
		final TextField tf = new TextField("default");
		tf.setBounds(50, 50, 150, 20);
		f.addWindowListener(this);
		Button b = new Button("Click Here");
		b.setBounds(50, 200, 80, 30);
		Button b2 = new Button("Show");
		b2.setBounds(150, 200, 50, 20);
		final Choice c = new Choice();
		c.setBounds(200, 200, 75, 75);
		c.add("C");
		c.add("C++");
		c.add("Java");
		c.add("PHP");
		c.add("Android");
		final Label label = new Label();
		label.setAlignment(Label.CENTER);
		label.setBounds(50, 350, 400, 100);
		// label.setSize(400, 100);

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "Programming language Selected: " + c.getItem(c.getSelectedIndex());
				label.setText(data);

				try {
					String tmpStr1 = tf.getText();
					tf.setText("Welcome To Java");
					l1.setText("You Typed: " + tmpStr1);
					String host = "www.youtube.com"; // 192.168.1.44
					String tmpStr2 = InetAddress.getByName(host).getHostAddress();
					// tmpStr2 = "?? internet address?";
					l2.setText("IP of " + host + " is: " + tmpStr2);
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}

		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data2 = "Programming Language Selected: " + c.getItem(c.getSelectedIndex());
				label.setText(data2);
			}
		});

		f.add(b);
		f.add(tf);
		f.add(c);
		f.add(label);
		f.add(b2);
		f.setSize(400, 500);
		f.setLayout(null);
		f.setVisible(true);
	}

	public void windowClosing(WindowEvent e) {
		f.dispose();
	}

	public static void main(String[] args) {
		new AdapterExample();
	}
}