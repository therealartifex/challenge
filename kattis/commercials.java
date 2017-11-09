import java.util.*;
import java.lang.*;

class Main {
  public static void main(String[] args) {
  	Scanner sc = new Scanner(System.in);
  	
  	sc.nextInt();
  	int p=sc.nextInt();
  	sc.nextLine();
  	String[] num = sc.nextLine().split(" ");
  	long msf=0,meh=0;
  	for (String s : num)
  	{
  		long i = Long.parseLong(s)-p;
  		meh = Math.max(0, meh+i);
        msf = Math.max(msf, meh);
  	}
  	System.out.printf("%d\n",msf);
  }
}