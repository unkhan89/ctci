/*
 * https://www.hackerrank.com/challenges/2d-array
 */

package hackerRank;

import java.util.Scanner;

public class D2ArrayDS {
	
	public static void main(String[] args) {
		
		// using static data from now, TODO: read from standard input
//		int[][] nums = {
//			{1, 1, 1, 0, 0, 0},
//			{0, 1, 0, 0, 0, 0},
//			{1, 1, 1, 0, 0, 0},
//			{0, 0, 2, 4, 4, 0},
//			{0, 0, 0, 2, 0, 0},
//			{0, 0, 1, 2, 4, 0}	
//		};
		
		int[][] nums = new int[6][6];
		
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < 6; i++) {
			
			String[] numbersLine = input.nextLine().split(" ");
	    	
			for(int j = 0; j < 6; j++) {
				
				nums[i][j] = Integer.parseInt(numbersLine[j]);
			}
		}
    	
    	
		System.out.println(maxSumHourGlass(nums));
	}
	
	static int maxSumHourGlass(int[][] nums) {
		
		int[] sums = new int[16];
		
		int k = 0;
		
		for(int i = 0; i <= 5; i++) {
			
			for(int j = 0; j <= 5; j++) {
			
				if(j+2 <= 5 &&	i+2 <=5) {	// valid hour glass
					
					sums[k] = nums[i][j]   + nums[i][j+1]   + nums[i][j+2]
							               + nums[i+1][j+1]
							+ nums[i+2][j] + nums[i+2][j+1] + nums[i+2][j+2];
					k++;
				}
			}
		}
		
		int maxSum = sums[0];
		
		for(int i = 1; i < sums.length; i++) {
			
			if(sums[i] > maxSum) {
				
				maxSum = sums[i];
			}
		}
		
		return maxSum;
	}
}
