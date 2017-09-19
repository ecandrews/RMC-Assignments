//Elizabeth Andrews
//Last updated: Mon Apr 20 11:34 pm

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.event.ChangeListener;

public class Model { 

	public static final boolean LIGHT = true;
	public static final boolean DARK = false;
	private boolean [][] isOccupied;
	private boolean [][] isOccupiedBy; 
	private boolean turn = DARK;
	private int size;
	private Collection <ChangeListener> listeners = new ArrayList<ChangeListener>();

	public Model(int size) {
		this.size = size;
		isOccupied = new boolean[size][size];
		isOccupiedBy = new boolean[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				isOccupied[i][j] = false;
			}//end col for loop
		}//end row for loop
		isOccupied[(size/2) - 1][(size/2) - 1] = true;
		occupy((size/2 - 1), (size/2 -1), LIGHT);
		isOccupied[(size/2) - 1][(size/2)] = true;
		occupy((size/2 - 1), (size/2), DARK);
		isOccupied[(size/2)][(size/2) - 1] = true;
		occupy((size/2), (size/2 - 1), DARK);
		isOccupied[(size/2)][(size/2)] = true;
		occupy((size/2), (size/2), LIGHT);
	}//end constructor

	public void reset() {
		for(int i = 0; i < isOccupied.length; i++) {
			for(int j = 0; j < isOccupied.length; j++) {
				isOccupied[i][j] = false;
			}//end col for loop
		}//end row for loop
		isOccupied[(isOccupied.length/2) - 1][(isOccupied.length/2) - 1] = true;
		occupy((isOccupied.length/2 - 1), (isOccupied.length/2 -1), LIGHT);
		isOccupied[(isOccupied.length/2) - 1][(isOccupied.length/2)] = true;
		occupy((isOccupied.length/2 - 1), (isOccupied.length/2), DARK);
		isOccupied[(isOccupied.length/2)][(isOccupied.length/2) - 1] = true;
		occupy((isOccupied.length/2), (isOccupied.length/2 - 1), DARK);
		isOccupied[(isOccupied.length/2)][(isOccupied.length/2)] = true;
		occupy((isOccupied.length/2), (isOccupied.length/2), LIGHT);
		notifyChangeListeners();
	}

	@Override
	public String toString() {
		String answer = "";
		for(int i = 0; i < this.getSize(); i++) {
			for(int j = 0; j < this.getSize(); j++) {
				if(isOccupied(i, j) == false) {
					answer = answer + ". ";
				} else if(isOccupiedBy(i, j, LIGHT)) {
					answer = answer + "L ";
				} else {
					answer = answer + "D ";
				}
			}
			answer = answer + "\r\n";
		}
		return answer;
	}

	public void addChangeListener(ChangeListener cl) {
		listeners.add(cl);
	}

	public void removeChangeListener(ChangeListener cl) {
		listeners.remove(cl);
	}

	public void notifyChangeListeners() {
		for(ChangeListener cl: listeners) {
			cl.stateChanged(null);
		}
	}

	public int getSize() {
		return size;
	}

	public int getCount(boolean player) {
		int count = 0;
		for(int i = 0; i < this.getSize(); i++) {
			for(int j = 0; j < this.getSize(); j++) {
				if(isOccupied[i][j] == true && isOccupiedBy[i][j] == player) {//if cell is occupied (true)
					count +=1;
				}
			}
		}
		return count;
	}

	public boolean getTurn() {
		return turn;
	}

	public void takeTurn() {
		turn = !turn;
		notifyChangeListeners();
	}

	public boolean isOccupied(int row, int col) {
		if(isOccupied[row][col]) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isOccupiedBy(int row, int col, boolean player) {
		if(isOccupiedBy[row][col] == player) {
			return true;
		} else {
			return false;
		}
	}

	public void occupy(int row, int col, boolean player) {
		isOccupied[row][col] = true;
		isOccupiedBy[row][col] = player;
	}


}
