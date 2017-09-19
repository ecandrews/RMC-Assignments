import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverView extends JFrame implements ActionListener{
	private Model model;
	private JPanel winnerDisplay = new JPanel();
	private JLabel winnerLabel = new JLabel(" ");
	private JPanel optionsDisplay = new JPanel();
	private JButton playAgain = new JButton("Play Again");
	private JButton quitGame = new JButton("Quit");
	
	public GameOverView(Model model) {
		super("Game Over");
		this.model = model;
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		if(model.getCount(true) > model.getCount(false)) {
			winnerLabel.setText("Light wins!");
		} else if(model.getCount(false) > model.getCount(true)) {
			winnerLabel.setText("Dark wins!");
		} else {
			winnerLabel.setText("It's a tie!");
		}
		winnerDisplay.add(winnerLabel);
		contentPane.add(winnerDisplay, BorderLayout.NORTH);
		
		optionsDisplay.setLayout(new GridLayout(1, 2));
		playAgain.addActionListener(this);
		quitGame.addActionListener(this);
		optionsDisplay.add(playAgain);
		optionsDisplay.add(quitGame);
		contentPane.add(optionsDisplay, BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(200, 100);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o == playAgain) {
			model.reset();
			this.dispose();
		} else if(o == quitGame){
			System.exit(0);
		}
		
	}

}
