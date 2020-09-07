package meituan;

import java.util.Scanner;

/**
 * 有 N 堆金币排成一排，第 i 堆中有 C[i] 块金币。每次合并都会将相邻的两堆金币合并为一堆，
 * 成本为这两堆金币块数之和。经过N-1次合并，
 * 最终将所有金币合并为一堆。请找出将金币合并为一堆的最低成本。
 *
 * 其中，1 <= N <= 30，1 <= C[i] <= 100
 *
 *
 * 输入描述:
 * 第一行输入一个数字 N 表示有 N 堆金币
 * 第二行输入 N 个数字表示每堆金币的数量 C[i]*/
public class two {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] c=new int[n];
    for (int i = 0; i <n ; i++) {
      c[i]=sc.nextInt();
    }
    System.out.println(jisuan(c,n));
  }

  private static int jisuan(int[] c, int n) {
    if(n==1)
      return c[0];
    if(n==2)
      return c[0]+c[1];
    int min=Integer.MAX_VALUE;
    int index=0;
    int help;
    for (int i = 0; i <n-1 ; i++) {
      help=c[i]+c[i+1];
      if(min>help){
        index=i;
        min=help;
      }
    }
    int[] ans=new int[n-1];
    int left=0,right=0;
   while(right<n){
     if(right==index){
       ans[left]=min;
       right++;
     }
     left++;
     right++;
   }
   return min+jisuan(ans,n-1);
  }
}
