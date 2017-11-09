import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/*
300 Backtracking Dynamic_Programming Greedy
125 Dynamic_Programming
35 Backtracking
85 Greedy
120 Backtracking Dynamic_Programming
80 Greedy Backtracking

*/
class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		ArrayList<SimpleEntry<Integer, String[]>> books = new ArrayList<>();
		
		TreeSet<String> ncheck = new TreeSet<String>();
		while (in.hasNextLine()) {
			String line = in.nextLine();
			if (line.trim().isEmpty()) break;
			String numstr = line.substring(0, line.indexOf(' ')).trim();
			String[] tokens = line.substring(numstr.length()).trim().split(" ");
			int num = Integer.parseInt(numstr);
			for (String s : tokens) ncheck.add(s);
			books.add(new SimpleEntry<Integer, String[]>(num, tokens));
		}
		
		TreeSet<String> incl = new TreeSet<String>();
		System.out.println(minimize(incl, books, 0,0, ncheck.size()));
	}
	
	static int pruneSuccess = Integer.MAX_VALUE;
	private static int minimize(TreeSet<String> incl, ArrayList<SimpleEntry<Integer, String[]>> books, int i, int used, int nbooks) {
		if (used >= pruneSuccess) return Integer.MAX_VALUE;
		if (i == books.size()) {
			if (nbooks == incl.size()) {
				pruneSuccess = Math.min(pruneSuccess, used);
				return used;
			}
			return Integer.MAX_VALUE;
		}
		@SuppressWarnings("unchecked")
		TreeSet<String> incl2 = (TreeSet<String> )incl.clone();
		for (String s : books.get(i).getValue()) incl2.add(s);
		return Math.min(minimize(incl2, books, i+1, used+books.get(i).getKey(), nbooks), 
				minimize(incl, books, i+1, used, nbooks));
	}
}
