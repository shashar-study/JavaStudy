package pinduoduo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 在一块长为n，宽为m的场地上，有n✖️m个1✖️1的单元格。每个单元格上的数字就是按照从1到n和1到m中的数的乘积。具体如下
 *
 * n = 3, m = 3
 * 1   2   3
 * 2   4   6
 * 3   6   9
 *
 * 给出一个查询的值k，求出按照这个方式列举的的数中第k大的值v。
 * 例如上面的例子里，
 * 从大到小为(9, 6, 6, 4, 3, 3, 2, 2, 1)
 * k = 1, v = 9
 * k = 2, v = 6
 * k = 3, v = 6
 * ...
 * k = 8, v = 2
 * k = 9, v = 1
 *
 * 输入描述:
 * 只有一行是3个数n, m, k 表示场地的宽高和需要查询的k。使用空格隔开。
 *
 * 输出描述:
 * 给出第k大的数的值。
 *
 * 输入例子1:
 * 3 3 4
 *
 * 输出例子1:
 * 4*/
public class seven {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();
    int k=sc.nextInt();
    List<Integer> result=new ArrayList<>();
    for (int i = 1; i <=n ; i++) {
      for (int j = 1; j <=m ; j++) {
        result.add(i*j);
      }
    }
    Collections.sort(result);
    Collections.reverse(result);
    for (Integer integer : result) {
      System.out.print(integer+" ");
    }
    System.out.println(result.get(k-1));
  }
}
