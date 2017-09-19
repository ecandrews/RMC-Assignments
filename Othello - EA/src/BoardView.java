//Elizabeth Andrews
//Last updated: Mon Apr 20 11:34 pm

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.*;
import javax.swing.event.*;

public class BoardView extends JFrame implements ChangeListener {
	private Model model;
	private DButton [][] buttons;

	public BoardView(Model model, Controller c) {
		super("Othello");
		this.model = model;
		buttons = new DButton[model.getSize()][model.getSize()];
		model.addChangeListener(this);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new GridLayout(model.getSize(), model.getSize()));

		for(int i = 0; i < model.getSize(); i++) {
			for(int j = 0; j < model.getSize(); j++) {
				DButton db = new DButton(i, j);
				db.addChangeListener(this);
				db.addActionListener(c);
				buttons[i][j] = db;
				//System.out.println("button" + i + ", " + j);
				contentPane.add(db);
				if(model.isOccupied(i, j)) {
					if(model.isOccupiedBy(i, j, true)) {
						//if occupied by white
						db.setOpaque(true);
						db.setBackground(Color.WHITE);
					} else {
						//if occupied by black
						db.setOpaque(true);
						db.setBackground(Color.DARK_GRAY);
					}
				} else {
					db.setOpaque(true);
					db.setBackground(new Color(130, 93, 85));
				}

			}//end row for loop
		}//end col for loop
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void updateView() {
		for(int i = 0; i < model.getSize(); i++) {
			for(int j = 0; j < model.getSize(); j++) {
				if(model.isOccupied(i, j)) {
					if(model.isOccupiedBy(i, j, true)) {
						buttons[i][j].setOpaque(true);
						buttons[i][j].setBackground(Color.WHITE);
					} else {
						buttons[i][j].setOpaque(true);
						buttons[i][j].setBackground(Color.DARK_GRAY);
					}
				} else {
					buttons[i][j].setOpaque(true);
					buttons[i][j].setBackground(new Color(130, 93, 85));
				}
			}

		}
	}

	public void stateChanged(ChangeEvent ce) {
		this.updateView();
	}

}