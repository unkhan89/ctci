package misc;

public class PrimeNumbers {

	public static void main(String[] args) {
		
		int[] numbers = {-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		
		for(int i : numbers) {
			System.out.println("Is " + i + " prime? " + isPrimeBrute(i));
		}

	}
	
	// Brute force: 
	//
	public static boolean isPrimeBrute(int x) {
		
		if(x < 2) return false;
		
		for(int i = 2; i < x; i++) 
			
			if( x % i == 0 ) return false;
		
		return true;
	}

}
