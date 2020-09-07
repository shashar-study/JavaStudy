package shunfeng;

import java.util.Scanner;

/**
 * 时间限制： 3000MS
 * 内存限制： 786432KB
 * 题目描述：
 * 现有一序列，长度为n，所有元素均为整数元素。序列中一些元素是确定值，另一些元素是不确定的。
 * 你的任务是将所有不确定值的元素赋予一个正整数值，使得将整个序列分割成最少的段，
 * 每一个段都是一个等差数列。 特别的，长度为1和2的段都是等差数列。
 *
 * 范围
 *
 * 对于100%的数据，n≤100000,数据组数不会超过10，出现的数字不会超过109，且除-1外都是正整数
 *
 *
 *
 * 输入描述
 * 输入包含多组数据，对每组数据第一行包含一个整数n 接下来一行n个整数，空格隔开。
 * 如果数为-1,代表该元素不确定，否则该元素为确定值，输入的是这个数的值。
 *
 * 输出描述
 * 输出一行一个数，代表分割后最少的段数，使得每一段都是等差数列
 *
 *
 * 样例输入
 * 3
 * -1 -1 -1
 * 3
 * -1 -1 1
 * 3
 * 1 -1 2
 * 7
 * -1 -1 -1 4 5 1 2
 * 样例输出
 * 1
 * 1
 * 2
 * 2
 *
 * 提示
 * 可以按照以下来填这四组数据
 * 1 1 1
 * 1 1 1
 * 1 1 2
 * 1 2 3 4 5 1 2*/
public class one {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    while (sc.hasNext()){
      int N=sc.nextInt();
      int[] xulie=new int[N];
      for (int i = 0; i <N ; i++) {
        xulie[i]=sc.nextInt();
      }
      System.out.println(jishu(xulie,N));
    }
  }


  private static int jishu(int[] xulie,int N) {
    if(N<=2) return 1;
    int count=0;int d=-1;
    for (int i = 0; i <N ; i++) {
      if(xulie[i]==-1){
        count++;
      }else{
        if(d==-1){

        }
      }

    }
    return 0;
  }
}
