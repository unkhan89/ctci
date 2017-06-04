package ctci.ch1ArraysAndStrings;

import java.util.*;

public class P1 {

	public static void main(String[] args) {
		
		/*
		 * Implement an algorithm to check if a string has all unique chars. What if you can't use another data structure?
		 */
		
		String[] testData = {
			"abc",
			"abca"
		};
		
		for(String s : testData) {
			
			System.out.println("\"" + s + "\" has all unique? " + hasUniqueChars3(s));
		}
	}
	
	// using an array, assuming only ASCII chars are included, O(n) time and O(1) space
	
	static boolean hasUniqueChars3(String s) {
		
		if(s.length() > 128) return false;
		
		boolean[] chars = new boolean[128];	// all values are false by default
		
		for(int i = 0; i < s.length(); i++) {
			
			if(chars[(int)s.charAt(i)] == true) {
				
				return false;
			
			} else {
				
				chars[(int)s.charAt(i)] = true;
			}
		}
		
		return true;
	}
	
	
	// brute force, using multiple iterations on input string, O(n^2) time and O(1) space
	
	static boolean hasUniqueChars2(String s) {
		
		for(int i = 0; i < s.length(); i++) {
			
			int thisChar = s.charAt(i);
			
			for(int j = 0; j < s.length(); j++) {
				
				if(j != i) {
					
					if(thisChar == s.charAt(j)) {
						
						return false;
					}
				}
			}
		}
		
		return true;
	}	

	
	// using data structure "Set", O(n) time and O(n) space
	
	static boolean hasUniqueChars1(String s) {
		
		Set<Character> chars = new HashSet<>();
		
		for(int i = 0; i < s.length(); i++) {
			
			if(chars.contains(s.charAt(i)) == true) {
				
				return false;
			
			} else {
				
				chars.add(s.charAt(i));
			}
		}
		
		return true;
	}
}
