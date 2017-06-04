package sorting;

import java.util.*;

public class BubbleSort {

    public static int[] sort(int[] nums) {

        System.out.println("Bubble Sort for " + nums.length + " elements");

        int count = 0;

        for(int i = 0; i < nums.length - 1; i++) {

            for(int j = 0; j < nums.length - 1 - i; j++) {

                System.out.println("Execution #" + count + " (i=" + i + ", j=" + j + ")");
                count++;

                if(nums[j] > nums[j+1]) {   // swap

                    int temp = nums[j+1];

                    nums[j+1] = nums[j]; 

                    nums[j] = temp;
                }
            }
        }

        System.out.println("Constant time logic executed " + count + " times for Bubble Sort");

        return nums;
    }
}
