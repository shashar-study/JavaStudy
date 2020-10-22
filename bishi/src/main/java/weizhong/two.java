package weizhong;

/**
 * Author：shasha<br>
 * Time：2020/10/15 <br>
 * Description： <br>
 */

import java.util.Scanner;
import java.util.jar.JarOutputStream;

/**
 * 题目描述：
 * 现在你在玩一款游戏，叫做节奏小师。它有三种判定
 * P : Perfect 完美，加200分。
 * G : Great 很棒，加100分。
 * M : Miss 错过，不加分也不扣分，但累计三次Miss就会输掉游戏。
 * 另外有一种奖励是连击奖励。一旦连续三个Perfect之后，后续连击的Perfect分数将变成250分，但一旦打出了Great或者Miss则连击数将重新开始计算。
 * 你的任务是根据游戏记录计算分数。特别地，失败记为零分。
 * 输入描述
 * 一行一个字符串，描述你的游戏记录。
 * 保证字符串长度小于等于10000
 * 输出描述
 * 一行一个正整数表示得分
 * 样例输入
 * PPPPPGPPMP
 * 样例输出
 * 1800*/
public class two {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String shuru=sc.nextLine();
    if(shuru==null||shuru.length()==0)
      System.out.println(0);
    else
      System.out.println(jishu(shuru));
  }

  private static int jishu(String shuru) {
    char[] toCharArray = shuru.toCharArray();
    int combine=0;//连击
    int failure=0;
    int fenshu=0;
    for (int i = 0; i <toCharArray.length ; i++) {
      if(toCharArray[i]=='P'){
        combine++;
        if(combine>=4)
           fenshu+=250;
        else
          fenshu+=200;
      }else{
        combine=0;
        if(toCharArray[i]=='G')
          fenshu+=100;
        else{
          failure++;
          if(failure==3)
            return 0;
        }
      }
    }
    return fenshu;

  }
}
