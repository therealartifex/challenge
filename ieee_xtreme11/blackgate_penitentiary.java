import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/*
6
TheJoker 180
HarleyQuin 160
MrHammer 220
Boody 220
Muggs 180
Paulie 180

*/
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		TreeMap<Integer, TreeSet<String>> map = new TreeMap<>();
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			String name = in.next();
			int height = in.nextInt();
			if (!map.containsKey(height)) map.put(height, new TreeSet<String>());
			map.get(height).add(name);
			
			
		}
		int i = 1;
		for (TreeSet<String> ss : map.values()) {
			for (String s : ss) {
				System.out.print(s);
				System.out.print(" ");
			}
			System.out.println(i + " " + (i + ss.size() - 1));
			i += ss.size();
		}
	}
}
