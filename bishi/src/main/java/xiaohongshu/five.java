package xiaohongshu;

import java.util.Scanner;

/**
 * 输入描述:
 * 第一行包含空格分隔的两个数字 N和D(1 ≤ N ≤ 1000000; 1 ≤ D ≤ 1000000)
 *
 * 第二行包含N个建筑物的的位置，每个位置用一个整数（取值区间为[0, 1000000]）表示，从小到大排列（将字节跳动大街看做一条数轴）
 *
 * 输出描述:
 * 一个数字，表示不同埋伏方案的数量。结果可能溢出，请对 99997867 取模
 *
 * 输入例子1:
 * 4 3
 * 1 2 3 4
 *
 * 输出例子1:
 * 4
 *
 * 例子说明1:
 * 可选方案 (1, 2, 3), (1, 2, 4), (1, 3, 4), (2, 3, 4)
 *
 * 输入例子2:
 * 5 19
 * 1 10 20 30 50
 *
 * 输出例子2:
 * 1
 *
 * 例子说明2:
 * 可选方案 (1, 10, 20)*/

public class five {
  private int mod = 99997867;

  private void sln() {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(), D = sc.nextInt();
    long cnt = 0;
    if (N <= 2) {
      System.out.println(-1);
      return;
  }
    int[] locs = new int[N];
    for (int i = 0; i < N; i++) {
      locs[i] = sc.nextInt();
    }
    sc.close();
    int left = 0, right = 2;
    while (right < N) {
      if (locs[right] - locs[left] > D) left++;
      else if (right - left < 2) right++;
      else {
        cnt += calC(right - left);
        right++;
      }
    }
    cnt %= mod;
    System.out.println(cnt);
  }

  private long calC(long num) {
    return num * (num - 1) / 2;
  }


  public static void main(String[] args) {
    new five().sln();
  }
}

