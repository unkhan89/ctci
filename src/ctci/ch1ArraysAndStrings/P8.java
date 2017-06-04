package ctci.ch1ArraysAndStrings;

public class P8 {

	public static void main(String[] args) {
		
		/*
		 * GIven two strings, determine if one is a rotation of the other.
		 */
		
		System.out.println("Is rotation?  " + isRotation("abcae", "aeabc"));

	}
	
	public static boolean isRotation(String s1, String s2) {
		
		if(s1.length() != s2.length()) return false;
		
		for(int i = 0; i < s2.length(); i++) {
			
			if(s2.charAt(i) == s1.charAt(0)) {
				
				boolean allMatch = true;
				
				int k = i + 1;
				
				for(int j = 1; j < s1.length(); j++) {
					
					if(k == s2.length()) k = 0;
					
					if(s1.charAt(j) != s2.charAt(k)) {
						
						allMatch = false;
						break;
					}
					
					k++;
				}
				
				if(allMatch == true) return true;
			}
		}
		
		return false;
	}
}
