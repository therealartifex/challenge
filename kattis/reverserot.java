import java.lang.*;
import java.util.*;

class Main
{
  public static void main(String[] args)
  {
  	String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.";
  	Scanner sc = new Scanner(System.in);
  	while(true)
  	{
  		int n = sc.nextInt();
  		if (n==0) System.exit(0);
  		String s = sc.next();
  		StringBuilder sb = new StringBuilder();
  		for(char c : s.toCharArray())sb.append(alpha.charAt((alpha.indexOf(c)+n)%28));
  		sb.reverse();
  		System.out.printf("%s\n",sb.toString());
  	}
  }
}