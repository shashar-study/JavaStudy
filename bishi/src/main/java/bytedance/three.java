package bytedance;

import java.util.Scanner;

public class three {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] count=new int[n+1];
    for (int i = 1; i <n+1 ; i++) {
      count[i]=sc.nextInt();
    }
    int q=sc.nextInt();
    int left=0,right=0,target=0;
    while(q!=0){
      left=sc.nextInt();
      right=sc.nextInt();
      target=sc.nextInt();
      System.out.println(jisuan(left,right,target,count));
      q--;
    }
  }

  private static int jisuan(int left, int right, int target, int[] count) {
    int sum=0;
    for (int i = left; i <=right ; i++) {
      if(count[i]==target)
        sum++;
    }
    return sum;
  }
}
