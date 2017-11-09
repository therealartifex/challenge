import java.util.*;
import java.lang.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n=sc.nextLong();
    int b=sc.nextInt();
  	System.out.printf("%s\n", n <= Math.pow(2,b+1)-1 ? "yes" : "no"); // you can't flim flam the zim-zam!
  }
}