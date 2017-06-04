package sorting;

public class QuickSort {
	
	public static char[] sortChars(char[] chars, int startIndex, int endIndex) {
		
		if(startIndex >= endIndex) {	// base case
			
			return chars;
		}
		
		int pivot = endIndex;		// NOTE: pivot is an index, not value
		
		int left = startIndex;
				
		int right = pivot - 1;
		
		// keep swapping while left and right indices are equal (iow meet each other):
		
		while(left != right) {		// "partition" 
			
			// find a value greater than pivot:
			
			while(chars[left] < chars[pivot] && left < right) {
				
				left++;		// keep incrementing index until left value is greater than pivot value			
			}
			
			// find a value less than pivot:
			
			while(chars[right] >= chars[pivot] && right > left) {
				
				right--;	// keep decrementing index until right value is less or equal to pivot value
			}
			
			// swap left and right values: 
			
			char temp = chars[left];
			
			chars[left] = chars[right];
			
			chars[right] = temp;			
		}
		
		// check if left=right index needs to be swapped with pivot:
		
		if(chars[pivot] < chars[left]) {
			
			char temp = chars[left];
			
			chars[left] = chars[pivot];
			
			chars[pivot] = temp;
		}
		
		// recursively call function per new boundaries:
		
		sortChars(chars, startIndex, left);
		
		sortChars(chars, left + 1, endIndex);
		
		return chars;
	}
	
	
	
	public static int[] sortNumbers(int[] nums, int startIndex, int endIndex) {
		
		if(startIndex >= endIndex) {	// base case
			
			return nums;
		}
		
		int pivot = endIndex;		// NOTE: pivot is an index, not value
		
		int left = startIndex;
				
		int right = pivot - 1;
		
		// keep swapping while left and right indices are equal (iow meet each other):
		
		while(left != right) {		// "partition" 
			
			// find a value greater than pivot:
			
			while(nums[left] < nums[pivot] && left < right) {
				
				left++;		// keep incrementing index until left value is greater than pivot value			
			}
			
			// find a value less than pivot:
			
			while(nums[right] >= nums[pivot] && right > left) {
				
				right--;	// keep decrementing index until right value is less or equal to pivot value
			}
			
			// swap left and right values: 
			
			int temp = nums[left];
			
			nums[left] = nums[right];
			
			nums[right] = temp;			
		}
		
		// check if left=right index needs to be swapped with pivot:
		
		if(nums[pivot] < nums[left]) {
			
			int temp = nums[left];
			
			nums[left] = nums[pivot];
			
			nums[pivot] = temp;
		}
		
		// recursively call function per new boundaries:
		
		sortNumbers(nums, startIndex, left);
		
		sortNumbers(nums, left + 1, endIndex);
		
		return nums;
	}
}
