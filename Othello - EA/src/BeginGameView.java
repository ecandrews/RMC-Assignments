import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BeginGameView extends JFrame implements ActionListener {
	private OthelloApplication oa;
	private int numChosen = 4;
	private JButton button4 = new JButton("4 x 4");
	private JButton button6 = new JButton("6 x 6");
	private JButton button8 = new JButton("8 x 8");
	
	public BeginGameView(OthelloApplication oa) {
		super("Othello");
		this.oa = oa;
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		JPanel messageDisplay = new JPanel();
		JLabel message = new JLabel("Choose your board size: ");
		messageDisplay.add(message);
		contentPane.add(messageDisplay, BorderLayout.NORTH);
		JPanel panel4 = new JPanel();
		panel4.add(button4);
		button4.addActionListener(this);
		JPanel panel6 = new JPanel();
		panel6.add(button6);
		button6.addActionListener(this);
		JPanel panel8 = new JPanel();
		panel8.add(button8);
		button8.addActionListener(this);
		contentPane.add(panel4, BorderLayout.WEST);
		contentPane.add(panel6, BorderLayout.CENTER);
		contentPane.add(panel8, BorderLayout.EAST);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(250, 100);
		this.setVisible(true);

	}
	
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o == button4) {
			//System.out.println("4");
			oa.createNewGame(4);
		} else if(o == button6) {
			//System.out.println("6");
			oa.createNewGame(6);
		} else if(o == button8) {
			//System.out.println("8");
			oa.createNewGame(8);
		}
		this.dispose();
	}
	
	public int getSizeChosen() {
		return numChosen;
	}

}
