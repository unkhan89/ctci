package ctci.ch1ArraysAndStrings;

public class P7 {

	public static void main(String[] args) {
		
		/*
		 * Write a method that given an MxN matrix, sets an entire column and row to 
		 * 0 if a zero is found in a cell.
		 */
		
		int[][] matrix = {
				{1, 2, 3, 4},
				{1, 2, 3, 4},
				{1, 2, 3, 4},
				{0, 2, 3, 4}
		};
		
		zeroOut(matrix);
		
		for(int[] row : matrix) {
			
			System.out.println(java.util.Arrays.toString(row));
		}

	}
	
	public static void zeroOut(int[][] matrix) {
		
		java.util.HashSet<String> skip = new java.util.HashSet<>();
		
		for(int i = 0; i < matrix.length; i++) {
			
			for(int j = 0; j < matrix[i].length; j++) {
				
				if(!skip.contains(i + "," + j)) {
					
					if(matrix[i][j] == 0) {
						
						for(int k = 0; k < matrix[i].length; k++) {
							
							matrix[i][k] = 0;
						}
						
						for(int k = 0; k < matrix.length; k++) {
							
							matrix[k][j] = 0;
							
							if(k > i) skip.add(k + "," + j);
						}
						
						break;
					}
				}
				
			}
		}
	}

}
