import java.util.Arrays;

import java.util.Scanner;

public class MyTools {
	
	//error trap for doubles that only checks input type
	public static double errorTrapd(Scanner input)
	{
		boolean goodInput = true;
		int number = 0;
		do 
		{
			goodInput = true;
			try
			{
				System.out.println("Please enter a number : ");
				number = input.nextInt();
			}
			catch (Exception e)//If exception is thrown it gets caught here
			{
				goodInput = false;
				input.next();
				System.out.print("Error occured.");
			}
		}while (goodInput == false);
		
		return number;
	}
	
	//error Trap for doubles that also checks range
	public static double errorTrapd(Scanner input, int max, int min)
	{
		boolean goodInput = true;
		int number = 0;
		do
		{
			try
			{
				System.out.print("Enter a number from " + min + " to " + max + ": ");
				goodInput = true;
				number = input.nextInt();
			}
			catch(Exception e)
			{
				goodInput = false;
				input.next();
				System.out.println("Invalid entry. Please re-make your choice.");
			}
			
			if(number > max || number < min)
				System.out.print("Number does not fit specified parameters.");
			
		}while(goodInput == false || number > max || number < min);
		
		return number;
	}
	
	//Error trap for integers that only checks input type
	public static int errorTrap(Scanner input)
	{
		//Scanner input = new Scanner(System.in);
		boolean goodInput = true;
		int number = 0;
		do 
		{
			goodInput = true;
			try
			{
				System.out.print("Please enter a number : ");
				number = input.nextInt();
			}
			catch (Exception e)//If exception is thrown it gets caught here
			{
				goodInput = false;
				input.next();
				System.out.print("Error occured.");
			}
		}while (goodInput == false);
		
		return number;
	}

	//Error Trap for integers that also checks range
	public static int errorTrap(Scanner input, int min, int max)
	{
		// Scanner input = new Scanner(System.in);
		boolean goodInput = true;
		int number = 0;
		do
		{
			try
			{
				System.out.print("Enter a number from " + min + " to " + max + ": ");
				goodInput = true;
				number = input.nextInt();
			}
			catch(Exception e)
			{
				goodInput = false;
				input.next();
				System.out.println("Invalid entry. Please re-make your choice. ");
			}
			
			if(number > max || number < min)
				System.out.print("Number does not fit specified parameters. ");
			
		}while(goodInput == false || number > max || number < min);
		
		return number;
	}
	
	//Random number generator that minimum and maximums in any order
	public static int numberGen(int min, int max)
	{
		int hold = 0;
				
		if(min > max) {
			hold = min;
			min = max;
			max = hold;
		}
		
		/*System.out.print("Please enter a minimum: ");
		min = errorTrap(); //calls minimum from error trap method
		System.out.print("Please enter a maximum: ");
		max = errorTrap(); // calls maximum from error trap method*/
		
		int number = (int) (Math.random()*(max-min+1)+min);
		
		return number;
	}

	//method that receives a number and returns the "n" digit
	public static int digitFinder(int number, int place)
	{
		int nbDigits = 0, trueDigit = 0, lastDigit = 0;
		int hold = number;
		
		//Finds out how many digits in the number
		while(hold > 0) {
			nbDigits++;
			hold = hold/10; // makes last digit a decimal so that it is eliminated by integer specification
		}
		
		//Determines which digit to output
		do {
			lastDigit = number % 10; // determines the last digit
			number = number/10; // makes last digit a decimal so that it is eliminated by integer specification
			nbDigits--;
		}while(nbDigits >= place);
		
		//System.out.println(lastDigit);
		trueDigit = lastDigit;
		
		return trueDigit;
	}
	
	public static void charFinder(String word) //Determines the "n" letter in a word
	{
		Scanner input = new Scanner(System.in);
		
		/*System.out.print("Please enter a word : ");
		String word = input.next();*/
		
		//input.close();
		
		int length = word.length();
		
		int charChoice = MyTools.errorTrap(input, 1, length);
		
		char letter = word.charAt(charChoice-1);
		
		if(charChoice % 10 == 1)
			System.out.println("The " +charChoice +"st letter is: " +letter);
		else if(charChoice % 10 == 2)
			System.out.println("The " +charChoice +"nd letter is: " +letter);
		else if(charChoice % 10 == 3)
			System.out.println("The " +charChoice +"rd letter is: " +letter);
		else 
			System.out.println("The " +charChoice +"th letter is: " +letter);
	}
	
	public static int[] createRandomAr(int SIZE) //Creates a random array
	{
		int[] array = new int[SIZE];
		
		for(int x = 0; x < SIZE; x++)
			 array[x] = (int)(Math.random()*SIZE+1);
		
		return array;
	}
	
	public static int[] initializeSortedAr(int[] array)
	{
		int value = 1;
		for(int i = 0; i < array.length; i++) {
			array[i] = value;
			value++;
		}
		
		return array;
	}
	
	public static void randomArray(int[] array) //Populates a random array
	{
		//generates array
		for(int x = 0; x < array.length; x++)
			 array[x] = (int)(Math.random()*array.length+1);
		
		//outputs array
		/*for (int x = 0; x < array.length; x++)
			System.out.print(array[x] + " ");*/
	}
	
	public static void sortedArray(int[] array) //Populates the array sequentially
	{
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void shuffleArray(int[] array) //Shuffles the array
	{ 			
		//Shuffle
		//Swaps number at position x with another number 
		//at a random position
		for (int x = 0; x < array.length; x++) {
		    int randomPosition = (int)(Math.random()*array.length);
		    int temp = array[x];
		    array[x] = array[randomPosition];
		    array[randomPosition] = temp;
		}
		//Output
		for (int x = 0; x < array.length; x++)
			System.out.print(array[x] + " ");
	}
	
	public static void findArNumber(int[] array) //Finds a number in the array
	{
		Scanner input = new Scanner(System.in);
		int position = 0;
		boolean occurred = false;
		//Asks user which number they would like to find
		System.out.print("Which number would you like to find? ");
		int occurrence = MyTools.errorTrap(input, 1, array.length);
		//Determines whether the number occurred and at which index
		for (int x = 0; x < array.length; x++) {
			if(array[x] == occurrence && occurred == false) {
				position = x;
				occurred = true;
			}
		}
		if(occurred)
			System.out.println("The number " +occurrence +" populated at index " +position +".");
		else
			System.out.println("-1");
	}
	
	public static void checksSortedAr(int[] array) //Checks to see if the array is sorted
	{
		boolean croissant = true; //"Croissant" means ascending in French
		//Checks to see if the array is sorted and breaks at 
		//first sign of that being false
		for(int x = 0; x < array.length-1; x++){
			if(array[x] > array[x+1]) {
				croissant = false;
				break;
			}
		}
		if(croissant == true)
			System.out.println("Array in ascending order.");
		else
			System.out.println("Not in ascending order.");
	}
	
	public static void shuffleSort(int[] array) //Shuffles array until sorted or after 100,000 tries
	{
		boolean croissant = true;
		for(int tries = 0; tries < 100000; tries++) {
			croissant = true;
			//Checks to see if the array was sorted
			for(int x = 0; x < array.length-1; x++){
				if(array[x] > array[x + 1])
					croissant = false;
			}
			//If the array was sorted, breaks out of the loop
			if(croissant)
				break;
			//If the array was not sorted, it shuffles 
			else if(croissant == false) {
				for (int x = 0; x < array.length; x++) {
				    int randomPosition = (int)(Math.random()*array.length);
				    int temp = array[x];
				    array[x] = array[randomPosition];
				    array[randomPosition] = temp;
				}
			}
		}
		if(croissant)
			System.out.println("The array was succesfully sorted.");
		else 
			System.out.println("100,000 tries have elapsed. The array was not successfully sorted.");
	}
	
	public static void lowestArNumber(int[] array) //Finds the lowest number in the list
	{
		int smallNumber = array[0];
		//Determines the lowest number in the array
		for (int x = 0; x < array.length; x++) {
			if(array[x] < smallNumber)
				smallNumber = array[x];
		}
		System.out.println("The smallest number in the array is " +smallNumber +".");
	}
	
	public static void greatestArNumber(int[] array)//Finds the greatest number in the list
	{
		int bigNumber = array[0];
		//Determines the greatest number in the array
		for (int x = 0; x < array.length; x++) {
			if(array[x] > bigNumber)
				bigNumber = array[x];
		}
		System.out.println("The biggest number in the array is " +bigNumber +".");
	}
	
	public static void recurrentArNumber(int[] array) //Finds how many times a number occurred in the list
	{
		Scanner input = new Scanner(System.in);
		int occurrence = 0;
		boolean occurred = false;
		//Asks user which number they are inquiring about
		System.out.print("Which number would you like to find? ");
		int numberChoice = MyTools.errorTrap(input,1,array.length);
		//Checks to see if the number occurred and how many times
		for (int x = 0; x < array.length; x++) {
			if(array[x] == numberChoice) {
				occurred = true;
				occurrence++;
			}
		}
		if(occurred == false)
			System.out.println("The number " +numberChoice +" did not occure in the array.");
		else if(occurrence == 1)
			System.out.println("The number " +numberChoice +" occured " +occurrence +" time in the array.");
		else 
			System.out.println("The number " +numberChoice +" occured " +occurrence +" times in the array.");
	}

	public static void main(String[] args) {
		
	}

}
