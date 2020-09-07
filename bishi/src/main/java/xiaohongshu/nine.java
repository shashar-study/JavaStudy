package xiaohongshu;

import java.util.Scanner;

/**
 * 输入一个自然数n，求表达式 f(n) = 1!2!3!.....n! 的结果末尾有几个连续的0？
 *
 * 输入描述:
 * 自然数n
 *
 * 输出描述:
 * f(n)末尾连续的0的个数
 *
 * 输入例子1:
 * 11
 *
 * 输出例子1:
 * 9*/
//计算5的个数
public class nine {
    public static void main(String[] args) {
      Scanner sc = new Scanner( System.in );
      int n = sc.nextInt();
      int res = 0;
      for (int i = 1; i <= n; i++){
        res += getNum0( i );
      }
      System.out.println(res);
    }
    public static int getNum0(int num){
      int count = 0;
      while (num>0){
        count+=num/5;
        num/=5;
      }
      return count;
    }
}
