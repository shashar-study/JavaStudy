package jinshanCloud;

import java.util.Scanner;

/**
 * 小明最喜欢的数字是5。他在班上的学号是5号，也是学校足球队的5号队员。
 * 现在小明希望你帮他编写一个程序，输入一个正整数n，输出从数字1到数字n中，一共出现了多少个5。
 *
 * 输入描述
 * 单组输入。
 *
 * 输入一个正整数n，1<n<=100000。
 *
 * 输出描述
 * 输出一个整数，即1到n的数字中5出现的个数。*/
public class two {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println(jishu(n));

  }

  private static int jishu(int n) {
    if(n<50)
      return 1+(n-5)/10;
    int ans=0;
    int count=0;//位数
    int current=n/5;
    while(current>=10){
      count++;
      current/=10;
    }
    while(count!=0){
      int help=10^count;
      ans+=help*(1+(n-5*help)/help/10);
      count--;
    }
  if(n%5!=0){
      int start=n/5;
      for (int i =start*5; i <=n ; i++) {
        current=i;
        while(current>=10){
          if(current%10==5){
            ans++;
          }
          current/=10;
        }
    }
    }
  return  ans;



  }
}
