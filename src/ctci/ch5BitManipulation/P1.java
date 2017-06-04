package ctci.ch5BitManipulation;

public class P1 {

	public static void main(String[] args) {
		
		/**
		 * Given 2 32 bit integers n and m, write a function that fits m into n between given indexes i and j. 
		 * Example:
		 * Input  -> n = 10000000000, m = 10011, i = 2, j = 6
		 * Output ->     10001001100
		 */
		
		System.out.println(Integer.toBinaryString(fit(0b10000000000, 0b10011, 2, 6)));

	}
	
	public static int fit(int n, int m, int i, int j) {
		
		int mIndex = 0;
		
		while(i <= j) {
			
			if(getIthBit(n, i) != getIthBit(m, mIndex)) {
				
				n = toggle(n, i);
			}
			
			mIndex++;
			
			i++;
		}
		
		return n;
	}
	
	private static byte getIthBit(int a, int i) {
		
		int mask = 1 << i;
		
		int result = a & mask;
		
		return (byte) (result == 0 ? 0 : 1);
	}

	private static int toggle(int a, int i) {
		
		int mask = 1 << i;
		
		return a ^ mask;
	}
}
