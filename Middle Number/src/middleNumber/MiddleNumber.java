package middleNumber;

import Toolkit.src.myTools.MyTools;

import java.util.Scanner;

public class MiddleNumber {
	
	public static long middleNumber()
	{
		Scanner input = new Scanner(System.in);
		long inputI = 0, inputII = 0, inputIII = 0;
		long midNumber = 0;
		
		System.out.print("What will be your first number? ");
		inputI = MyTools.errorTrap(input); //calls error trap
		
		System.out.print("What will be your second number? ");
		inputII = MyTools.errorTrap(input); //calls error trap
		
		System.out.print("What will be your third number? ");
		inputIII = MyTools.errorTrap(input); //calls error trap
		
		input.close();

		//Checks for middle number
		if((inputI >= inputII && inputI <= inputIII) || (inputI >= inputIII && inputI <= inputII))
			midNumber = inputI;
		else if((inputII >= inputI && inputII <= inputIII) || (inputII >= inputIII && inputII <= inputI))
			midNumber = inputII;
		else
			midNumber = inputIII;
		
		return midNumber;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long midNumber = 0;
		System.out.println("Welcome to the Middle Number finder.");
		
		midNumber = middleNumber();
		
		System.out.println("The middle number is: " +midNumber);
			
	
	}

}
