package xiaohongshu;

import java.util.Scanner;

/**
 * 功能说明：
 * 　　　　* 开发人员：shasha shasha@qq.com <br>
 * 　　 　　* 开发时间：2020/8/20 <br>
 * 　　　　* 功能描述：写明作用，调用方式，使用场景，以及特殊情况 <br>
 *
 */
/*能用完钱的最少购买件数 */
public class oneOther {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int amount = sc.nextInt();
    int n = sc.nextInt();
    int[] value = new int[n];
    for (int i = 0; i < n; i++) {
      value[i] = sc.nextInt();
    }
    System.out.println(change(value,amount));
}
  public static int change(int[] coins, int amount){
    int[] dp=new int[amount+1];
    if(amount==0){return 0;}
    for(int i=1;i<=amount;i++){
      dp[i]=Integer.MAX_VALUE;
      for(int j=0;j<coins.length;j++){
        if(i==coins[j]){
          dp[i]=1;break;
        }
        if(i>coins[j]&&dp[i-coins[j]]!=Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]]+1);
        }
      }
    }
    return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
  }
}
