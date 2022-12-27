public class VoteCount {

	public static void main(String[] args) {
		
		int votes = 10, voteA = 0, voteB = 0, voteType;
		int min = 1, max = 30;
		
		System.out.println("10");
		do
		{ 
			voteType = (int) (Math.random()*(max-min+1)+min);
			
			if(voteType%2 == 0)
			{
				voteA++;
				System.out.print("A");
			}
				
			else 
			{
				voteB++;
				System.out.print("B");
			}
			votes--;

		}while(votes > 0);
		
		System.out.println();
		
		if(voteA > voteB)
			System.out.println("Singer A wins");
		else if(voteB > voteA)
			System.out.println("Singer B wins");
		else
			System.out.println("Tie");
	}

}
