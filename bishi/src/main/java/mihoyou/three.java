package mihoyou;

import java.util.Scanner;

/**
 * */
public class three {

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int m=sc.nextInt();
    int n=sc.nextInt();
    char[] zifu={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T'
    ,'U','V','W','X','Y','Z'};
    char[][] ans=new char[m][n];//存储答案
    int count=0;//判断当前存放的字符
    int flag=0;//flag 表示当前的圈数，0是第一圈
    int  num=0;//操作数量，上线是m*n
    while(true){
      if(num==n*m)
        break;;
      int[] tianchong = tianchong(ans, m, n, zifu, count, flag);
      num+=tianchong[0];
      count=tianchong[1];
      flag++;
    }
    for (int i = 0; i < ans.length; i++) {
      for (int j = 0; j <ans[0].length ; j++) {
        System.out.print(ans[i][j]+" ");
      }
      System.out.println();
    }
  

  }

  private static int[] tianchong(char[][] ans,int m,int n, char[] zifu, int count, int flag) {
    int num=0;//操作次数
    for (int i = flag; i <=n-flag-1 ; i++) {//第flag圈的上面一行
      ans[flag][i]=zifu[count%26];
      count++;
      num++;
    }
    //判断是否构成圈，是否仅有一行
    if(m%2==0||flag!=(m/2)+1){
      for (int i = flag+1; i <=m-flag-1; i++) {//第flag圈的右面一列
        ans[i][n-flag-1]=zifu[count%26];
        count++;
        num++;
      }
      for (int i = n-flag-2; i >=flag; i--) {//第flag圈的下面一行
        ans[m-flag-1][i]=zifu[count%26];
        count++;
        num++;
      }
      for (int i =m-flag-2; i >=flag+1; i--) {//第flag圈的左面一列
        ans[i][flag]=zifu[count%26];
        count++;
        num++;
      }
    }
   int[] help=new int[2];
    help[0]=num;
    help[1]=count;
    return help;
  }

}
