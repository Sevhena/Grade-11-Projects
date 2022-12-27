package adding;

import java.util.Scanner;

import Toolkit.src.myTools.MyTools;

public class Adding {
	
	//adding method
	public static int adding(int number)
	{
		int sum = 0, lastDigit = 0;
		
		while(number > 0)
		{
			lastDigit = number % 10; // determines the last digit
			sum = sum + lastDigit;
			number = number/10; // makes last digit a decimal so that it is eliminated by integer specification
		}
		return sum;
	}

	public static void main(String[] args) {

		
		//Variables
		int number = 0, sum = 0;
		
		//Prompt
		System.out.print("Please enter a four digit number: ");
		
		//calls number, checks if negative
		Scanner input = new Scanner(System.in);
		number = MyTools.errorTrap(input, 1, 9999);
		if(number < 0)
			number = number*-1;
		
		//Print out
		sum = adding(number); //calls adding method
		System.out.println("The sum of the number you entered is: " +sum);
			
	}

}
