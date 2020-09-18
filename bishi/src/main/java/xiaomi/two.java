package xiaomi;
/**
 * 随着小米同学搬进小米科技园，米兔们也搬进来啦。
 * 为了给米兔准备新家，行政小姐姐和米兔们玩了一个游戏：
 * 有一个装满了绳子的箱子，绳子有长有短，由米兔们将这些绳子分成两份，
 * 之后行政小姐姐负责将这两份绳子拼接成两条长绳，这两条长绳将作为矩形的两条直角边用来规划米兔新家的大小。
 * 注意：绳子不能裁断，不能丢弃。
 * 假设拼接时绳子没有长度损失，设计一段程序计算一下这箱绳子能规划出的最大面积是多少。
 * 用整型数组array表示绳子的长短，第n段绳子长度为array[n]，其中：
 * 1 < n <= 200（如果200条绳子没什么思路，可以尝试解决 1 < n < 30）
 * 0 < array[n] <= 200
 * 输入描述
 * 箱子中绳子的长度及数目
 * 第一行为绳子数目
 * 第二行开始为各绳子的长度
 * 输出描述
 * 当前Case下的最大面积
 * 样例输入
 * 3
 * 3
 * 4
 * 5
 * 样例输出
 * 35
 *
 * 提示
 * 样例中划分方法有以下几种：
 *  1. {3} - {4, 5} // 3 * (4 + 5) = 27
 *  2. {4} - {3, 5} // 3 + 5) * 4 = 32
 *  3. {3, 4} - {5} // (3 + 4) * 5 = 35
 *  4. {5} - {3, 4} // 同3
 *  5. {3, 5} - {4} // 同2
 *  6. {4, 5} - {3} // 同1
 *
 * 其中3和4得出最大面积：35*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.zip.InflaterInputStream;

public class two {


  /*请完成下面这个函数，实现题目要求的功能
  当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
  ******************************开始写代码******************************/
  static int maxArea(int[] array,int sum) {
    //找若干个数，使得和最接近sum的一半
    int target=sum/2;
    int current=0;
    int old=0;
    int dp=array.length-1;//标识
    boolean flag=true;
    while(flag){
     current=find(array,dp,target);
     if(old==target)
       flag=false;
     old=target;
     target-=old;
    }
    return current*(sum-current);
  }

  private static int find(int[] array, int dp, int target) {
    int index=dp;
    for(int i=0;i<=dp;i++){
        if(Math.abs(target-array[i])<Math.abs(target-array[index])){
          index=i;
        }
      }
    int temp=array[index];
    array[index]=array[dp];
    array[dp]=temp;
    return array[dp--];
  }

  private static int chazhao(int[] array, int target, int[] dp) {
    int ans=Integer.MAX_VALUE;
    int index=0;
    for (int i = 0; i <array.length ; i++) {
      if(dp[i]==0){
        if(Math.abs(target-array[i])<ans)
          ans=array[i];
          index=i;
      }
    }
    dp[index]=1;
    return ans;
  }

  /******************************结束写代码******************************/


  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int res;

    int _array_size = 0;
    _array_size = Integer.parseInt(in.nextLine().trim());
    int[] _array = new int[_array_size];
    int _array_item;
    int sum=0;
    for(int _array_i = 0; _array_i < _array_size; _array_i++) {
      _array_item = Integer.parseInt(in.nextLine().trim());
      _array[_array_i] = _array_item;
      sum+=_array_item;
    }

    res = maxArea(_array,sum);
    System.out.println(String.valueOf(res));

  }
}
