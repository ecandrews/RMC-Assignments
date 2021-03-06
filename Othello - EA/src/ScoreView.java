import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class ScoreView extends JFrame implements ChangeListener {
	private Model model;
	private JPanel displayScores = new JPanel();
	private JLabel lightScore = new JLabel(" ");
	private JLabel darkScore = new JLabel(" ");
	private JPanel displayTurn = new JPanel();
	private JLabel turnLabel = new JLabel(" ");

	public ScoreView(Model model) {
		super("Score");
		this.model = model;
		model.addChangeListener(this);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		displayScores.setLayout(new GridLayout(1, 2));
		JPanel lightPanel = new JPanel();
		JPanel darkPanel = new JPanel();
		displayScores.add(lightPanel);
		displayScores.add(darkPanel);
		lightScore.setText("LIGHT: " + model.getCount(true));
		lightPanel.add(lightScore);
		darkScore.setText("DARK: " + model.getCount(false));
		darkPanel.add(darkScore);
		displayScores.add(lightPanel);
		displayScores.add(darkPanel);
		contentPane.add(displayScores, BorderLayout.CENTER);

		String turn;
		if(model.getTurn()) {
			turn = "Light";
		} else {
			turn = "Dark";
		}
		turnLabel.setText(turn + "'s turn!");
		displayTurn.add(turnLabel);
		contentPane.add(displayTurn, BorderLayout.SOUTH);
		this.setLocation(270, 300);
		this.setSize(200, 75);
		this.setVisible(true);
	}

	public void stateChanged(ChangeEvent ce) {
		lightScore.setText("LIGHT: " + model.getCount(true));
		darkScore.setText("DARK: " + model.getCount(false));

		String turn;
		if(model.getTurn()) {
			turn = "Light";
		} else {
			turn = "Dark";
		}
		turnLabel.setText(turn + "'s turn!");

	}

}
