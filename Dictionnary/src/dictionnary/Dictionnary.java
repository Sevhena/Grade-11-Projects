package dictionnary;

import java.io.*;

import Toolkit.src.myTools.MyTools;

import java.util.Scanner;

public class Dictionnary {
	
	public static int wordCount(File book) throws Exception{
		
		Scanner reader = new Scanner(book);
		int wordCount = 0;
		
		//Counts ALL the words in the text file
		while(reader.hasNext()) {
			wordCount++;
			reader.next();
		}
		reader.close();
		
		return wordCount;
	}
	
	public static int uniqueWordCount(File book, String[][] dictionary, int row, int column) {
		
		int uniqueWordCount = 0;
		
		//Counts all the words in the dictionary
		for(int x = 0; x < row; x++) {
			for(int i = 0; i < column; i++) {
				if(dictionary[x][i] == null)
					continue;
				else
					uniqueWordCount++;
			}
		}
		
		return uniqueWordCount;
	}
	public static boolean wordCheck(String word) {
		
		int vowel = 0;
		
		//Checks the length of the word
		if(word.length() < 3 || word.length() > 6)
			return true;
		else {
			//Checks the characters in the word 
			for(int x = 0; x < word.length(); x++) {
				if(word.charAt(x) > 122 || word.charAt(x) < 97) {
					return true;
				}
				//Checks if word is actually a word by making sure it has a vowel
				else if(word.charAt(x) == 'a' || word.charAt(x) == 'o' || word.charAt(x) == 'i'|| word.charAt(x) == 'u' || word.charAt(x) == 'e' || word.charAt(x) == 'y')
					vowel++;
			}
		}
		
		if(vowel == 0)
			return true;
		
		return false;
	}
	
	public static void uniqueWordList(String[][] dictionary, int row, int column, File text) throws Exception {
		
		//FileOutputStream u = new FileOutputStream (text);
		PrintWriter output = new PrintWriter(text);
		
		for(int x = 0; x < row; x++) {
			for(int i = 0; i < column; i++) {
				if(dictionary[x][i] != null)
					output.println(dictionary[x][i]);
			}
		}
		
		output.close();
	}

	public static void main(String[] args) throws Exception{
		
		//Book file variables
		File book = new File ("Dictionnary\\src\\files\\english3.txt");
	    	
		//New File variables
		File unique = new File ("Dictionnary\\src\\output\\Unique Words.txt");
		
		//Dictionary variables
		final int row = 200000, column = 15;
		String[][] dictionary = new String [row][column];
		String word = ""; 
		Scanner reader = new Scanner(book);	
		int wordCount = 0, uniqueWord = 0;
		int noSpace = 0;
		
		while(reader.hasNext()) {
			
			//The next word in the file is assigned to the variable word
			word = reader.next();
			
			//Calls method to check whether word is between 2 and 6 letters long
			//and is it is a lowercase word
			boolean special = wordCheck(word);
			
			//Goes to the next word if the word doesn't fit parameters
			if(special)
				continue;
			//Gives word a hashcode
			int hashcode = Math.abs(word.hashCode() % row);
			//For loop to assign words to the dictionary
			for(int slot = 0; slot < column; slot++) {
				//Checks if word is already in the dictionary
				if(word.equals(dictionary[hashcode][slot])) {
					//System.out.println("The word " +word +" has already been entered.");
					break;
				}
				//assigns word to empty slot
				else if(dictionary[hashcode][slot] == null) {
					dictionary[hashcode][slot] = word;
					//System.out.println(word);
					break;
				}
				if(slot == (column - 1))
					noSpace++;
			}			
		}
		
		reader.close();
		
		//User interface
		Scanner input = new Scanner(System.in);
		int userChoice = 0;
		do {
			System.out.println("Welcome to the file reader.");
			System.out.println("***************************");
			System.out.println("Choose an action: ");
			System.out.println("0. Exit");
			System.out.println("1. Count all the words in the file.");
			System.out.println("2. Count all the unique words in the file.");
			System.out.println("3. Create a file with all the unique words.");
			System.out.println("no space: " +noSpace);
			
			userChoice = MyTools.errorTrap(input,0,3);
			
			//Calls word count method
			if(userChoice == 1) {
				wordCount = wordCount(book);
				System.out.println("The text has " +wordCount +" words.");
				System.out.println();
			}
			//Calls unique word count method
			else if(userChoice == 2) {
				uniqueWord = uniqueWordCount(book, dictionary, row, column);
				System.out.println(uniqueWord +" of those words are unique.");
				System.out.println();
			}
			//creates a text file of all the unique words in the original file
			else if(userChoice == 3) {
				uniqueWordList(dictionary, row, column, unique);
				System.out.println("New file 'Unique Words' has been created.");
				System.out.println();
			}
				
		}while(userChoice != 0);		
		
		input.close();
	}

}
