package pinduoduo;

import java.util.Scanner;

/**
 * 扔n个骰子，第i个骰子有可能投掷出Xi种等概率的不同的结果，
 * 数字从1到Xi。所有骰子的结果的最大值将作为最终结果。求最终结果的期望。
 * 输入描述:
 * 第一行一个整数n，表示有n个骰子。（1 <= n <= 50）
 * 第二行n个整数，表示每个骰子的结果数Xi。(2 <= Xi <= 50)
 *
 * 输出描述:
 * 输出最终结果的期望，保留两位小数。
 *
 * 输入例子1:
 * 2
 * 2 2
 *
 * 输出例子1:
 * 1.75*/
public class eight {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] X = new int[n];
    int max = 2;
    for (int i = 0; i < n; i++) {
      X[i] = in.nextInt();
      max = Math.max(max,X[i]);
    }
    double ret = 0;
    double pre = 0;
    for (int i = 1; i <= max; i++) {
      double cur = 1.0;
      for (int j = 0; j < n; j++) {
        cur *= (double)Math.min(X[j],i) / (double)X[j];
      }
      ret += (cur-pre) * i;
      pre = cur;
    }
    System.out.printf("%.2f",ret);
  }
}
