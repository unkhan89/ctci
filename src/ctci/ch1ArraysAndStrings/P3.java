package ctci.ch1ArraysAndStrings;

import java.util.HashMap;

public class P3 {
	
	public static void main(String[] args) {
		
		/*
		 * Write a method to determine if one string is a permutation of another.
		 */
		
		String[][] testData = {
				{"abc", "abcd"},
				{"abc", "abd"},
				{"abc", "abb"},
				{"abc", "cba"}
		};
		
		for(String[] strings : testData) {
			
			System.out.println("Is \"" + strings[0] + "\" a permutation of \"" + strings[1] + "\"? " 
					+ isPermutation3(strings[0], strings[1]));
		}
		
	}
	
	
	// compare character counts:
	
	static boolean isPermutation3(String s1, String s2) {
		
		if(s1.length() != s2.length()) return false;
		
		HashMap<Character, Integer> charCountA = new HashMap<>();
		
		for(int i = 0; i < s1.length(); i++) {
			
			if(charCountA.containsKey(s1.charAt(i))) {
				
				charCountA.put(s1.charAt(i), charCountA.get(s1.charAt(i)) + 1);
			
			} else {
				
				charCountA.put(s1.charAt(i), 1);				
			}
		}
		
		HashMap<Character, Integer> charCountB = new HashMap<>();
		
		for(int i = 0; i < s2.length(); i++) {
			
			if(charCountB.containsKey(s2.charAt(i))) {
				
				charCountB.put(s2.charAt(i), charCountB.get(s2.charAt(i)) + 1);
			
			} else {
				
				charCountB.put(s2.charAt(i), 1);				
			}
		}
		
		if(charCountA.size() != charCountB.size()) return false;
		
		java.util.Set<Character> keys = charCountA.keySet();
		
		for(char c : keys) {
			
			if(!charCountB.containsKey(c)) return false;
			
			if(charCountA.get(c) != charCountB.get(c)) return false;
		}
		
		return true;
	}
	
	
	// sort two strings and compare, simple but not efficient, time and space depend on sorting algorithm used
	
	static boolean isPermutation2(String s1, String s2) {
		
		if(s1.length() != s2.length()) return false;
		
		s1 = new String(sorting.QuickSort.sortChars(s1.toCharArray(), 0, s1.length() -1));
		
		s2 = new String(sorting.QuickSort.sortChars(s2.toCharArray(), 0, s2.length() -1));
		
		return s1.equals(s2);
	}
	
	
	// using brute force, find each char in string a in string b, while sorting b, O(n^2) time O(1) space:
	
	static boolean isPermutation1(String s1, String s2) {
		
		String a = s1;
		
		StringBuilder b = new StringBuilder(s2);
		
		if(a.length() != b.length()) return false;
		
		int k = 0;
		
		for(int i = 0; i < a.length(); i++) {
			
			boolean isFound = false;
			
			for(int j = k; j < b.length(); j++) {
				
				if(a.charAt(i) == b.charAt(j)) {
					
					char temp = b.charAt(k);
					
					b.setCharAt(k, b.charAt(j));
					
					b.setCharAt(j, temp);
					
					k++;
					
					isFound = true;
					
					break;
				}
			}
			
			if(!isFound) {
			
				return false;
			}
		}
		
		return true;
	}
}
