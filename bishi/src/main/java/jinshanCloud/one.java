package jinshanCloud;

import java.util.Scanner;

/**
 * 首先按照从上到下、从左到右的顺序输入一棵满二叉树中每一个结点对应的权重，
 * 例如输入1、1、2表示二叉树的根结点的权重为1，它的左、右两个子节点的权重分别为1和2。
 * 然后判断该满二叉树中是否存在这样的非叶子结点：它的左子树上所有结点的权重之和等于右子树上所有结点的权重之和。
 * 现在给你一棵满二叉树的所有结点的权重，请编写一个程序，寻找是否存在满足要求的非叶子结点，
 * 如果存在输出“Yes”，否则输出“No”。
 *
 * 输入描述
 * 多组输入。
 * 第1行输入一个正整数T表示测试数据的数量。(T<=100)
 * 接下来T行对应T组输入，每组输入数据占一行，该行包含n个正整数（n满足2^k-1），两两之间用空格隔开，1<n<=1000。
 * 输出描述
 * 对于每组输入数据，如果能够找到满足要求的非叶子结点（左子树上所有结点的权重之和等于右子树上所有结点的权重之和），输出“Yes”，否则输出“No”。
 * 样例输入
 * 3
 * 1 2 2 1 2 1 2
 * 1 2 2 1 3 2 2
 * 1 2 2 1 2 1 3
 * 样例输出
 * Yes
 * Yes
 * No*/
public class one {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int T=sc.nextInt();
    sc.nextLine();
    for (int i = 0; i <T ; i++) {
      String s=sc.nextLine();
      System.out.println(panduan(s));
    }
  }

  private static boolean panduan(String s) {
    String chuli="0 "+s;
    String[] split = chuli.split("\\s+");
    int length=split.length;
    int h= (int) (Math.log(length+1)/Math.log(2));
    int end=(int)Math.pow(2,h-1);
    for(int i=1;i<end;i++){
      if(jisuan(split,2*i)==jisuan(split,2*i+1)){
        return true;
      }
    }
    return false;
  }

  private static int jisuan( String[] split,int i) {
    if(i>=split.length)
      return 0;
    else
      return Integer.parseInt(split[i])+jisuan(split,2*i)+jisuan(split,2*i+1);
  }
}
