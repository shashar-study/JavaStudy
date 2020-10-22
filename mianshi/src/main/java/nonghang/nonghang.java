package nonghang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author：shasha<br>
 * Time：2020/10/10 <br>
 * Description： <br>
 */
public class nonghang {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int[] num=new int[20];
    Arrays.fill(num,-1);
    String string = String.valueOf(num);
    System.out.println(string);
    char c=(char)('a'+1);
    String s = String.valueOf(c);
    System.out.println(c);
  }
}
