package pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 *
 * 输入描述:
 * 输入共2行，第一行包括一个整数n，表示数组长度
 * 第二行为n个以空格隔开的整数，分别为A1,A2, … ,An
 *
 * 输出描述:
 * 满足条件的最大乘积
 *
 * 输入例子1:
 * 4
 * 3 4 1 2
 *
 * 输出例子1:
 * 24*/
public class nine {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] A=new int[n];
    for (int i = 0; i <n ; i++) {
      A[i]=sc.nextInt();
    }
    Arrays.sort(A);
    int max=Math.max(A[0]*A[1]*A[n-1],A[n-1]*A[n-2]*A[n-3]);
    System.out.println(max);

  }
}
