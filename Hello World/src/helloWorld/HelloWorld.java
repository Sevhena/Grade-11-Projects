package helloWorld;

import java.util.Scanner;//CTRL+SHIFT+O Shortcut

public class HelloWorld {

	public static void main(String[] args) {
		//for(int x = 0; x < limit; x++) => when you know how many times you want to repeat an action
		
		//Declaration of variables
		int number = 0;
		boolean inputSuccess = true;
		Scanner input = new Scanner(System.in);
		
		//Prompt for information
		System.out.print("Please enter a number : ");
		
		//Error catch
		do {
			inputSuccess = true;
			try
			{
				number = input.nextInt();
			}
			catch (Exception e)//If exception is thrown it gets caught here
			{
				inputSuccess = false;
				input.next();
				System.out.print("Error occured please re-enter a number : ");
			}

		} while (inputSuccess == false);
		input.close();

		//Echo the input
		System.out.println("You entered the number " +number +".");
		
	}

}
