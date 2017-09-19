import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class DoorCode extends JFrame implements ActionListener {
	private final String CORRECTCODE = "3147";
	private JButton [] buttons = new JButton[10];
	private String codeEntered = "";

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object s = ae.getSource();
		int selectedButton = -1;
		for(int i = 0; i < 10; i++) {
			if(s == buttons[i]) {
				selectedButton = i;
				codeEntered = codeEntered + ("" + i);
			}//end if statement
		}//end for loop
		System.out.println(codeEntered); //This is just so I can make sure each number is being added to the codeEntered String

		if(codeEntered.length() == 4) {
			if(codeEntered.equals(CORRECTCODE)) {
				//I wish that I could change the color of the button, but I don't know how and none of this
				//seems to work the way I want it too...
				for(JButton jb: buttons) {
					jb.setBackground(Color.green);
					jb.setOpaque(true);
					jb.setBorderPainted(false);
				}
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ie) {
					ie.printStackTrace();
				}
				System.exit(0);
			} else {
				codeEntered = "";
				try {
					Thread.sleep(1000);
				} catch(InterruptedException ie) {
					ie.printStackTrace();
				}
			}
		}
	}

	public DoorCode() {
		super("Demo");
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(2, 5));
		for (int i = 1; i < 10; i++) {
			JButton jb = new JButton("" + i%10);
			buttons[i%10] = jb;
			contentPane.add(jb);
			jb.addActionListener(this);
		}
		JButton jb = new JButton("" + 0);
		buttons[0] = jb;
		contentPane.add(jb);
		jb.addActionListener(this);

		this.pack();
		this.setVisible(true);
	}

	public static void main (String [] args) {
		DoorCode dc = new DoorCode();
	}

}
