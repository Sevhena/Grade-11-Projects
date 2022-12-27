import java.util.Scanner;

public class RotatingSign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		char letter;
		//int charChoice = 0;
		boolean invalid = false;
		
		System.out.print("Please enter a word with a maximum of 30 letters: ");
		String word = input.next();
		input.close();
		
		int length = word.length();
		
		do
		{
			letter = word.charAt(length - 1);
			if(letter != 'I' || letter != 'S' || letter != 'X' || letter != 'N' || letter != 'O' || letter != 'H' || letter != 'Z')
			{
				invalid = true;
			}
			length--;
			
		}while(length >= 0);
		
		if(invalid)
			System.out.println("NO");
		else 
			System.out.println("YES");
		
		/*for(int nbChar = length; nbChar > 0; nbChar --) {
			
		}*/
		
		

	}

}
