package xiaohongshu;

import java.util.Scanner;

/**
 * 在神秘岛屿的深处，你发现了海贼王罗杰留下的谜题，呈现在你面前的是一个n*m的宝箱矩阵，
 * 每个宝箱中有一定数量的金币，你需要从这个矩阵中选出r行c列的子矩阵，
 * 使得这个子矩阵中每两个相邻的宝箱的金币差之和最小（相邻包括上下左右四个方向）。
 *
 *
 *
 * 输入描述
 * n m r c (n行m列的矩阵中选择r行c列, 0<r<=n, 0<c<=m)
 *
 * 接下来的n行，每行包含m个用空格隔开的整数，表示宝箱内的金币数。
 *
 * 输出描述
 * 1个整数(子矩阵中相邻宝箱的金币差之和的最小值)*/
public class three1 {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();
    int r=sc.nextInt();
    int c=sc.nextInt();
    int[][] value=new int[n][m];
    for (int i = 0; i <n ; i++) {
      for (int j = 0; j < m; j++) {
        value[i][j] = sc.nextInt();
      }
    }
  }
}
