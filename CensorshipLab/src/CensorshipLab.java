/*I looked on the Internet to get the System.exit(0) line, but I don't remember the 
 * website or anything. I just wanted to find something that would end the program
 * if the user clicks cancel in the little File Chooser window. Hopefully that doesn't
 * count as cheating or anything, it's not like I copied whole blocks of code. Also Aayla helped
 * me out with the whole printing out lines of code thing because I was completely stumped. So
 * yeah, I had some help.*/

import java.io.*;
import java.util.*;
import javax.swing.*;

public class CensorshipLab {
	public static void main (String [] args) {
		
		//creates new JFileChooser object
		JFileChooser chooser = new JFileChooser();
		//creates file object
		java.io.File file;
		//creates ArrayList for my dictionary
		List <String> dictionary = new ArrayList <String>();
		
		try {
			//create scanner for dictionary
			Scanner dictScanner = new Scanner(new File("dictionary.txt"));
			//sets the index to be the number at the beginning of my dictionary
			int index = dictScanner.nextInt();
			//for loop to add the words from my dictionary file to the dictionary arraylist
			for(int i = 0; i < index; i++) {
				dictionary.add(i, dictScanner.nextLine());
			}	
		} catch(FileNotFoundException fnfe) {
			System.out.println("Dictionary not found");
		} //end of try-catch for dictionary not found
		
		
		
		try {	
			//JFileChooser opens
			if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile();
				//attach scanner to the file that needs to be checked
				Scanner checkFile = new Scanner(file);
				List <String> listArray = new ArrayList <String>();
				
				//loop will continue as long as the file has another line
				while(checkFile.hasNextLine()) {
					//adds each line in the file to my listArray
					listArray.add(checkFile.nextLine());
				}
				
				for(int i = 0; i < listArray.size(); i++) {
					//assigns the line in listArray to the variable currentLine
					String currentLine = listArray.get(i);
					//splits the line into it's individual words
					String [] wordsInCurrentLine = currentLine.split(" ");
					
					//for loop to check if each word in the line is in the dictionary
					for(int index = 0; index < wordsInCurrentLine.length; index++) {
						//assigns one word at a time to the wordToCheck variable
						String wordToCheck = wordsInCurrentLine[index];
						//if the dictionary contains that word, prints out the entire line
						if(dictionary.contains(wordToCheck)) {
							System.out.println(currentLine);
						} //end of if dictionary.contains statement
						
					} //end of for loop to check each word in the line					
				} //end of other for loop 
			
				
			} else {
				//if user clicks cancel, the program will terminate
				System.exit(0);
			} //end if-else statement for JFileChooser 
			
		 } catch(FileNotFoundException fnfe) {
			System.out.println("File not found");
			//throws the red vomit, yay, so much fun to see
			fnfe.printStackTrace();
		} //end of try-catch for file not found
		


	} //end of main
} //end of CenshorshipLab
