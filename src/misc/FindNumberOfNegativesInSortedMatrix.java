package misc;

public class FindNumberOfNegativesInSortedMatrix {

	public static void main(String[] args) {
		
		/*
		 * Given a sorted MxN matrix, find the number of negative numbers.
		 */
		
		int[][] numbers = {
			{-111, -19, -18, -15, -14},
			{-13, -12, -11, -10, -9}, 
			{-8, -5, -4, 0, 8},
			{9, 11, 13, 14, 15},
			{29, 45}
		};
		
		System.out.println(find(numbers));
	}
	
	
	public static int find(int[][] matrix) {
		
		if(matrix.length == 0) return 0;
		
		if(matrix[0][0] >= 0) return 0;
		
		if(matrix.length == 1) {
			
			return indexOfLargestNegative(matrix[0]) + 1;
		}
		
		// find column containing first negative number:
		
		int rowWithLargestNegative = -1, startIndex = 0, endIndex = matrix.length -1;
		
		while(startIndex >= 0 && endIndex <= matrix.length - 1 && startIndex <= endIndex) {
			
			int midIndex = (startIndex + endIndex) / 2;
			
			if(midIndex - 1 >= 0 && midIndex + 1 <= matrix.length - 1) {	// mid is somewhere in middle
				
				if(matrix[midIndex][0] >= 0) {	// mid is positive
					
					if(matrix[midIndex - 1][0] < 0) rowWithLargestNegative = midIndex - 1;
					
					endIndex = midIndex - 1;	// keep looking to left
					continue;
				
				} else {	// mid is negative
					
					if(matrix[midIndex + 1][0] >= 0) rowWithLargestNegative = midIndex;
					
					startIndex = midIndex + 1;	// keep looking right
					continue;
				}
				
			}
			
			if(midIndex == 0) {		// mid is first number in array
				
				if(matrix[midIndex][0] < 0 && matrix[midIndex + 1][0] >= 0) rowWithLargestNegative = midIndex;
				
				startIndex = midIndex + 1;	// keep looking right, one more number to check? 
				continue;
			}
				
			if(midIndex == matrix.length - 1) {		// mid is last number in array
				
				if(matrix[midIndex][0] < 0) rowWithLargestNegative = midIndex;
				if(matrix[midIndex][0] >= 0 && matrix[midIndex -1][0] < 0) rowWithLargestNegative = midIndex - 1;
				
				endIndex = midIndex - 1;	// keep looking to left
				continue;
			}
		}
		
		int width = matrix[0].length;
		
		int negativeCount = width * rowWithLargestNegative;
		
		return negativeCount + (indexOfLargestNegative(matrix[rowWithLargestNegative]) + 1);
	}
	

	public static int indexOfLargestNegative(int[] numbers) {
		
		int startIndex = 0, endIndex = numbers.length - 1;
		
		while(startIndex >= 0 && endIndex <= numbers.length - 1 && startIndex <= endIndex) {
			
			int midIndex = (startIndex + endIndex) / 2;
			
			if(midIndex - 1 >= 0 && midIndex + 1 <= numbers.length - 1) {	// mid is somewhere in middle
				
				if(numbers[midIndex] >= 0) {	// mid is positive
					
					if(numbers[midIndex - 1] < 0) return midIndex - 1;
					
					endIndex = midIndex - 1;	// keep looking to left
					continue;
				
				} else {	// mid is negative
					
					if(numbers[midIndex + 1] >= 0) return midIndex;
					
					startIndex = midIndex + 1;	// keep looking right
					continue;
				}
				
			}
			
			if(midIndex == 0) {		// mid is first number in array
				
				if(numbers[midIndex] < 0 && numbers[midIndex + 1] >= 0) return midIndex;
				
				startIndex = midIndex + 1;	// keep looking right, one more number to check? 
				continue;
			}
				
			if(midIndex == numbers.length - 1) {		// mid is last number in array
				
				if(numbers[midIndex] < 0) return midIndex;
				if(numbers[midIndex] >= 0 && numbers[midIndex -1] < 0) return midIndex - 1;
				
				endIndex = midIndex - 1;	// keep looking to left
				continue;
			}
		}
		
		return -1; 	// not found
	}

}
