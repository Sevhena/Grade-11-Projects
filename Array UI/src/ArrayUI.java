import java.util.Scanner;

import Toolkit.src.myTools.MyTools;

public class ArrayUI {
	
	public static void numberSwap(Scanner input, int[] array) //Swaps out the first number with the second
	{
		int oldNumber = 0, newNumber = 0;
		//Outputs array for user 
		System.out.println("Original Array");
		for(int x = 0; x < array.length; x++)
            System.out.print(array[x] +" ");
		
		System.out.println();
		//Asks user which number they would like to replace
		System.out.println("Which number would you like to replace?");
		oldNumber = MyTools.errorTrap(input,1, array.length);
		
		//Asks user which number they would like to substitute in
		System.out.println("Which number would you like to replace it with?");
		newNumber = MyTools.errorTrap(input);
		
		//Swaps all the old numbers with the new one
		for (int x = 0; x < array.length; x++) {
			if(array[x] == oldNumber) {
				array[x] = newNumber;
			}
		}
		//Prints the new array
		for(int x = 0; x < array.length; x++)
            System.out.print(array[x] +" ");
	}

	public static void indexSum(int[] array) //10 consecutive indexes with the greatest sum
	{
		int[] sum = new int[array.length-10];
		int indexTen = 0, sumTen = 0, tenSlot = 0, x = 0;
		int firstIndex = 0, greatestSum = 0;
		
		//The sum of an array with only ten indexes
		if(array.length == 10) {
			for(int i = 0; i < array.length; i++) {
				greatestSum = greatestSum + array[i];
			}
			firstIndex = 0;
		}
		//Message when an array doesn't have 10 indexes
		else if(array.length < 10) {
			System.out.println("The array does not have 10 indexes.");
		}
		//Every other array
		else {
			while(x < array.length) {
				//Adds ten consecutive indexes the make up 
				//the first index in the sum array
				do 
				{
					//After having added ten numbers, the next index for the
					//sum array is filled. The amount of slots(10) an index has
					//is reset as well as the variable(sumTen) that holds the sum
					if(tenSlot == 10) {
						tenSlot = 0;
						sum[indexTen] = sumTen;
						indexTen++;
						x = indexTen;
						sumTen = 0;
					}
					sumTen = sumTen + array[x];
					tenSlot++;
					x++;
				}while(tenSlot < 10);
			}
			greatestSum = sum[0];
			//Compares numbers in the sum array to find the biggest sum
			for(int i = 0; i < array.length-10; i++)
			{
				if(sum[i] > greatestSum)
				{
					greatestSum = sum[i];
					firstIndex = i; // The index of the sum in the sum array is the fist index 
					//of the set of 10 consecutive numbers in the original array
				}
			}
		}
		
		if(array.length >= 10) {
			System.out.println();
			System.out.println("The greatest sum is " +greatestSum +" which comes from indexes " +firstIndex +" to " +(firstIndex + 9) +"." );
		}
	}
	
	public static void main(String[] args)throws Exception {
		
		Scanner input = new Scanner(System.in);
		//int[] array = {1,2,3,4,5,6,7,8,9,10}; //Test Array
		final int SIZE = 100;
		int[] array = new int [SIZE];
		int userChoice = 0;
		
		do {
			System.out.println("\nWelcome to the The Array.");
			System.out.println("What would you like to do?");
			System.out.println("0.\tExit the program.");
			System.out.println("1.\tPopulate the array randomly.");
			System.out.println("2.\tPopulate the array sequentially from 1 to 100.");
			System.out.println("3.\tShuffle the Array.");
			System.out.println("4.\tFind number in array.");
			System.out.println("5.\tChecks if array is in ascending order.");
			System.out.println("6.\tShuffles until in ascending order.");
			System.out.println("7.\tLowest value finder.");
			System.out.println("8.\tFinds Highest value.");
			System.out.println("9.\tFinds the number of occurrences of a number.");
			System.out.println("10.\tSwaps out the first with the second.");
			System.out.println("11.\tAn algorithm that finds the section of the array with \n\tten consecutive indexes (addresses) that has the greatest sum.\n");
			
			userChoice = MyTools.errorTrap(input, 0, 12);
			
			if(userChoice == 1) { //Populates Randomly
				 MyTools.randomArray(array);
			}    
			else if(userChoice == 2) { //Populates sequentially
				MyTools.sortedArray(array);
			}
			else if(userChoice == 3) { // Shuffle
				MyTools.shuffleArray(array);
			}
			else if(userChoice == 4) { //Find number
				MyTools.findArNumber(array);
			}
			else if(userChoice == 5) { //Checks if array is sorted
				MyTools.checksSortedAr(array);
			}
			else if(userChoice == 6) { //Shuffles until array is sorted or after 10,000 tries
				MyTools.shuffleSort(array);
			}
			else if(userChoice == 7) { //Finds Lowest number in list
				MyTools.lowestArNumber(array);
			}
			else if(userChoice == 8) { //Finds the biggest number in the list
				MyTools.greatestArNumber(array);
			}
			else if(userChoice == 9) { //Finds how many times a number occurred in the list
				MyTools.recurrentArNumber(array);
			}
			else if(userChoice == 10) { //Swaps out the first number with the second
				numberSwap(input, array);
			}
			else if(userChoice == 11) { //10 consecutive indexes with the greatest sum
				indexSum(array);
			}
			else if(userChoice == 12) {
				
				System.out.println("What number would you like to find?");
				int number = 0, index = 0;
				boolean found = false;
				number = MyTools.errorTrap(input,0,12);
				
				for(int x = 0; x < array.length; x++) {
					if(array[x] == number) {
						found = true;
						index = x;
						break;
					}
				}
				if(found)
					System.out.println("The number " +number +" is number " +index +" in the list.");
				else
					System.out.println("The number " +number +" is not in the list.");
				
			}
		}while(userChoice != 0);
			System.out.println("Goodbye!");

		input.close();
	}

}
