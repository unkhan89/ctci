package sorting;

public class HeapSort {
	
	
	public static Integer[] sort(Integer[] nums) {
		
		// build heap:
		
		dataStructures.MaxHeap heap = new dataStructures.MaxHeap(nums);
		
		nums = heap.getElements();
		
		// sort:
		
		for(int i = nums.length-1; i > 0; i--) {
			
			// swap largest value (at index 0) with the last value in the non sorted array (denoted by i)
			
			swap(nums, 0, i);
			
			// value at 0 violates max heap property,
			// keep swapping value at index 0 with children (up to i-1, aka the unsorted portion 
			// of the heap) until heap property is met:
			
			int parentIndex = 0;
			
			while(true) {
				
				// see which is the larger child, if either:
				
				int lci = getLeftChildIndex(parentIndex);
				
				int rci = getRightChildIndex(parentIndex);
				
				if(rci <= i-1) {	// compare against both children
					
					if(nums[lci] > nums[parentIndex] && nums[lci] >= nums[rci]) {
						
						// swap with left child:
						
						swap(nums, parentIndex, lci);
						
						parentIndex = lci;
					
					} else if(nums[rci] > nums[parentIndex] && nums[rci] >= nums[lci]) {
						
						// swap with right child:
						
						swap(nums, parentIndex, rci);
						
						parentIndex = rci;
						
					} else {
						
						// heap property met
						
						break;
					}
				
				} else if(lci <= i - 1) {	// compare against left child only
					
					if(nums[lci] > nums[parentIndex]) {
						
						swap(nums, parentIndex, lci);
						
						parentIndex = lci;
					
					} else { 	// heap property met
						
						break;
					}
					
				} else {	// heap property met
					
					break;
				}
			}
		}
		
		return nums;
	}
	
	private static void swap(Integer[] nums, int i, int j) {
		
		int temp = nums[i];
		
		nums[i] = nums[j];
		
		nums[j] = temp;
	}
	
	private static int getLeftChildIndex(int parentIndex) {
		
		return 2 * parentIndex + 1;
	}
	
	private static int getRightChildIndex(int parentIndex) {
		
		return 2 * parentIndex + 2;
	}
}
