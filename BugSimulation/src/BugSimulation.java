import java.util.*;

public class BugSimulation {
	public static void main (String [] args) {
			
		//variable to count number of collisions
		int numberOfCollisions = 0;
		//number of times to run the simulation
		int numberOfTimesBugsAreMoved = 10;

		//create a list of bugs
		List <Bug> bugs = new ArrayList<Bug>();
		//put 25 bugs into the List
		for(int i = 0; i < 20; i++) {
			Bug bug = new Bug();
			bugs.add(bug);
		} //end for-loop to put bugs in the bugs list


		//move all bugs a certain number of times
		for(int step = 0; step < numberOfTimesBugsAreMoved; step++) {
			for(Bug bug: bugs) {
				bug.move();
				showSimulation(bugs, bug.GRIDSIZE);
			}

			//go through list of bugs and compare them
			for (int i = 0; i < bugs.size(); i++) {
				//sets bug1
				Bug bug1 = bugs.get(i);

				for (int j = i + 1; j < bugs.size(); j++) {
					//sets bug2
					Bug bug2 = bugs.get(j);
					
					//if statement to compare bug1 and bug2
					if (bug1.getX() == bug2.getX() && bug1.getY() == bug2.getY()) {
						numberOfCollisions = numberOfCollisions + 1;
					} //end if statement to compare bug1 and bug2

				} //end bug2 for loop

			} //end bug1 for loop

			// pause for a bit
			try {
				Thread.sleep(2500);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}


		} //end for-loop that moved all bugs however many number of times


		//print out number of collisions
		System.out.println("After moving the bugs " + numberOfTimesBugsAreMoved + " times, there"
				+ " were " + numberOfCollisions + " collisions.");


	} //end of main method




	//method that shows the simulation
	public static void showSimulation(List <Bug> bugs, int GRIDSIZE) {

		boolean [][] isOccupied = new boolean [GRIDSIZE][GRIDSIZE];

		for(Bug bug: bugs) {
			//"i" is the x value, and "j" is the y value
			//use variable called boolean [][] isOccupied = new boolean [][]
			//go through bugs, put every bug's x and y coordinates into the boolean array
			//if true, print "*", if false, print "."

			isOccupied[bug.getX()][bug.getY()] = true;	
			System.out.println();
			System.out.println();
			System.out.println("POSITION OF BUGS AFTER MOVING:");

			for(int i = 0; i < isOccupied.length; i++) {
				for(int j = 0; j < isOccupied.length; j++) {
					if(isOccupied[i][j] == true) {
						System.out.print(" # ");
					} else {
						System.out.print(" - ");
					} //end if-else statements for printing out characters
				}
				System.out.println();
			}

		}  

	} //end show simulation
	
}





