package meituan;

import java.util.Scanner;

/**计算两个字符串输出的数字，并以字符串形式输出*/
public class one {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String str1=sc.nextLine();
    String str2=sc.nextLine();
    Double num1=Double.parseDouble(str1.replace("\"",""));
    Double num2=Double.parseDouble(str2.replace("\"",""));
    System.out.println(num1+num2+"");
  }
}
