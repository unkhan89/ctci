package hackerRank;

import java.util.Scanner;

public class ArraysDS {

    public static void main(String[] args) {

    	Scanner input = new Scanner(System.in);
    	
    	int numberOfIntegers = Integer.parseInt(input.nextLine());
    	
    	String numbersLine = input.nextLine();
    	
    	String[] numbers = numbersLine.split(" ");
        
        for(int i = numberOfIntegers - 1; i >= 0; i--) {
        	
        	System.out.print(numbers[i]);
        	
        	if(i != 0) {
        		
        		System.out.print(" ");
        	}
        }
        
        input.close();
    }
}


