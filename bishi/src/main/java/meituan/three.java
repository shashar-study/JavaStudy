package meituan;

import java.util.Scanner;

/**
 * 给定一组个字符串，为每个字符串找出能够唯一识别该字符串的最小前缀。
 *
 *
 * 输入描述:
 * 第一行输入一个整数 n 表示字符串个数
 * 后面n行，每行一个字符串，一共n串互不相同的字符串。（2 <= n <= 100，字符串长度不超过100）*/
public class three {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    String[] str=new String[n];
    int[][] help=new int[n][n];
    sc.nextLine();
    for (int i = 0; i <n ; i++) {
      str[i]=sc.nextLine();
    }
    for (int i = 0; i <n-1 ; i++) {
      for (int j = i+1; j <n ; j++) {
        if(help[i][j]==0){
          char[] one = str[i].toCharArray();
          char[] two=  str[j].toCharArray();
          int index=0;
          int l1=one.length;
          int l2=two.length;
          while(index<l1&&index<l2){
            if(one[index]==two[index])
              index++;
            else
              break;
          }
          help[i][j]=index;
          help[j][i]=index;
        }
      }
    }
    String[] reslut=new String[n];
    for (int i = 0; i <n ; i++) {
      int max=0;
      for (int j = 0; j <n ; j++) {
        max=Math.max(max,help[i][j]);
      }
      reslut[i]=str[i].substring(0,max+1);
    }
    for (String s : reslut) {
      System.out.println(s);
    }
  }
}
