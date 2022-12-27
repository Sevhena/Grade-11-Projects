package numberGuessingGame;

import java.util.Scanner;

public class NumberGame {
	
	public static int levelTrap(Scanner input)
	{
		boolean goodInput = true;
		int level = 0;
		do
		{
			System.out.println("Please choose a level of difficulty.");
			try
			{
				goodInput = true;
				level = input.nextInt();
			}
			catch(Exception e)
			{
				goodInput = false;
				input.next();
				System.out.println("An error occured. Please re-make your choice.");
			}
			
			if(level > 3 || level < 1)
				System.out.println("Invalid number.");
			
		}while(goodInput == false || level > 3 || level < 1);
		
		return level;
	}
	
	public static int numberGenerator(int min, int max)
	{
		int number = 0;
		number = (int) (Math.random()*(max-min+1)+min);
		return number;
	}
	
	public static int guessTrap(Scanner input, int min, int max)
	{
		boolean goodInput = true;
		int guess = 0;
		do
		{
			try
			{
				goodInput = true;
				guess = input.nextInt();
			}
			catch(Exception e)
			{
				goodInput = false;
				input.next();
				System.out.println("An error occured. Please re-enter a number.");
			}
			
			if(guess > max || guess < min)
				System.out.println("Invalid number. Please re-enter a number");
			
		}while(goodInput == false || guess > max || guess < min);
		
		return guess;
	}
	
	public static void temp(int guess, int number, int level)
	{
		int difference = 0;
		difference = guess - number;
		if (difference < 0)
			difference = difference * -1;
		
		if(level == 1)
		{
			if(difference == 2)
				System.out.println("Warm");
			else if(difference == 1)
				System.out.println("Hot");
			else 
				System.out.println("Cold");
		}
		if(level == 2)
		{
			if(difference == 1)
				System.out.println("Hot");
			else if(difference <= 3)
				System.out.println("Warm");
			else 
				System.out.println("Cold");
		}
		if(level == 3)
		{
			if(difference <= 2)
				System.out.println("Hot");
			else if(difference <= 4)
				System.out.println("Warm");
			else 
				System.out.println("Cold");
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Variables
		Scanner input = new Scanner(System.in);
		int wins = 0, loss = 0;
		int guess = 0, number;
		int playAgain = 0, tries = 3;
		boolean goodInput = true;
		
		do 
		{
			tries = 3;
			
			//Game Welcome
			System.out.println("Welcome to the Number Guessing Game!");
			System.out.println("************************************");
			System.out.println("      Wins: " +wins +"     Losses: " +loss);
			System.out.println("************************************");
			System.out.println("Level 1 : Numbers from 1 to 10.");
			System.out.println("Level 2 : Numbers from 1 to 20.");
			System.out.println("Level 3 : Numbers from 1 to 30.");
			//System.out.println("Tries : " +tries);
			System.out.println();

			//Random Number generator
			
			int level = levelTrap(input);
			
			if(level == 1)
				number = numberGenerator(1,10);
			else if(level == 2)
				number = numberGenerator(1,20);
			else
				number = numberGenerator(1,30);
			
			//Player guess
			do 
			{
				System.out.println("Please guess a number :");
				if(level == 1)
					guess = guessTrap(input, 1,10);
				else if(level == 2)
					guess = guessTrap(input, 1,20);
				else 
					guess = guessTrap(input, 1,30);
				if(guess == number)
				{
					System.out.println("You are correct!");
					wins++;
				}
				else 
				{
					tries--;
					if(tries == 0)
					{
						System.out.println("Sorry, that is incorrect. The number was " +number +".");
						loss++;
					}
					else 
					{
						temp(guess,number,level);
						System.out.println("Sorry, that is incorrect. Please try again.");
					}
				}
			}while(tries > 0 && number != guess);
			
			//Play Again
			System.out.println("Would you like to play again (yes = 1, no = 0)?");
			
			do
			{
				try
				{
					goodInput = true;
					playAgain = input.nextInt();
				}
				catch(Exception e)
				{
					goodInput = false;
					input.next();
					System.out.println("An error occured. Please enter a number.");
				}
				
			}while(goodInput == false || playAgain > 1 || playAgain < 0);
		
		}while(playAgain == 1);
		
		input.close();
		//Bye
		System.out.println("Thank you for playing!");
	}
}
