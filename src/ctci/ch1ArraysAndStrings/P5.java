package ctci.ch1ArraysAndStrings;

public class P5 {

	public static void main(String[] args) {
		
		/*
		 * Given a string, return a compressed string using following as example:
		 * Input:  "aabcccccdd"
		 * Output: "a2b1c5d2"
		 * 
		 * If compressed is larger than original string, return original
		 */
		
		String[] testData = {
			"aabcccccdd",
			"abc"
		};
		
		for(String s : testData) {
			
			System.out.println("Compressed " + s + " -> " + compress(s));
		}
	}
	
	static String compress(String s) {
		
		StringBuilder ret = new StringBuilder("");
		
		char current = s.charAt(0);
		
		int count = 1;
		
		for(int i = 1; i < s.length(); i++) {
			
			if(s.charAt(i) != current) {
				
				ret.append("" + current + count);
				
				current = s.charAt(i);
				
				count = 1;
			
			} else {
				
				count++;
			}
		}
		
		ret.append("" + current + count);
		
		if(ret.length() > s.length()) {
			
			return s;
		
		} else {
			
			return ret.toString();
		}
	}

}
