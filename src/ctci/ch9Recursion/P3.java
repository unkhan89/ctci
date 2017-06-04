package ctci.ch9Recursion;

public class P3 {

	public static void main(String[] args) {
		
		/*
		 * A magic index in an array is defined to be an index such that A[index] = index.
		 * Given a sort array of distinct integers, write a method to find the magic index, if one exists.
		 * 
		 * Examples:
		 * {-4, -3, 2, 4} -> 2
		 * {1, 2, 3, 4, 5} -> -1
		 * 
		 */
		
		int[] array = {-10, -7, -1, -3, 4};
		
		System.out.println(find(array, 0, array.length-1));

	}
	
	public static int find(int[] array, int startIndex, int endIndex) {
		
		if(startIndex <= endIndex) {
			
			int midIndex = (startIndex + endIndex) / 2;
			
			if(array[midIndex] == midIndex) return midIndex;
			
			if(array[midIndex] < midIndex) return find(array, midIndex + 1, endIndex);
			
			if(array[midIndex] > midIndex) return find(array, startIndex, midIndex - 1);
			
		}
			
		return -1;
	}

}
