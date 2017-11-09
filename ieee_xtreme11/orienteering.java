import java.io.BufferedInputStream;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;


/*
1 3
2
0 0
0 2
0 0
5.0 6.0 5.0
100.0 101.5 103.0
 */
 class Main {
	final static double INF = 2000000000;
	static int m,n;
	static double[][] r,h;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		
		n = in.nextInt(); m = in.nextInt();
		int p = in.nextInt() ; // Control points including finish
		int sx = in.nextInt();
		int sy = in.nextInt();
		int px[] = new int[p];
		int py[] = new int[p];
		for (int i = 0; i < p; i++) {
			px[i] = in.nextInt();
			py[i] = in.nextInt();
		}
		r = new double[n][m];
		h = new double[n][m];
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				r[x][y] = in.nextDouble();
			}
		}
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				h[x][y] = in.nextDouble();
			}
		}
		
		ArrayList<ArrayList<SimpleEntry<Integer, Double>>> edges = new ArrayList<>();
		for (int x = 0; x < n; x++) {
			for (int y = 0; y < m; y++) {
				//This'll go in sequential order
				//System.out.println(vertexNum);
				ArrayList<SimpleEntry<Integer,Double>> conns = new ArrayList<>();
				edges.add(conns);
				if (x != 0) {
					conns.add(new SimpleEntry<Integer, Double>(vertexNum(x-1, y), t(x,y,x-1,y)));
				}
				if (x != n-1) {
					conns.add(new SimpleEntry<Integer, Double>(vertexNum(x+1, y), t(x,y,x+1,y)));
				}
				if (y != 0) {
					conns.add(new SimpleEntry<Integer, Double>(vertexNum(x, y-1), t(x,y,x,y-1)));
				}
				if (y != m-1) {
					conns.add(new SimpleEntry<Integer, Double>(vertexNum(x, y+1), t(x,y,x,y+1)));
				}
			}
		}
		
		double totTime  =0;
		int N = m*n;
		for (int i = 0; i < p; i++) {
			int x0 = i==0 ? sx : px[i-1];
			int y0 = i==0 ? sy : py[i-1];
			int x1 = px[i];
			int y1 = py[i];
			int s = vertexNum(x0, y0);
			int t = vertexNum(x1, y1);
			
			PriorityQueue<SimpleEntry<Integer, Double>> Q = 
					new PriorityQueue<>((ttt, ooo) -> {return Double.compare(ttt.getValue(), ooo.getValue());});
			ArrayList<Double> dist = new ArrayList<>(Collections.nCopies(N, INF));
			ArrayList<Integer> dad = new ArrayList<>(Collections.nCopies(N, -1));
			Q.add(new SimpleEntry<Integer, Double>(s, 0.));
			dist.set(s, 0.);
			while (!Q.isEmpty()) {
				SimpleEntry<Integer, Double> P = Q.remove();
				int here = P.getKey();
				if (here == t) break;
				if (dist.get(here).doubleValue() != P.getValue().doubleValue()) continue;
				
				for (SimpleEntry<Integer, Double> it : edges.get(here)) {
					if (dist.get(here).doubleValue() + it.getValue() < dist.get(it.getKey())) {
						dist.set(it.getKey(), dist.get(here) + it.getValue());
						dad.set(it.getKey(), here);
						Q.add(new SimpleEntry<Integer, Double>(it.getKey(), dist.get(it.getKey())));
					}
				}
			}
			
			//for (int ii = t; ii != -1; ii = dad.get(ii)) {
			//	System.out.println(ii);
			//}
			totTime += dist.get(t);
			//System.out.println();
		}
		System.out.println((int)Math.ceil(totTime));
		in.close();
		
	}
	
	public static double t(int xa, int ya, int xb, int yb) {
		return (r[xa][ya] + r[xb][yb])/2. * Math.exp(3.5 * Math.abs(0.05 + (h[xb][yb] - h[xa][ya]) / 10.));
	}
	
	public static int vertexNum(int x, int y) {
		return x*m + y;
	}
}
