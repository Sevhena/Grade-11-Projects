package cubeArray;

public class CubeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int arrayLength = 20, rowLength = 20, columnLength = 20;
		int[][][] cubeAr = new int [arrayLength][rowLength][columnLength];
		int[] cubeSum = new int [19440];
		int index = 0;
		
		for(int array = 0; array < arrayLength; array++) {
			for(int row = 0; row < rowLength; row++) {
				for(int column = 0; column < columnLength; column++)
					cubeAr[array][row][column] = (int)(Math.random()*100+1);
			}
		}
		
		for(int array = 0; array < arrayLength; array++) {
			for(int row = 0; row < rowLength; row++) {
				for(int column = 0; column < columnLength; column++) {
					if(cubeAr[array][row][column] > 99) //Outputs spaces after the number according to its number of digits so that the numbers are aligned
						System.out.print(cubeAr[array][row][column] +" ");
					else if(cubeAr[array][row][column] > 9)
						System.out.print(cubeAr[array][row][column] +"  ");
					else 
						System.out.print(cubeAr[array][row][column] +"   ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		//Finds 3x3 sum parallel to an array
		for(int a = 0; a < arrayLength; a++) {
			for(int r = 0; r < rowLength - 2; r++) {
				for(int c = 0; c < columnLength - 2; c++) {
					for(int ri = 0; ri < 3; ri++) { //Moves up two rows from the reference point
						for(int ci = 0; ci < 3; ci++) { //Moves up two columns from the reference point
							cubeSum[index] = cubeSum[index] + cubeAr[a][r + ri][c + ci];
						}
					}
				index++;
				}
			}
		}
		
		//Finds 3x3 sum parallel to a row
		for(int r = 0; r < rowLength; r++) {
			for(int a = 0; a < arrayLength - 2; a++) {
				for(int c = 0; c < columnLength - 2; c++) {
					for(int ai = 0; ai < 3; ai++) {//Moves up two arrays from the reference point
						for(int ci = 0; ci < 3; ci++) { //Moves up two columns from the reference point
							cubeSum[index] = cubeSum[index] + cubeAr[a + ai][r][c + ci];
						}
					}
					index++;
				}
			}
		}
		
		//Finds 3x3 sum parallel to a column
		for(int c = 0; c < columnLength; c++) {
			for(int r = 0; r < rowLength - 2; r++) {
				for(int a = 0; a < arrayLength - 2; a++) {
					for(int ri = 0; ri < 3; ri++) { //Moves up two arrays from the reference point
						for(int ai = 0; ai < 3; ai++) { //Moves up two rows from the reference point
							cubeSum[index] = cubeSum[index] + cubeAr[a + ai][r + ri][c];
						}
					}
					index++;
				}
			}
		}
		
		/*for(int x = 0; x < cubeSum.length; x++)
            System.out.print(cubeSum[x] +" ");*/
		
		//Determines greatest sum
		int refIndex = 0;
		int greatestSum = cubeSum[0];
		for(int i = 0; i < cubeSum.length; i++)
		{
			if(cubeSum[i] > greatestSum)
			{
				refIndex = i;
				greatestSum = cubeSum[i];
			}
		}
		
		//Prints greatest sum along with its indexes
		System.out.println("The greatest sum is " +greatestSum +".");
		
		if(refIndex <= 6480)
			System.out.println("It is located parallel to an array at array " +refIndex/324 +", row " +(refIndex%324)/18 +" and column " +refIndex%18 +".");
		else if(refIndex > 6480 && refIndex <= 12960) {
			refIndex -= 6480;
			System.out.println("It is located parallel to a row at array " +(refIndex%324)/18 +", row " +refIndex/324 +" and column " +refIndex%18 +".");
		}
		else {
			refIndex -= 12960;
			System.out.println("It is located parallel to a column at array " +refIndex%18 +", row " +(refIndex%324)/18 +" and column " +refIndex/324 +".");

		}
			
	}

}
