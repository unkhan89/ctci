package ctci.ch9Recursion;

import util.Util;

import java.util.HashMap;

public class P5 {

	public static void main(String[] args) {
		
		/*
		 * Given a string, return all of its permutations.
		 */
		
		String input = "abcd";
		
		for(String output : permutations(input)) {
		
			System.out.println(output);
		}
	}
	
	public static String[] permutations(String s) {
		
		HashMap<String, String[]> results = new HashMap<>();
		
		return findPermutations(s, results);
	}
	
	
	private static String[] findPermutations(String s, HashMap<String, String[]> results) {
		
		if(s.length() == 1) return new String[] {s};
		
		if(results.containsKey(s)) {
			
			return results.get(s);
		}
		
		String[] ret = new String[Util.factorial(s.length())];
		
		int k = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			StringBuilder remaining = new StringBuilder("");
			
			int skip = i;
			
			for(int j = 0; j < s.length(); j++) {
				
				if(j != skip) {
					
					remaining.append(s.charAt(j));
				}
			}
			
			String[] subPermutations = findPermutations(remaining.toString(), results);
			
			for(String subPermutation : subPermutations) {
				
				ret[k] = s.charAt(skip) + subPermutation;
				
				k++;
			}
			
			skip++;
		}
		
		results.put(s, ret);
		
		return ret;
	}
}
