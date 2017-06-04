
import java.util.Arrays;

import sorting.*;

public class TestSorting {

    public static void main(String[] args) {

        int[][] arraysOfNumbers = {
//    		{5, 0, 2, -1, 9, 0, 0},
            {2, 79, 3, 614, 51, 1, 10, 826, 51, 95, 40},
//            {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2},
//            {4, 3, -5, 1, 0, 4},
            {2},
            {}
        };

        for(int[] ary : arraysOfNumbers) {

            System.out.println("Sorted array: " + Arrays.toString(sort(ary)));
            
      }    	
    }

    static int[] sort(int[] nums) {

        // return InsertionSort.sort(nums);

        // return BubbleSort.sort(nums);

        // return MergeSort.sort(nums);
    	
    	 return RadixSort.sort(nums);
    	
//    	return QuickSort.sortNumbers(nums, 0, nums.length-1);
    }
}
