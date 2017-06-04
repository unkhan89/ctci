package spotify;

import java.util.Scanner;

public class ReverseBinary {

	public static void main(String[] args) {
		
		/*
			Your task will be to write a program for reversing numbers in binary. For instance, the binary representation of 13 is 1101, and reversing it gives 1011, which corresponds to number 11.
			Input
			
			The input contains a single line with an integer N, 1 ≤ N ≤ 1000000000.
			Output
			
			Output one line with one integer, the number we get by reversing the binary representation of N.
			Sample input 1
			13
			Sample output 1
			11
			Sample input 2
			47
			Sample output 2
			61
		 */
		
		Scanner input = new Scanner(System.in);
		
		System.out.println(reverseBinary(Integer.parseInt(input.nextLine())));
	}
	
	public static int reverseBinary(int n) {
		
		String binary = toBinary(n);
		
		StringBuilder reversed = new StringBuilder("");
		
		for(int i = binary.length() - 1; i >= 0; i--) {
			
			reversed.append(binary.charAt(i));
		}
		
		return binaryToInt(reversed.toString());
	}
	
	
	public static int binaryToInt(String binary) {
		
		int sum = 0;
		
		for(int i = binary.length() - 1, exponent = 0; i >= 0; i--, exponent++) {
			
			if(binary.charAt(i) == '1') {
				
				sum += Math.pow(2, exponent);
			}
		}
		
		return sum;
	}
	
	public static String toBinary(int n) {
		
		int exponent = 0;
		
		while(Math.pow(2, exponent) <= n) {
			
			exponent++;
		}
		
		StringBuilder binary = new StringBuilder("");
		
		for(int e = exponent - 1; e > -1; e--) {
			
			if(Math.pow(2, e) <= n) {
				
				binary.append("1");
				
				n -= Math.pow(2, e);
				
			} else {
				
				binary.append("0");
			}	
		}
		
		return binary.toString();
	}
}
