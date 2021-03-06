package xiaohongshu;

import java.util.Scanner;

/*
* 在游戏中，击败魔物后，薯队长获得了N件宝物，接下来得把这些宝物卖给宝物回收员来赚点小钱。这个回收员有个坏毛病，每次卖给他一件宝 物后，之后他就看不上比这件宝物差的宝物了。在这个世界中，衡量宝物的好坏有两个维度，稀有度X和实用度H，回收员在回收一个宝物A 后，下一个宝物的稀有度和实用度都不能低于宝物A。那么薯队长如何制定售卖顺序，才能卖给回收员宝物总个数最多。

输入描述:
第一行一个正整数N。 接下来N行。每行两个整数分别表示X    和    H X1    H1 X2    H2 … XN    HN
输入限制： 对于70%的数据：
0<N<10^4
0<Xi<10^6
0<Hi<10^6
100%的数据：
0<N<10^6
0<Xi<10^6
0<Hi<10^6

输出描述:
一个整数，表示最多可以卖出的宝物数

输入例子1:
4
3 2
1 1
1 3
1 2

输出例子1:
3*/
public class four {
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int N=sc.nextInt();
      int[] x=new int[N];
      int[] H=new int[N];
      for (int i = 0; i <N ; i++) {
        x[i]=sc.nextInt();
        H[i]=sc.nextInt();
      }
      //冒泡排序
      for (int i = 0; i < N-1; i++) {
        if(x[i]>x[i+1]){
          int temp=x[i];
          x[i]=x[i+1];
          x[i+1]=temp;
          temp=H[i];
          H[i]=H[i+1];
          H[i+1]=temp;
        }
      }
      for (int i = 0; i < N-1; i++) {
        if(H[i]>H[i+1]){
          int temp=H[i];
          H[i]=H[i+1];
          H[i+1]=temp;
        }
      }

      int count=0;
      for (int i = 0; i <N-1 ; i++) {
        if(x[i]<=x[i+1]&&H[i]<=H[i+1])
          count++;
      }
      System.out.println(count);
    }
}
