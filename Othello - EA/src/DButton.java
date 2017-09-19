import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class DButton extends JButton implements Dimensioned {
	private int row;
	private int col;

	public DButton(int row, int col) {
		this.row = row;
		this.col = col;
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));  
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.col;
	}

}
