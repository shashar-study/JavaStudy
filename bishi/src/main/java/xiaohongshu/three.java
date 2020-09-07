package xiaohongshu;

import java.util.Scanner;

/*
*  薯队长写了n篇笔记，编号从1~n,每篇笔记都获得了不少点赞数。
薯队长想从中选出一些笔记，作一个精选集合。挑选的时候有两个规则：
 1.不能出现连续编号的笔记。
2.总点赞总数最多
如果满足1，2条件有多种方案，挑选笔记总数最少的那种

输入描述:
输入包含两行。第一行整数n表示多少篇笔记。 第二行n个整数分别表示n篇笔记的获得的点赞数。
 （0<n<=1000,    0<=点赞数<=1000)

输出描述:
输出两个整数x,y。空格分割。
 x表示总点赞数，y表示挑选的笔记总数。

输入例子1:
4
1 2 3 1

输出例子1:
4 2*/
public class three {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n= sc.nextInt();//日记篇数
    int[] dianzan=new int[n];
    for (int i = 0; i <n ; i++) {
      dianzan[i]=sc.nextInt();
    }
    int[] dp=new  int[n+1];//dp[i]表示前i篇的最高点赞数bi
    int[] y=new int[n+1];//y[i]表示dp[i]时选中的笔记篇数
    dp[0]=0;dp[1]=dianzan[0];
    y[0]=0;y[1]=1;
    for (int i = 2; i <=n ; i++) {
      int help=dianzan[i-1]+dp[i-2];
      if(help>dp[i-1]){
        dp[i]=help;
        y[i]=y[i-2]+1;
      }else if(help<dp[i-1]){
        dp[i]=dp[i-1];
        y[i]=y[i-1];
      }else{
        dp[i]=dp[i-1];
        y[i]=Math.min(y[i-1],y[i-2]+1);
      }

    }
    System.out.println(dp[n]+" "+y[n]);
  }
}
