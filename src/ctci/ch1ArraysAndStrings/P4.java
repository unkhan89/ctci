package ctci.ch1ArraysAndStrings;

public class P4 {

	public static void main(String[] args) {
		
		/*
		 * Write a method that replaces white spaces in a string with '%20'. 
		 * Assume enough space at string and true string length is given.
		 * Example:
		 * Input:  "Mr John Smith    ", 13
		 * Output: "My%20John%20Smith"
		 */
		
		String input = "Mr John Smith    ";
		
		int trueLength = 13;
		
		System.out.println(replace(input, trueLength));
	}
	
	
	// iterate on array, at each space shift remaining chars by two positions:
	
	static String replace(String str, int l) {
		
		char[] s = str.toCharArray();
		
		for(int i = 0; i < s.length; i++) {
			
			if(s[i] == ' ') {
				
				for(int j = l-1; j > i; j--) {
					
					s[j+2] = s[j];
				}
				
				s[i] = '%';
				s[i+1] = '2';
				s[i+2] = '0';
				
				i++;
				
				l = l + 2;				
			}			
		}
		
		return new String(s);
	}	
}
