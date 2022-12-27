import java.io.File;

import java.util.Scanner;

import java.awt.Robot;

import java.awt.event.KeyEvent;

public class TextTwist {
	
	public static boolean letterMatch(String word, String letters) {
		//Converts the letters to a char array
		char[] letterArray = letters.toCharArray();
		int wordLength = word.length();
		
		//Checks if the word can be made from the letters
		for(int x = 0; x < word.length(); x++) {
			for(int i = 0; i < letterArray.length; i++) {
				if(word.charAt(x) == letterArray[i]) {
					//"subtracts" letter from char array so there are no repeats
					word = word.substring(0, x) +' ' +word.substring(x+1);
					letterArray[i] = ' ';
					wordLength--;
					break;
				}
			}
		}
		//System.out.println(word);
		
		//Checks if all letters in word were found
		if(wordLength == 0)
			return true;
		
		return false;
			
	}

	public static void main(String[] args) throws Exception{
		
		//Variables
		String letters = "";
		String word = "";
		Scanner input = new Scanner(System.in);
		Robot player = new Robot();
		
		//File variables
		File words = new File ("E:\\CS20 Sevhena Walker 1\\Dictionnary\\Unique Words.txt");
		Scanner scan = new Scanner(words);
		
		//Asks user for permissible letters
		System.out.println("What letters are you given?");
		letters = input.next();
		
		input.close();
		
		System.out.println("The following word(s) can be created from the letters: " +letters);
		
		Thread.sleep(5000);
		
		
		while(scan.hasNext()) {
			
			word = scan.next();
			if(letterMatch(word, letters)) {
				
				for(int y = 0; y < word.length(); y++) {
					
					if(word.charAt(y) == 'a')
						player.keyPress(KeyEvent.VK_A);
					else if(word.charAt(y) == 'b')
						player.keyPress(KeyEvent.VK_B);
					else if(word.charAt(y) == 'c')
						player.keyPress(KeyEvent.VK_C);
					else if(word.charAt(y) == 'd')
						player.keyPress(KeyEvent.VK_D);
					else if(word.charAt(y) == 'e')
						player.keyPress(KeyEvent.VK_E);
					else if(word.charAt(y) == 'f')
						player.keyPress(KeyEvent.VK_F);
					else if(word.charAt(y) == 'g')
						player.keyPress(KeyEvent.VK_G);
					else if(word.charAt(y) == 'h')
						player.keyPress(KeyEvent.VK_H);
					else if(word.charAt(y) == 'i')
						player.keyPress(KeyEvent.VK_I);
					else if(word.charAt(y) == 'j')
						player.keyPress(KeyEvent.VK_J);
					else if(word.charAt(y) == 'k')
						player.keyPress(KeyEvent.VK_K);
					else if(word.charAt(y) == 'l')
						player.keyPress(KeyEvent.VK_L);
					else if(word.charAt(y) == 'm')
						player.keyPress(KeyEvent.VK_M);
					else if(word.charAt(y) == 'n')
						player.keyPress(KeyEvent.VK_N);
					else if(word.charAt(y) == 'o')
						player.keyPress(KeyEvent.VK_O);
					else if(word.charAt(y) == 'p')
						player.keyPress(KeyEvent.VK_P);
					else if(word.charAt(y) == 'q')
						player.keyPress(KeyEvent.VK_Q);
					else if(word.charAt(y) == 'r')
						player.keyPress(KeyEvent.VK_R);
					else if(word.charAt(y) == 's')
						player.keyPress(KeyEvent.VK_S);
					else if(word.charAt(y) == 't')
						player.keyPress(KeyEvent.VK_T);
					else if(word.charAt(y) == 'u')
						player.keyPress(KeyEvent.VK_U);
					else if(word.charAt(y) == 'v')
						player.keyPress(KeyEvent.VK_V);
					else if(word.charAt(y) == 'w')
						player.keyPress(KeyEvent.VK_W);
					else if(word.charAt(y) == 'x')
						player.keyPress(KeyEvent.VK_X);
					else if(word.charAt(y) == 'y')
						player.keyPress(KeyEvent.VK_Y);
					else if(word.charAt(y) == 'z')
						player.keyPress(KeyEvent.VK_Z);
					Thread.sleep(10);
				}
		
				player.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(10);
			}
			
			//Calls method to check if word can be made from the specified letters
			//boolean match = letterMatch(word, letters);
			
			/*if(match) 
				System.out.println(word);*/
		}
		scan.close();
		//String sample = "sample";
		
		
		

		
	}

}
