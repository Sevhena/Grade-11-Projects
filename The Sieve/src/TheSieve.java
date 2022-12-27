import Toolkit.src.myTools.MyTools;

public class TheSieve {

	public static void main(String[] args) {

		final int SIZE = 200000;
		int[] list = new int[SIZE];
		int timesOccurred = 0;
		//int[] list = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,23,24,25}; //Test array
		
		list = MyTools.initializeSortedAr(list);
		
		for(int x = 1; x < SIZE-1; x++) {
			if(list[x] == 0)
				continue;
			for(int y = x + 1; y < SIZE; y++) {
				if(list[y] % list[x] == 0) //Checks if y is perfectly divisible by x
					list[y] = 0;
			}
		}
		
		for(int i = 0; i < SIZE; i++) {
			if(list[i] != 0) {
				System.out.print(list[i] +" ");
				timesOccurred++;
				if(timesOccurred % 500 == 0)
					System.out.println();
			}
		}
	}

}
