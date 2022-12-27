package numberGen;

import Toolkit.src.myTools.MyTools;

public class NumberGen {

	public static void main(String[] args) {
		
		int min = 1, max = 50;
		
		//Prompt
		System.out.println("Welcome to the randon Number Generator.");
		
		for(int counter = 0; counter < 100; counter++) {
			int number = MyTools.numberGen(min, max); //calls number
			System.out.println("The number is: " +number);
		}		
	}
}
