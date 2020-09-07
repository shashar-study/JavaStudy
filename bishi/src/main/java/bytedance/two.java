package bytedance;

import java.util.Scanner;

/**输出描述
  * 第一行包含空格分隔的两个数字 N和D(1 ≤ N ≤ 1000000; 1 ≤ D ≤ 1000000)
  *
  * 第二行包含N个建筑物的的位置，每个位置用一个整数（取值区间为[0, 1000000]）
  * 表示，从小到大排列（将字节跳动大街看做一条数轴）
  * 输出描述:
  * 一个数字，表示不同埋伏方案的数量。结果可能溢出，请对 99997867 取模*/
public class two {
   public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     int N= sc.nextInt();
     int D=sc.nextInt();
     int[] distance=new int[N];
     for (int i = 0; i <N ; i++) {
       distance[i]=sc.nextInt();
     }
     int left=0,right=N-1;
     System.out.println(jishu(distance,left,right,D));
   }

  private static int  jishu(int[] distance, int left, int right,int D) {
    if (left >= right - 1) return 0;
    if (distance[right] - distance[left] <= D) {
      return right - left - 1 + jishu(distance, left, right-1, D)+jishu(distance, left+1, right, D);
    }else
      return jishu(distance, left, right-1, D)+jishu(distance, left+1, right, D);
  }

}

