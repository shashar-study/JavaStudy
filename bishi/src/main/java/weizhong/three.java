package weizhong;

/**
 * Author：shasha<br>
 * Time：2020/10/15 <br>
 * Description： <br>
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 题目描述：
 给一个数不包含前导0的数n，现在将n的各位数字的顺序重组，在这些数中，有多少个数是m的倍数？
 例如112,重组后有三个数：112,121,211
 输入描述
 输入包含两个数，n和m，含义如题面所示
 输出描述
 输出一个数，代表m的倍数的个数。
 样例输入
 112 4
 样例输出
 1
 提示
 数据范围：n≤10^18,1≤m≤100*/
public class three {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String shuru = sc.nextLine();
    String[] split = shuru.split("\\s+");
    String s=split[0];
    int m = Integer.parseInt(split[1]);
    //全排列,有重复元素
    List<String> list=new ArrayList<String>();
    list.add(s);
    for (int i = 0; i <s.length()-1; i++) {
      int size=list.size();
      for(int j=i+1;j<s.length();j++){
        for (int k = 0; k <size ; k++) {
          String newS=swap(list.get(k),i,j);
          if (!list.contains(newS))
              list.add(newS);
        }
      }
    }
   int count=0;
    for (int i = 0; i <list.size() ; i++) {
      double help=Double.parseDouble(list.get(i));
      if(help%m==0)
        count++;
    }
    System.out.println(count);
  }

  private static String swap(String s, int i, int j) {
    char[] chars = s.toCharArray();
    char c=chars[i];
    chars[i]=chars[j];
    chars[j]=c;
    return new String(chars);
  }
}
