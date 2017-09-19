//Elizabeth Andrews
//Last updated: Mon Apr 20 11:34 pm

import java.awt.event.*;

public class Controller implements ActionListener {
	private Model model;

	public Controller(Model model) {
		this.model = model;
	}

	public boolean isLegalMove(int row, int col, boolean player) {
		if(isOnBoard(row, col) && model.isOccupied(row, col) == false) {
			if(isLegalMoveInDirection(row, col, -1, 0, player)) { //north
				return true;
			} else if(isLegalMoveInDirection(row, col, -1, 1, player)) { //northeast
				return true;
			} else if(isLegalMoveInDirection(row, col, -1, -1, player)) { //northwest
				return true;
			} else if(isLegalMoveInDirection(row, col, 0, 1, player)) { //east
				return true;
			} else if(isLegalMoveInDirection(row, col, 0, -1, player)) { //west
				return true;
			} else if(isLegalMoveInDirection(row, col, 1, 0, player)) { //south
				return true;
			} else if(isLegalMoveInDirection(row, col, 1, 1, player)) { //southeast
				return true;
			} else if(isLegalMoveInDirection(row, col, 1, -1, player)) { //southwest
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean isLegalMoveInDirection(int row, int col, int dRow, int dCol, boolean player) {
		int deathCount = 100;
		while(true) {
			if(isOnBoard(row + dRow, col + dCol) == false) { //if adjacent piece is not on board
				return false;
			}
			if(model.isOccupied(row + dRow, col + dCol) == false) { //if adjacent piece is unoccupied
				return false;
			}
			if(model.isOccupied(row + dRow, col + dCol) 
					&& model.isOccupiedBy(row + dRow, col + dCol, player)) { //if adjacent piece is occupied by player
				return false;
			}
			if(model.isOccupied(row + dRow, col + dCol)
					&& model.isOccupiedBy(row + dRow, col + dCol, !player)) { //if adjacent piece is occupied by opponent
				row = row + dRow;
				col = col + dCol;
				while(true) {
					deathCount = deathCount - 1;
					if (deathCount < 0) {
						throw new IllegalArgumentException("dying");
					}
					if(isOnBoard(row + dRow, col + dCol)
							&& model.isOccupied(row + dRow, col + dCol)
							&& model.isOccupiedBy(row + dRow, col + dCol, player)) {
						return true;
					} 
					if(isOnBoard(row + dRow, col + dCol) == false) {
						return false;
					}
					if(model.isOccupied(row + dRow, col + dCol) == false) {
						return false;
					}
					if(model.isOccupied(row + dRow, col + dCol)
							&& model.isOccupiedBy(row + dRow, col + dCol, !player)) {
						row = row + dRow;
						col = col + dCol;
					}	
				}
			}//end if
			deathCount = deathCount - 1;
			if (deathCount < 0) {
				System.out.println("dying");
				throw new IllegalArgumentException("dying");
			}
		}//end while true
	}//end isLegalMoveInDirection

	public boolean isOnBoard(int row, int col) {
		if(row < 0 || row > model.getSize() - 1 || col < 0 || col > model.getSize() -1) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		DButton buttonPressed = (DButton)ae.getSource();
		if (isLegalMove(buttonPressed.getRow(), buttonPressed.getCol(), model.getTurn()) == true) {
			flip(buttonPressed.getRow(), buttonPressed.getCol(), model.getTurn());
			model.takeTurn();
		} else { //if isLegalMove returns false
			if(hasOtherMoves(model.getTurn()) == false) {
				model.takeTurn();
			}
		}
		if(gameOver() == true) {
			gameIsOver();
		}
	}

	public void flip(int row, int col, boolean player) {
		flipInDirection(row, col, -1, 0, player); //north
		flipInDirection(row, col, -1, 1, player); //northeast
		flipInDirection(row, col, -1, -1, player); //northwest
		flipInDirection(row, col, 0, 1, player); //east
		flipInDirection(row, col, 0, -1, player); //west
		flipInDirection(row, col, 1, 0, player); //south
		flipInDirection(row, col, 1, 1, player); //southeast
		flipInDirection(row, col, 1, -1, player); //southwest

	}

	public void flipInDirection(int row, int col, int dRow, int dCol, boolean player) {
		if(isLegalMoveInDirection(row, col, dRow, dCol, player)) {
			model.occupy(row, col, player);
			while(model.isOccupied(row + dRow, col + dCol)
					&& model.isOccupiedBy(row + dRow, col + dCol, !player)) {
				model.occupy(row + dRow, col + dCol, player);
				row = row + dRow;
				col = col + dCol;
			}
		}
	}//end flipInDirection
	
	public boolean hasOtherMoves(boolean player) {
		for(int i = 0; i < model.getSize(); i++) {
			for(int j = 0; j < model.getSize(); j++) {	
				if(isLegalMove(i, j, player) == true) {
					return true;
					
				} //end if
			} //end for j
		} //end for i
		return false;
	}

	public boolean gameOver() {
		if(hasOtherMoves(false) == false && hasOtherMoves(true) == false) {
			return true;
		} else {
			return false;
		}
	}

	public void gameIsOver() {
		GameOverView gov = new GameOverView(model);	
	}
}
