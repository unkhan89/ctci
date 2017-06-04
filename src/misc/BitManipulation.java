package misc;

public class BitManipulation {

	public static void main(String[] args) {
		
		// arithmetic (and logical) left shifting:
		
		System.out.println( 10 << 1 );	// by 1, multiply by 2^1
	
		System.out.println( -10 << 2 );	// by 2, multiply by 2^2
		
		System.out.println( 10 << 3 );	// by 3, multiply by 2^3
		
		
		// arithmetic (keeps signage) right shifting:
		
		System.out.println( -20 >> 1 );	// Right shift 1, divide by 2^1
		
		System.out.println( 40 >> 2 );	// Left shift 1, divide by 2^2
		
		System.out.println( -80 >> 3 );	// Left shift 1, divide by 2^3
		
		
		// logical (no signage) right shifting, bizarre answers:
		
		System.out.println( -20 >>> 1 );	// Right shift 1, divide by 2^1
		
		System.out.println( -40 >>> 2 );	// Left shift 1, divide by 2^2
		
		System.out.println( -80 >>> 3 );	// Left shift 1, divide by 2^3
	
		
		System.out.println(getIthBit(8, 3));
	}
	
	public static byte getIthBit(int n, int i) {
		
		return  (byte) ((n & (1 << i)) == 0 ? 0 : 1);
	}
	

}
