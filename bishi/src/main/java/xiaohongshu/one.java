package xiaohongshu;

import java.util.Scanner;

/*
* 某小红薯在小红书的活动中抽奖中了一定价值的薯券，这些薯券可以用来购买一批商品，
* 求有多少种购买组合。其中一件商品可以买多件。
输 入:薯券金额、商品分别价格
输出 :组合数
*/
public class one{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int V=sc.nextInt();
    String s = sc.nextLine();
    String[] split = s.substring(2, s.length() - 1).split(",");//左包含右不包含
    int N=split.length;
    int[] value=new int[N];
    for (int i = 0; i <N ; i++) {
      value[i]=Integer.parseInt(split[i]);
    }
    System.out.println(bagComplete(V,N,value));
    //完全背包问题

  }

  private static int bagComplete(int v, int n, int[] value) {
    int[] dp=new int[v+1];
    dp[0]=1;
    for (int i = 0; i <n; i++) {
      for (int j = 1; j <=v; j++) {
        if(j>=value[i]){
          dp[j]+=dp[j-value[i]];
        }
      }
    }
    return dp[v];
  }
}
