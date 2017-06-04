package sorting;

import dataStructures.SinglyLinkedList;
import util.Util;

public class RadixSort {
	
	private static void log(String msg) {
		
		//System.out.println("[RadixSort] " + msg);
	}
	
	public static int[] sort(int[] nums) {
		
		log("RadixSort() nums: " + Util.arrayToString(nums));
		
		int k = 0;
		
		SinglyLinkedList[] buckets;
		
		while(true) {
			
			// place numbers into buckets:
			
			buckets = new SinglyLinkedList[10];
			
			for(int i = 0; i < nums.length; i++) {
				
				if(nums[i] < 0) {
					
					throw new Error("Negative numbers not currently supported");
				}
				
				int bucketIndex = getIntAtDigitIndex(nums[i], k);
				
				log("Number " + nums[i] + " goes into bucket " + bucketIndex);
				
				log("After finding bucket to add to, nums: " + Util.arrayToString(nums));
				
				if(buckets[bucketIndex] == null) {	// initialize a bucket if not there
					
					buckets[bucketIndex] = new SinglyLinkedList(nums[i]);
				
				} else {
					
					buckets[bucketIndex].add(nums[i]);
				}
			}
			
			// collect them from the buckets, and track if they're sorted:
			
			boolean isSorted = true; 	// assuming true until known otherwise 	
			
			int numsIndex = 0; 			// for tracking nums
			
			for(int bucketsIndex = 0; bucketsIndex < buckets.length; bucketsIndex++) {
				
				log("Looking at bucket " + bucketsIndex + " ... ");
				
				if(buckets[bucketsIndex] != null) {			// if we actually have numbers in the bucket
					
					// iterate through bucket and add to nums array:
					
					for(int bucketIndex = 0; bucketIndex < buckets[bucketsIndex].size(); bucketIndex++) {
						
						int nextInt = (int) buckets[bucketsIndex].get(bucketIndex).getValue();
						
						log("Setting in nums: " + nextInt + " in index " + numsIndex);
						
						nums[numsIndex] = nextInt;
						
						log("... after adding: " + Util.arrayToString(nums));
						
						// don't bother checking if we already know this iteration that its not sorted:
						
						if(isSorted == true) {
							
							if(isSortedSoFar(nums, numsIndex) == false) {	
							
								isSorted = false;
							}
						}
						
						numsIndex++;
					}
					
				} else {
					
					log("Bucket " + bucketsIndex + " is empty");
				}
			}
			
			log("Nums after k=" + k + " iterations: " + Util.arrayToString(nums));
			
			// check if list is sorted, otherwise increase k factor and repeat
			
			if(isSorted == true) {
				
				break;
			
			} else {
				
				k++;
			}			
		}
		
		return nums;
	}
	
	private static int getIntAtDigitIndex(int num, int digitIndex) {
		
		log("getIntAtDigitIndex() num = " + num + ", digitIndex = " + digitIndex);
		
		String numStr = Integer.toString(num);
		
		if(digitIndex > numStr.length()-1) {
			
			return 0;
		}
		
		String numReversedStr = "";
		
		for(int i = numStr.length() - 1; i >= 0; i--) {
			
			numReversedStr += numStr.charAt(i);
		}
		
		return Integer.parseInt(numReversedStr.substring(digitIndex, digitIndex+1));
	}
	
	private static boolean isSortedSoFar(int[] nums, int index) {
		
		boolean isSorted = true;
		
		if(index >= 1) {
			
			if(nums[index-1] > nums[index]) {
			
				return false;
			}
		}
			
		return isSorted;				
	}
}
