package kuaishou;

import java.util.Arrays;
import java.util.Scanner;

/*
* 第一行包含2个正整数，n和m。(1 <= n, m <= 1000，n是班级中学生数量，m是题目的数量)
下面n行数据每行包含一个string si，表示第i个学生的答案。si的第j个字符表示该学生第j个题目的答案。
* 输入例子1:
2 4
ABCD
ABCE
1 2 3 4

输出例子1:
16*/
public class two {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();//学生个数
    int m=sc.nextInt();//题目个数
    String[] ans=new String[n];//学生提交的答案
    for (int i = 0; i <n ; i++) {
      ans[i]=sc.nextLine();
    }
    int[] fenshu=new int[m];//每道题的分数
    for (int i = 0; i <m ; i++) {
      fenshu[i]=sc.nextInt();
    }
    int amount=0;//总分
    for (int i = 0; i <m ; i++) {
        int[] count=new int[5];
      for (int j = 0; j <n; j++) {
        if(ans[j].charAt(i)=='A')count[0]++;
        if(ans[j].charAt(i)=='B')count[1]++;
        if(ans[j].charAt(i)=='C')count[2]++;
        if(ans[j].charAt(i)=='D')count[3]++;
        if(ans[j].charAt(i)=='E')count[4]++;
      }
      Arrays.sort(count);
      amount+=count[4]*fenshu[i];
    }
    System.out.println(amount);
  }
}
