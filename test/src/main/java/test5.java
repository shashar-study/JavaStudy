/**
 * Author：shasha<br>
 * Time：2020/10/20 <br>
 * Description： <br>
 */
public class test5 {
  public static void main(String[] args) {
    String s="2.5.6.777.9.0";
    String[] split = s.split("\\.");
    for (String s1 : split) {
      System.out.println(s1);
    }
  }
}
