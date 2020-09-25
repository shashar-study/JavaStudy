package mihoyou;

import java.util.Scanner;

public class four {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    String p=sc.nextLine();
    if(p.contains("+"))
      System.out.println("false");
    else
      {
        System.out.println("true");
      }
  }
}
