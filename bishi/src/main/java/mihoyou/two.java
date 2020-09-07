package mihoyou;

import java.util.Scanner;

public class two {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String formula = in.nextLine();
    int length = formula.length();
    char[] yusuanfuchar = new char[]{'+', '-', '*', '/'};
    int dex = 0;
    for (int i = 0; i < 4; i++) {
      dex = Math.max(dex, formula.indexOf(yusuanfuchar[i]));
    }
    char yusuanfu = formula.charAt(dex);
    int a;
    int b = 0, c = 0, d = 0;
    a = Integer.parseInt(formula.charAt(0) + "");
    if (length == 9) {
      b = Integer.parseInt(formula.charAt(2) + "");
      c = Integer.parseInt(formula.charAt(6) + "");
      d = Integer.parseInt(formula.charAt(8) + "");
    } else if (length == 5) {
      b = 1;
      c = Integer.parseInt(formula.charAt(4) + "");
      d = 1;
    } else if (length == 7) {
      if (dex == 2) {
        b = 1;
        c = Integer.parseInt(formula.charAt(4) + "");
        d = Integer.parseInt(formula.charAt(6) + "");
      } else {
        b = Integer.parseInt(formula.charAt(2) + "");
        c = Integer.parseInt(formula.charAt(6) + "");
        d = 1;
      }

    }

    int fenmu = b * d;
    int fenzi = 0;
    boolean falg = true;
    if (yusuanfu == '+') {
      fenzi = a * d + b * c;
    } else if (yusuanfu == '-') {
      fenzi = a * d - b * c;
      if (fenzi < 0) {
        falg = false;
        fenzi = Math.abs(fenzi);
      }
    } else if (yusuanfu == '*') {
      fenzi = a * c;
    } else {
      fenmu = b * c;
      fenzi = a * d;
    }
    if (fenmu == 1)
      System.out.println(fenzi);
    else if (fenzi == 0)
      System.out.println(0);
    else {
      int x = gcd(fenmu, fenzi);
      fenmu /= x;
      fenzi /= x;
      if(falg)
        System.out.println(fenzi+"/"+fenmu);
      else
        System.out.println("-"+fenzi+"/"+fenmu);
    }
  }


    public static int gcd ( int a, int b){
      if (a >= b) {
        if (a % b == 0) {
          return b;
        }
        return gcd(b, a % b);
      } else
        return gcd(b, a);

    }
}
