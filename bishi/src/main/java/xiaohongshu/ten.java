package xiaohongshu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 输入分为三部分，第一个部分是一个 int，代表这个大班里小朋友的总数。
 * 第二部分是一个 int，代表园长采集到的小朋友们的请求数。
 * 第三部分是小朋友们的请求，每个请求由两个 int 组成，第一个 int 代表提请求的小朋友，
 * 二个 int 代表他不希望同班的另一位小朋友。
 * 输出描述:
 * 如果所有小朋友的请求都可以被满足，输出 1，否则输出 0。
 * 示例1
 * 输入
 * 5
 * 5
 * 1 2
 * 1 3
 * 1 4
 * 1 5
 * 2 3
 * 输出
 * 0
 * 说明
 * 总共有 5 位小朋友，总共采集到了 5 个请求。分别是：1 不希望和 2 同班。
 * 1 不希望和 3 同班。1 不希望和 4 同班。1 不希望和 5 同班。
 * 2 不希望和 3 同班。不能满足所有人的请求，输出 0。
 * 示例2
 * 输入
 * 5
 * 4
 * 1 2
 * 1 3
 * 1 4
 * 1 5
 * 输出
 * 1
 * 说明
 * 总共有 5 位小朋友，总共采集到了 4 个请求。分别是：1 不希望和 2 同班。
 * 1 不希望和 3 同班。1 不希望和 4 同班。
 * 1 不希望和 5 同班。可以满足所有人的请求，
 * 分班方式：1 一个人一班，2、3、4、5 另一班。输出 1。*/
public class ten {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();//小朋友人数
    int q=sc.nextInt();//请求数量
    List<Integer> list1=new ArrayList<Integer>();//分班1
    List<Integer> list2=new ArrayList<Integer>();//分班1
    int[][] quest=new int[q][3];//多留一列，用来表示这个请求是否已经被处理0，未处理，2，已处理，1经过一次过滤
    for (int i = 0; i <q ; i++) {
      quest[i][0]=sc.nextInt();
      quest[i][1]=sc.nextInt();
    }
    //预处理
    list1.add(quest[0][0]);
    list2.add(quest[0][1]);
    quest[0][2]=1;
    int count=0;
    while(list1.size()+list2.size()<n){
         count++;
         if(count>2*q) break;
        for (int i = 1; i <q ; i++) {
          if(quest[i][2]<=1){
            if(list1.contains(quest[i][0])){
              if(list1.contains(quest[i][1])){
                count=2*q+1;
                break;
              }
              list2.add(quest[i][1]);
              quest[i][2]=2;
            }else if(list1.contains(quest[i][1])){
              if(list1.contains(quest[i][0])){
                count=2*q+1;
                break;
              }
              list2.add(quest[i][0]);
              quest[i][2]=2;
            }else if(list2.contains(quest[i][1])){
              if(list2.contains(quest[i][0])){
                count=2*q+1;
                break;
              }
              list1.add(quest[i][0]);
              quest[i][2]=2;
            } else if(list2.contains(quest[i][0])){
              if(list2.contains(quest[i][1])){
                count=2*q+1;
                break;
              }
              list1.add(quest[i][1]);
              quest[i][2]=2;
            }else if(quest[i][2]==0){
              quest[i][2]=1;
            }else{
              list1.add(quest[i][0]);
              list2.add(quest[i][1]);
            }

        }
      }

    }
    if(count<=2*q)
      System.out.println(1);
    else
      System.out.println(0);
  }
}
