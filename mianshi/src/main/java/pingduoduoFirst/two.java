package pingduoduoFirst;

import java.util.Scanner;

/**
 * 给顾客找零，顾客付 5、10、20元面值，早餐5元一份，
 * 原本摊主没有零钱，判断最多能接待几位顾客
 * */
public class two {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();//顾客人数
    int[] value=new int[n];
    for (int i = 0; i <n ; i++) {
      value[i]=sc.nextInt();
    }
    System.out.println(jishu(value));
  }

  private static int jishu(int[] value) {
    int[] help=new int[2];//存储当前10、5的数量
    int l=value.length;
    for (int i = 0; i < l; i++) {
      if (value[i]==5)
        help[1]++;
      else if(value[i]==10){
        if(help[1]>=1){
          help[0]++;
          help[1]--;
        }else
          return i;
      }else {
        int current=value[i];
        int count10=Math.min(value[0],current/10);
        current-=10*count10;
        int count5=Math.min(value[1],current/5);
        current-=5*count5;
        if(current==0){
          help[0]-=count10;
          help[1]-=count5;
        }else
          return i;
      }

    }
  return l;
  }
}
