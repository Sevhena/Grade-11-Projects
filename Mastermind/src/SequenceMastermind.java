import java.util.Scanner; 

public class SequenceMastermind {

	//Method determines how many colours are in the correct position or wrong position
	public static int[] feedback(String possibility, String trueCombo ) {
		
		//Variables
		int goodIndex = 0, wrongIndex = 0;
		String nameHold = trueCombo;
		
		//Blanks out all colours in correct position
		for(int x = 0; x < 4; x++) {
			if(possibility.charAt(x) == trueCombo.charAt(x)) {
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
			if(possibility.charAt(x) != trueCombo.charAt(x)) {
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
	
	//Method finds next possible guess
	public static int nextGuess(String[] combos, boolean[] verdict, int tries, int index)
	{
		int computerChoice = 0;
		String sequentialRecommend = "";
		
		//Finds next possible random guess
		if(tries == 10) {
			int min = 0, max = combos.length - 1;
			computerChoice = (int) (Math.random()*(max-min+1)+min);
		}
		else
			computerChoice = index + 1;
		
		sequentialRecommend = combos[computerChoice];
		
		//Output message for next guess
		System.out.println("Your next guess should be: " +sequentialRecommend);
		
		return computerChoice;
		
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
		
		//Computer chooses a random combination index
		int min = 0, max = combos.length - 1;
		computerChoice = (int) (Math.random()*(max-min+1)+min);
		
		String trueCombo = (combos[computerChoice]);
		
		int tries = 10, goodIndex = 0, wrongIndex = 0, guessIndex = 0;
		
		//Introduction
		System.out.println("Welcome to Sequential Mastermind");
		
		do {
			//Print out correct combination
			//System.out.println(trueCombo);
			
			//Instructions
			System.out.println();
			System.out.println("---------------------");
			System.out.println("     Tries: " +tries);
			System.out.println("---------------------");
			System.out.println("Please enter a 4 colour combination from the following colours: B I S O P R.");
			System.out.println("In capitals, no spaces.");
			
			//Calls method to figure out recommended next guess
			guessIndex = nextGuess(combos, verdict, tries, guessIndex);
			
			//Error Trap for invalid characters and combination length
			boolean goodInput = true;
			do {
				goodInput = true;
				guess = input.next();
				
				//Length trap
				if(guess.length() != 4)
					goodInput = false;
				//Character trap
				else {
					for(int x = 0; x < 4; x++) {
						if(guess.charAt(x) != 'B' && guess.charAt(x) != 'I' && guess.charAt(x) != 'S' && guess.charAt(x) != 'O' && guess.charAt(x) != 'P' && guess.charAt(x) != 'R') {
							goodInput = false;
						}
					}
				}
				
				//Error Message
				if(goodInput == false)
					System.out.println("Invalid combination. Please enter another combination.");
				
			}while(goodInput == false);
			
			
			if(guess.equals(trueCombo))
				System.out.println("You are correct!");
			else {
				//Sets incorrect guess to false in verdict array
				for(int x = 0; x < combos.length; x++) {
					if(guess.equals(combos[x])) {
						verdict[x] = false;
						break;
					}		
				}
				
				System.out.println("Incorrect combination.");
				
				//Reduces number of tries left
				tries--;
				
				//Calls feedback method 
				int[] i = new int [2];
				i = feedback(guess, trueCombo);
				goodIndex = i[0]; 
				wrongIndex = i[1];
				
				//Feedback output
				if(goodIndex > 0)
					System.out.println(goodIndex +" correct.");
				if(wrongIndex > 0)
					System.out.println(wrongIndex +" wrong position.");
				
				
			}
			
		}while(!guess.equals(trueCombo) && tries > 0);
		
		//Player loss message
		if(!guess.equals(trueCombo)) {
			System.out.println();
			System.out.println("Sorry you have run out of tries.");
		}		
	}
}
