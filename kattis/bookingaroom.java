import java.lang.*;
import java.util.*;
import java.util.stream.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int r=sc.nextInt();
    int n=sc.nextInt();
    
    if (n==r) {
        System.out.println("too late");
        System.exit(0);
    }
    
    List<Integer> i = IntStream.rangeClosed(1,100).boxed().collect(Collectors.toList());
    
    for (int j=0;j<n;j++){
        Integer a = sc.nextInt();
        i.remove(a);
    }
    
    System.out.println(i.get(0));
  }
}