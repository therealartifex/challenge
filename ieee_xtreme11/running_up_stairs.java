import java.math.BigInteger;
import java.util.Scanner;

class Main {
	
	static BigInteger TWO = BigInteger.valueOf(2);
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t;i++) {
			int n = in.nextInt();
			System.out.println(fibonacci(n+1));
		}
	}
	
	private static BigInteger fibonacci(int n) {
		
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		for (int i = 31; i >= 0; i--) {
			BigInteger d = a.multiply((b.multiply(TWO).subtract(a)));
			BigInteger e = a.pow(2).add(b.pow(2));
			a = d;
			b = e;
			if ((((long) n >>> i) & 1) != 0) {
				BigInteger c = a.add(b);
				a = b;
				b = c;
			}
		}
		return a;
	}
}
