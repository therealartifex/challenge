import java.util.Scanner;

/*
52
A 168.05
B 41.27
C 119.19
D 312.43
E 236.94
F 269.85
G 318.46
H 206.02
I 140.19
J 162.81
K 199.80
L 207.06
M 217.69
N 220.22
O 282.10
P 80.42
Q 312.29
R 324.76
S 348.38
T 311.84
U 289.66
V 137.41
W 175.23
X 0.47
Y 198.07
Z 251.39
IEEEXtreme rocks!
 */

class  Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double rad = in.nextDouble();
		double[] angles = new double[26];
		for (int i = 0; i < 26; i++) {
			in.next();
			angles[i] = in.nextDouble()/180.*Math.PI;
		}
		in.nextLine();
		String line = in.nextLine();
		double len = 0;
		char lastChar = ' ';
		for (char c : line.toCharArray()) {
			if (!Character.isAlphabetic(c)) continue;
			c = Character.toLowerCase(c);
			if (lastChar == ' ') {
				lastChar = c;
				continue;
			}
			len += 2*Math.abs(rad * Math.sin((angles[lastChar-'a'] - angles[c - 'a'])/2));
			lastChar = c;
		}
		
		System.out.println((int)Math.ceil(len + rad));
	}
}
