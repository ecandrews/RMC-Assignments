import java.util.*;

public class Bug {
	private int x = 0;
	private int y = 0;
	public static final int GRIDSIZE = 20;


	//Bug constructor
	public Bug() {
		Random rng = new Random();
		this.x = rng.nextInt(GRIDSIZE);
		this.y = rng.nextInt(GRIDSIZE);
	}

	//method that returns x
	public int getX() {
		//returns the x value
		return this.x;
	}
	//method that returns y
	public int getY() {
		//returns the y value
		return this.y;
	}

	//method to move the Bug object
	public void move() {
		//create new random number generator
		Random rng = new Random();

		//if rng returns "true"
		if(rng.nextBoolean()) {
			//increase x by 1
			this.x = (this.x + 1) % GRIDSIZE;
		} else { //if rng returns "false"
			//decrease x by 1
			this.x = (this.x + GRIDSIZE - 1) % GRIDSIZE;
		} //end if-else for the x coordinate
		
		//if rng returns "true"
		if(rng.nextBoolean()) {
			//increase y by 1
			this.y = (this.y + 1) % GRIDSIZE;
		} else { //if rng returns "false"
			//decrease y by 1
			this.y = (this.y + GRIDSIZE - 1) % GRIDSIZE;
		} //end if-else for the y coordinate
	} //end method that moves the Bug object


}