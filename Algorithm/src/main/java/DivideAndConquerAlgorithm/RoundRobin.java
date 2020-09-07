package DivideAndConquerAlgorithm;

import java.util.Scanner;

/**
 * 功能说明：
 * 　　　　* 开发人员：shasha shasha@qq.com <br>
 * 　　 　　* 开发时间：2020/8/19 <br>
 * 　　　　* 功能描述：写明作用，调用方式，使用场景，以及特殊情况 <br>
 *
 */
/*
* 分值算法--循环赛日程安排
* 问题描述：
设有n=2^k个运动员，要进行网球循环赛。
每个选手必须与其他n-1个选手各赛一次。
每个选手一天只能赛一次。
循环赛一共进行n-1天。
* */
public class RoundRobin {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("请输入运动员个数");
    int n = sc.nextInt();
    int m=n;
    int k=0;
    while(n>=2){
      if(n%2==0){
        k++;
        n/=2;
      }else{
        System.out.println("非法参数 ");
        break;
      }
      if(n==1){
        int[][] ans=new int[m][m];
        ans=fenzhi(k);
      }
    }
  }

  private static int[][]  fenzhi(int k) {
    int n=2^k;
    int[][] ans=new  int[n][n];
      ans[0][0]=1;
      ans[0][1]=2;
      ans[1][0]=2;
      ans[1][1]=1;
      if(k==1) return ans;
    for (int i = 1; i <k ; i++) {

    }
    return ans;
  }
}
