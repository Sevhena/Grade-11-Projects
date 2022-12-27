import myTools.MyTools;

public class RomanNumerals {
	
	public static void romanNumber(int number) {
		//Variables
		String one = "I";
		String four = "IV";
		String five = "V";
		String nine = "IX";
		String ten = "X";
		String forty = "XL";
		String fifty = "L";
		String ninety = "XC";
		String hundred = "C";
		
		//Roman numbers conversion
		if(number == 100) {
			System.out.println(hundred);
			number = number -100;
		}
		if(number >= 90) {
			System.out.print(ninety);
			number = number - 90;
		}
		else if(number >= 50 && number < 90) {
			System.out.print(fifty);
			number = number - 50;
		}
		else if(number - 40 < 10 && number - 40 >= 0) {
			number = number - 40;
			System.out.print(forty);
		}
		if(number >= 10){
			do
			{
				System.out.print(ten);
				number = number - 10;
			}while(number / 10 > 0);
		}
		if(number % 10 == 4)
			System.out.print(four);
		if(number % 10 == 9) 
			System.out.print(nine);
		else if(number % 10 >= 5 && number % 10 != 0)
			System.out.print(five);
		if((number % 10 > 0 && number % 10 <= 3) || (number % 10 > 5 && number % 10 < 9)) {
			do 
			{
				System.out.print(one);
				number--;
			}while(number % 10 != 0 && number % 5 != 0);
		}
	}

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		//Number input
		System.out.print("Welcome to the roman numeral converter. ");
		int number = MyTools.errorTrap(1, 100);
		
		romanNumber(number);
	}
}
