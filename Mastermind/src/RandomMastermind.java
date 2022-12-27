import java.util.Scanner;

//import sequenceMastermind.String;

public class RandomMastermind {
	
	//Method determines how many colours are in the correct position or wrong position
	public static int[] feedback(String possibility, String solution ) {
		
		//Variables
		int goodIndex = 0, wrongIndex = 0;
		String nameHold = solution;
		
		//Blanks out all colours in correct position
		for(int x = 0; x < 4; x++) {
			if(possibility.charAt(x) == solution.charAt(x)) {
				nameHold = nameHold.substring(0, x) +' ' +nameHold.substring(x+1);
				goodIndex++;
				//System.out.println(nameHold);
			}
			else 
				continue;
		}
		
		for(int x = 0; x < 4; x++) {
			//Sets letters other than current evaluated letter to variables 
			//in order to compare more easily.
			int a = 0, b = 0, c = 0;
			if(possibility.charAt(x) != solution.charAt(x)) {
				if(x == 0) {
					a = 1;
					b = 2;
					c = 3;
				}
				else if(x == 1) {
					a = 0;
					b = 2;
					c = 3;
				}
				else if(x == 2) {
					a = 0;
					b = 1;
					c = 3;
				}
				else if(x == 3) {
					a = 0;
					b = 1;
					c = 2;
				}
				//Determines whether there is a colour in the wrong position
				if(possibility.charAt(x) == nameHold.charAt(a) || possibility.charAt(x) == nameHold.charAt(b) || possibility.charAt(x) == nameHold.charAt(c)) {
					//Compares evaluated colour with colour assigned to variable 'a'
					if(possibility.charAt(x) == nameHold.charAt(a))
						nameHold = nameHold.substring(0, a) +' ' +nameHold.substring(a+1);
					//Compares evaluated colour with colour assigned to variable 'a'
					else if(possibility.charAt(x) == nameHold.charAt(b))
						nameHold = nameHold.substring(0, b) +' ' +nameHold.substring(b+1);
					//Compares evaluated colour with colour assigned to variable 'a'
					else if(possibility.charAt(x) == nameHold.charAt(c)) {
						if(x == 3)
							nameHold = nameHold.substring(0, c) +' ' +nameHold.substring(c+1);
						//To avoid out-of-bounds
						else 
							nameHold = nameHold.substring(0, c) +' ';
					}
					wrongIndex++;
				}	
			}
			else 
				continue;
		}
		
		//Sets both feedback values to an array to return both at the same time
		int[] index = new int [2];
		index[0] = goodIndex;
		index[1] = wrongIndex;
		return index;
	}
	
	//Method finds next plausible guess sequentially
	public static boolean[] triage(String[] combos, boolean[] verdict, String guess, int goodIndex, int wrongIndex)
	{
		//Variables
		int[] i = new int [2];
		
		//Checks if feedback when 'guess' compared to next possibility is the same
		for(int x = 0; x < combos.length; x++) {
			//Calls feedback method
			i = feedback(guess, combos[x]);
			if(i[0] != goodIndex || i[1] != wrongIndex)
				verdict[x] = false;
		}
		
		return verdict;
	}
	
	public static String nextLogicGuess(String[] combos, boolean[] verdict, String guess, int goodIndex, int wrongIndex)
	{
		
		int index = 0;
		
		verdict = triage(combos, verdict, guess, goodIndex, wrongIndex);
		
		//Finds next possible guess
		for(int x = 0; x < verdict.length; x++) {
			if(verdict[x] == true) {
				index = x;
				break;
			}
		}
		return combos[index];
	}
	
	//Method finds next plausible guess randomly
	public static String randLogicGuess(String[] combos, boolean[] verdict, String guess, int goodIndex, int wrongIndex)
	{
		//Variables
		int index = 0;
		verdict = triage(combos, verdict, guess, goodIndex, wrongIndex);
		
		//Finds next possible guess
		do {
			int min = 0, max = verdict.length - 1;
			index = (int) (Math.random()*(max-min+1)+min);
		}while(verdict[index] = false);
		
		return combos[index];
	}
	
	//Method finds next possible guess
	public static String nextRanGuess(String[] combos, boolean[] verdict)
	{
		//Variables
		int index = 0;
		String randomRecommend = "";
		
		//Finds next possible random guess
		do {
			int min = 0, max = verdict.length - 1;
			index = (int) (Math.random()*(max-min+1)+min);
		}while(verdict[index] = false);
		
		randomRecommend = combos[index];
		
		return randomRecommend;
		
	}
	
	public static void main(String[] args) {
		
		//Variables
		char[] colours = {'B','I','S','O','P','R'};
		final int arrayLength = 1296;
		String[] combos = new String [arrayLength];
		boolean[] verdict = new boolean [arrayLength];
		int computerChoice = 0;
		String guess = ""; 
		Scanner input = new Scanner(System.in);
		
		//Generates verdict array
		for(int x = 0; x < verdict.length; x++) 
			verdict[x] = true;
		
		//Prints verdict array
		/*for(int x = 0; x < verdict.length; x++) 
			System.out.println(verdict[x]);*/
		
		//Determines all possible combinations of six colours (Generates combos array)
		int index = 0;
		for(int one = 0; one < 6; one++) {
			for(int two = 0; two < 6; two++) {
				for(int three = 0; three < 6; three++) {
					for(int four = 0; four < 6; four++) {
						combos[index] = Character.toString(colours[one]) + Character.toString(colours[two]) + Character.toString(colours[three]) + Character.toString(colours[four]);
						index++;
					}
				}
			}
		}
		
		//Prints combination array
		/*for(int x = 0; x < combos.length; x++) 
			System.out.println(combos[x]);*/
		
		//Introduction
		System.out.println("Welcome to Mastermind: Random vs. Sequential");
		System.out.println("********************************************");
		System.out.println();
		
		int incorrectA = 0, correctA = 0, guessesA = 0;
		final double TRIALLENGTH = 10000;
		
		//Determines statistics for random mastermind
		//Chooses a random guess that hasn't already been determined false through guessing
		
		for(int trials = 0; trials < TRIALLENGTH; trials++) {
			//Computer chooses a random combination index
			int min = 0, max = combos.length - 1;
			computerChoice = (int) (Math.random()*(max-min+1)+min);
			
			String trueCombo = (combos[computerChoice]);
			
			int tries = 10;
					
			do {
			
				guess = nextRanGuess(combos, verdict);
					
				if(guess.equals(trueCombo)) {
					correctA++;
					guessesA++;
				}	
				else {
					incorrectA++;
					guessesA++;
					//Sets incorrect guess to false in verdict array
					for(int x = 0; x < combos.length; x++) {
						if(guess.equals(combos[x])) {
							verdict[x] = false;
							break;
						}		
					}
					
					//Reduces number of tries left
					tries--;
				}
			
			}while(!guess.equals(trueCombo) && tries > 0);
		}
		
		int incorrectB = 0, correctB = 0, guessesB = 0;
		
		//Determines statistics for sequential mastermind
		//Only always guesses the first ten combinations in the combinations array
		
		for(int trials = 0; trials < TRIALLENGTH; trials++) {
			//Generates verdict array
			for(int x = 0; x < verdict.length; x++) 
				verdict[x] = true;
			
			//Computer chooses a random combination index
			int min = 0, max = combos.length - 1;
			computerChoice = (int) (Math.random()*(max-min+1)+min);
			
			String trueCombo = (combos[computerChoice]);
			
			int tries = 10, guessIndex = 0;
			
			
			do {
				
				//Calls method to figure out recommended next guess
				//guessIndex = nextSeqGuess(combos, verdict, tries, guessIndex);
				
				guess = combos[guessIndex];			
				
				if(guess.equals(trueCombo)) {
					correctB++;
					guessesB++;
				}
				else {
					incorrectB++;
					guessesB++;
					//Sets incorrect guess to false in verdict array
					for(int x = 0; x < combos.length; x++) {
						if(guess.equals(combos[x])) {
							verdict[x] = false;
							break;
						}		
					}
					
					//Reduces number of tries left
					tries--;
				}
				
				guessIndex++;
			}while(!guess.equals(trueCombo) && tries > 0);
		}
				
		int incorrectC = 0, correctC = 0, guessesC = 0;
		
		//Determines statistics for logical Sequential Mastermind
		//Determines the next guess by filtering out guesses that 
		//are not possible based on how many are in the correct or wrong position.
		//The computer guesses the next possible combination in the array
		
		for(int trials = 0; trials < TRIALLENGTH; trials++) {
			//Generates verdict array
			for(int x = 0; x < verdict.length; x++) 
				verdict[x] = true;

			//Computer chooses a random combination index
			int min = 0, max = combos.length - 1;
			computerChoice = (int) (Math.random()*(max-min+1)+min);
			
			String trueCombo = (combos[computerChoice]);
			
			int tries = 10, goodIndex = 0, wrongIndex = 0;
			
			do {
				//Calls method to figure out recommended next guess
				guess = nextLogicGuess(combos, verdict, guess, goodIndex, wrongIndex);
				//System.out.println(guess + " " + trueCombo);
				
				if(guess.equals(trueCombo)) {
					correctC++;
					guessesC++;
				}
				else {
					incorrectC++;
					guessesC++;
					//Sets incorrect guess to false in verdict array
					for(int x = 0; x < combos.length; x++) {
						if(guess.equals(combos[x])) {
							verdict[x] = false;
							break;
						}		
					}
					
					//Reduces number of tries left
					tries--;
					
					//Calls feedback method 
					int[] i = new int [2];
					i = feedback(guess, trueCombo);
					goodIndex = i[0]; 
					wrongIndex = i[1];
				}
				
			}while(!guess.equals(trueCombo) && tries > 0);
		}
		
		int incorrectD = 0, correctD = 0, guessesD = 0;
		
		//Determines statistics for logical Random Mastermind
		//Same as logical sequential mastermind except that the computer guesses
		//a random possible combination from the list
		
		for(int trials = 0; trials < TRIALLENGTH; trials++) {
			//Generates verdict array
			for(int x = 0; x < verdict.length; x++) 
				verdict[x] = true;
			
			//Computer chooses a random combination index
			int min = 0, max = combos.length - 1;
			computerChoice = (int) (Math.random()*(max-min+1)+min);
			
			String trueCombo = (combos[computerChoice]);
			
			int tries = 10, goodIndex = 0, wrongIndex = 0;
			
			do {
				//Calls method to figure out recommended next guess
				guess = randLogicGuess(combos, verdict, guess, goodIndex, wrongIndex);
				
				if(guess.equals(trueCombo)) {
					correctD++;
					guessesD++;
				}
				else {
					incorrectD++;
					guessesD++;
					//Sets incorrect guess to false in verdict array
					for(int x = 0; x < combos.length; x++) {
						if(guess.equals(combos[x])) {
							verdict[x] = false;
							break;
						}		
					}
					
					//Reduces number of tries left
					tries--;
					
					//Calls feedback method 
					int[] i = new int [2];
					i = feedback(guess, trueCombo);
					goodIndex = i[0]; 
					wrongIndex = i[1];
				}
				
			}while(!guess.equals(trueCombo) && tries > 0);
		}
		
		//Output of results
		System.out.println("Random Mastermind");
		System.out.println(correctA +" guesses out of " +(int)TRIALLENGTH +" were correct.");
		System.out.println("The odds of guessing correctly with this method are " +correctA/TRIALLENGTH*100 +"%.");
		System.out.println();
		
		System.out.println("Sequential Mastermind");
		System.out.println(correctB +" guesses out of " +(int)TRIALLENGTH +" were correct.");
		System.out.println("The odds of guessing correctly with this method are " +correctB/TRIALLENGTH*100 +"%.");
		System.out.println();
		System.out.println();
		
		System.out.println("Logical Sequential Mastermind");
		System.out.println(correctC +" guesses out of " +(int)TRIALLENGTH +" were correct.");
		System.out.println("The odds of guessing correctly with this method are " +correctC/TRIALLENGTH*100 +"%.");
		System.out.println();
		System.out.println();
		
		System.out.println("Logical Random Mastermind");
		System.out.println(correctD +" guesses out of " +(int)TRIALLENGTH +" were correct.");
		System.out.println("The odds of guessing correctly with this method are " +correctD/TRIALLENGTH*100 +"%.");
		System.out.println();
	}

}
