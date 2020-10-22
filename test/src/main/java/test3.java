

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * Author：shasha<br>
 * Time：2020/10/5 <br>
 * Description： <br>
 */
public class test3 {
  public static void  main(String[] args) {
  double count=Math.pow(2,3);
    int value = 1 << 3 | 2;
    String bs = Integer.toBinaryString(value); //0x20 | 这个是为了保证这个string长度是6位数
    System.out.println(bs.substring(1));

    int jishu=0;
    for (int i = 0; i <count ; i++) {
      jishu++;
      String string = Integer.toBinaryString(i);
      char[] toCharArray = string.toCharArray();
      for (char c : toCharArray) {
        System.out.print(c+"  ");
      }
      System.out.println("=========");
    }
    System.out.println(jishu);
  }
}
