import java.awt.*;
import java.awt.event.*;

public class ToolkitExample {
	public static void main(String[] args) {
		Toolkit t = Toolkit.getDefaultToolkit();
		System.out.println("Screen resolution = " + t.getScreenResolution());
		Dimension d = t.getScreenSize();
		System.out.println("Screen width = " + d.width);
		System.out.println("Screen height = " + d.height);

		Frame f = new Frame("ToolkitExample");
		Button b = new Button("beep");
		b.setBounds(50, 100, 60, 30);
		f.add(b);
		f.setSize(300, 300);
		f.setLayout(null);
		f.setVisible(true);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Toolkit.getDefaultToolkit().beep();
			}
		});
	}
}