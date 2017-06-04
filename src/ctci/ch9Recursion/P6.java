package ctci.ch9Recursion;

import java.util.*;

public class P6 {

	public static void main(String[] args) {
		
		/*
		 * Implement an algorithm that returns all properly opened and closed parenthesis 
		 * given a pair of n parenthesis.
		 * 
		 * Example: 
		 * Input -> 3
		 * Output -> ()()(), ((())), (()()), ()(()), (())()
		 * 
		 */
		
		System.out.println(mix(4));
	}
	
	
	public static Set<String> mix(int n) {
		
		if(n < 1) return null;
		
		if(n == 1) {
			
			Set<String> ret = new HashSet<>();
			ret.add("()");
			return ret;
		
		} else {
			
			Set<String> nMinus1Results = mix(n - 1);
			
			Set<String> ret = new HashSet<>();
			
			Iterator<String> iter = nMinus1Results.iterator();
			
			while(iter.hasNext()) {
				
				String s = iter.next();
				
				ret.add("()" + s);
				ret.add("(" + s + ")");
				ret.add(s + "()");
			}
			
			return ret;
		}
	}

}
