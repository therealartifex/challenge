import java.lang.*;
import java.util.*;
import java.math.*;
class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BigInteger m = sc.nextBigInteger();
    BigInteger n = sc.nextBigInteger();
    int t = sc.nextInt();
  	boolean a=false;
  	switch (t)
  	{
  		case 1:
  			if (n.intValue()>12) a=false;
  			else a=fact(n.intValue()).compareTo(m)<=0;
  			break;
  		case 2:
  			a=BigInteger.valueOf(2).pow(n.intValue()).compareTo(m)<=0;
  			break;
  		case 3:
  			a=n.pow(4).compareTo(m)<=0;
  			break;
  		case 4:
  			a=n.pow(3).compareTo(m)<=0;
  			break;
  		case 5:
  			a=n.pow(2).compareTo(m)<=0;
  			break;
  		case 6:
  			a=(n.intValue()*Math.log(n.intValue())/Math.log(2.))<=m.intValue();
  			break;
  		case 7:
  			a=n.compareTo(m)<=0;
  			break;
  		default:
  			break;
  	}
  	System.out.printf("%s\n", a ? "AC" : "TLE");
  }
  public static BigInteger fact(int a) {return a == 1 ? BigInteger.ONE : BigInteger.valueOf(a).multiply(fact(a-1));}
}