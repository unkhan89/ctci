package ctci.ch9Recursion;

public class P1 {

	public static void main(String[] args) {
		
		/*
		 * A child is running up n steps and can take either 1, 2, or 3 steps at a time.
		 * How many different ways can the child reach the top?
		 * 
		 * Example: If there are 3 steps, child can either take 1111, 12, 21, or 3, thus 4 total.
		 * 
		 */
		
		System.out.println(count(1));
		System.out.println(count(2));
		System.out.println(count(3));
		System.out.println(count(4));
		System.out.println(count(5));
		System.out.println(count(6));
		System.out.println(count(7));
	}
	
	public static int count(int n ) {
		
		if(n <= 0) return 0;
		
		if(n == 1) return 1;
		
		if(n == 2) return 2;
		
		if(n == 3) return 4;
		
		return count(n - 1) + count(n - 2) + count(n - 3);
	}

}
