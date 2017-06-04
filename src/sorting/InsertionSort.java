package sorting;

public class InsertionSort {
	
	public static int[] sort(int[] nums) {

		int count = 0;
		
		for(int i = 1; i < nums.length; i++) {
			
			if(nums[i] >= nums[i-1]) {	
				
				continue;		// integer at index is already in correct/sorted position
			
			} else {
				
				int j = i - 1; 
				
				while(j >= 0) {

	                System.out.println("Execution #" + count + " (i=" + i + ", j=" + j + ")");
				    count++;
					
					int temp = nums[j+1];
					
					if(nums[j] > temp) {
						
						nums[j+1] = nums[j];
						
						nums[j] = temp;							
					}
					
					j--;
				}
			}
		}

	    System.out.println("Constant time logic executed " + count + " times for Insertion Sort");
		
		return nums;
	}
}
