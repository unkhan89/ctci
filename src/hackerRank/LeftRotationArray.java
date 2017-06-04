package hackerRank;

import java.util.Scanner;

public class LeftRotationArray {
	
	public static void main(String[] args) {
		
		// gather input:
		
		Scanner input = new Scanner(System.in);
		
		String[] nextStdInLine = input.nextLine().split(" ");
		
		int inputSize = Integer.parseInt(nextStdInLine[0]);
		
		int rotations = Integer.parseInt(nextStdInLine[1]);
			
		int[] nums = new int[inputSize];
		
		for(int i = 0; i < inputSize; i++) {
			
			nums[i] = input.nextInt();
		}
		
		// perform rotations:
		
		int[] result = new int[inputSize];
		
		StringBuffer output = new StringBuffer();
		
		for(int i = 0, k = rotations; i < result.length; i++, k++) {
			
			result[i] = nums[k];
			
			output.append(result[i]);
			
			if(i != result.length - 1) {
				
				output.append(" ");
			}
			
			if(result[i] == nums[nums.length - 1]) {	// last item
				
				k = -1;
			}			
		}
		
		System.out.println(output.toString());	
		
		input.close();
	}
}
