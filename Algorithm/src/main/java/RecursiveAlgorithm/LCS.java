package RecursiveAlgorithm;

/**
 *
 * 最长公共子序列(LCS)问题
 */
public class LCS {
  public int findLCS(String m,String n){
    //x和y分别表示两个字符串的长度，根据各自的字符串长度构建二维数组；
    int x = m.length();
    int y = n.length();
    char[] mm = m.toCharArray();
    char[] nn = n.toCharArray();
    int[][] dp = new int[x][y];

    //第一行
    for (int i=0;i<x;i++){
      if (mm[i] == nn[0]){
        System.out.println(i);
        dp[i][0] =1;
        for (int j =i+1;j<x;j++){
          dp[j][0] =1;
        }
        break;
      }
    }

    //第一列
    for (int i=0;i<y;i++){
      if (nn[i] == mm[0]){
        dp[0][i] =1;
        for (int j =i+1;j<y;j++){
          dp[0][j] =1;
        }
        break;
      }
    }
    //计算其他位置要放的数字；这个数字的大小取决于动态规划思想中的前边特殊位置的值
    for (int i=1;i<x;i++){
      for (int j=1;j<y;j++){
        if (mm[i] == nn[j]){
          dp[i][j] = dp[i-1][j-1]+1;
        }else {
          dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
        }
      }
    }



    for (int i=0;i<x;i++){
      for (int j=0;j<y;j++){
        System.out.print(dp[i][j]+" ");
      }
      System.out.println();
    }
    return dp[x-1][y-1];
  }

  public static void main(String[] args){
    LCS lcs = new LCS();
    int count = lcs.findLCS("android", "random");
    System.out.println("序列相同的个数是：" + count);
  }
}
