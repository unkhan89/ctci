package sorting;

import util.Util;

public class MergeSort {

    private static void log(String message) {

    	// System.out.println("[MergeSort] " + message);
    }
    
    public static int[] sort(int[] nums) {

        if(nums.length <= 1) {

            return nums;
        
        } else {

            // split in to halves

            int mid = nums.length / 2;

            int[] left = copy(nums, 0, mid);

            int[] right = copy(nums, mid, nums.length);
            
            left = sort(left);
            
            right = sort(right);
            
            int[] merged = merge(left, right);
            
            return merged;
            
            // Same logic as above 4 lines can be rewritten as: 
            // return merge(sort(left), sort(right));
        }
    }

    private static int[] merge(int[] left, int[] right) {

        int[] merged = new int[left.length + right.length];

        int i = 0, j = 0;

        for(int k = 0; k < merged.length; k++) {

            // figure out which num should go into k'th position in merged array

            if(i >= left.length) {      // no more elements in left array

                merged[k] = right[j];

                j++;

            } else if(j >= right.length) {  // no more elements left in right array

                merged[k] = left[i];

                i++;
            
            } else {        // find next smallest element to insert from left and right arrays

                if(left[i] < right[j]) {

                    merged[k] = left[i];

                    i++;
                
                } else {

                    merged[k] = right[j];

                    j++;
                }
            }
        }

        return merged;
    }

    private static int[] copy(int[] original, int startIndex, int endIndex) {

        int[] ret = new int[endIndex - startIndex];

        for(int k = 0, i = startIndex; i < endIndex; k++, i++) {

            ret[k] = original[i];
        }

        log("copy() original: " + (Util.arrayToString(original)) + ", startIndex: " +
            startIndex + ", endIndex: " + endIndex + ", returning: " + Util.arrayToString(ret));

        return ret;
    }
}