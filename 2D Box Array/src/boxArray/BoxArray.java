package boxArray;

public class BoxArray {

	public static void main(String[] args) {

		final int rowLength = 20, columnLength = 20;
		int [][] boxAr = new int [rowLength][columnLength];
		int [] boxSum = new int [324];
		//int rowIndex = 0, columnIndex = 0;
		//boolean rowFull = false;
		
		for(int row = 0; row < rowLength; row++) {
			for(int column = 0; column < columnLength; column++)
				boxAr[row][column] = (int)(Math.random()*100+1);
		}
		
		//Print 2-D Matrix
		for(int row = 0; row < rowLength; row++) {
			for(int column = 0; column < columnLength; column++) {
				if(boxAr[row][column] > 99) 
				//Outputs spaces after the number according to its number of digits so that the numbers are aligned
					System.out.print(boxAr[row][column] +" ");
				else if(boxAr[row][column] > 9)
					System.out.print(boxAr[row][column] +"  ");
				else 
					System.out.print(boxAr[row][column] +"   ");
			}
			System.out.println();
		}
		
		//Make 3x3 sums
		int index = 0;
		for(int r = 0; r < 18; r++) {
			for(int c = 0; c < 18; c++) {
				for(int ri = 0; ri < 3; ri++) { //Moves up two rows from the reference point
					for(int ci = 0; ci < 3; ci++) { //Moves up two columns from the reference point
						boxSum[index] = boxSum[index] + boxAr[r + ri][c + ci];
					}
				}
			index++;
			}
		}
		
		//Print boxSum
		/*for(int x = 0; x < 324; x++) {
			System.out.println(x +" " +boxSum[x] +", ");
		}*/
			
		//Determines the greatest sum 
		int refIndex = 0;
		int greatestSum = boxSum[0];
		for(int i = 0; i < boxSum.length; i++)
		{
			if(boxSum[i] > greatestSum)
			{
				refIndex = i;
				greatestSum = boxSum[i];
			}
		}
		
		//Outputs the greatest sum with its indexes
		System.out.println();
		System.out.println("The greatest sum is " +greatestSum +" which is found at rows " +refIndex/18 +" to " +(refIndex/18 + 3) +" and columns " +refIndex%18 +" to " +(refIndex%18 + 3) +".");
		
		//Other way to print Matrix
		/*for(int[] row : boxAr)
			System.out.println(Arrays.toString(row));*/
		
	}

}
