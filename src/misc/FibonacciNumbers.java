package misc;

public class FibonacciNumbers {

	public static void main(String[] args) {
		
		
		for(int i = 0; i < 100; i++) {
			
			System.out.println("(" + i + ") " + getFibonacciNumber(i) + " ");
		}

	}
	
	private static long[] results = new long[100];
	
	public static long getFibonacciNumber(int index) {
		
		if(index < 0 || index > 100) throw new Error("Unsupported for number " + index);
		
		return getFibonacciNumberRecursive(index, results);
	}
	
	private static long getFibonacciNumberRecursive(int index, long[] results) {
		
		if(index == 0 || index == 1) {
			
			return 1;
		
		} else if(results[index] != 0) {
			
			return results[index];
			
		} else { 
			
			long result = getFibonacciNumber(index - 1) + getFibonacciNumber(index - 2);
			
			results[index] = result;
			
			return result;
		}
	}

}
