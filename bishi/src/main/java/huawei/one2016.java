package huawei;

import java.util.Scanner;

/**
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候, 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。*/
public class one2016 {
  private static int[] grade;
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();
    grade=new int[n+1];
    for (int i = 1; i <n+1 ; i++) {
      grade[i]=sc.nextInt();
    }
    sc.nextLine();
    String[] quests=new String[m];
    for (int i = 0; i < m; i++) {
      quests[i]=sc.nextLine();
    }
    for (String quest : quests) {
      String[] split = quest.split("\\s+");
      if(split[0].contains("Q"))
        tiwen(split,grade);
      else
        update(split,grade);
    }
  }

  private static void update(String[] split, int[] grade) {
    int index=Integer.parseInt(split[1]);
    int target=Integer.parseInt(split[2]);
    grade[index]=target;
  }

  private static void tiwen(String[] split, int[] grade) {
    int left=Integer.parseInt(split[1]);
    int right=Integer.parseInt(split[2]);
    if(left>right){
      int temp=left;
      left=right;
      right=left;
    }
    int  max=0;
    for (int i = left; i <=right ; i++) {
      max=Math.max(max,grade[i]);
    }
    System.out.println(max);
  }
}
