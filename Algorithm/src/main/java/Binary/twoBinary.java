package Binary;

/**
 * Author：shasha<br>
 * Time：2020/10/15 <br>
 * Description： <br>
 */
public class twoBinary {
  public static void main(String[] args) {
    //输出二进制
    int num=3;
    String string = Integer.toBinaryString(num);
    System.out.println(string);

    //输出指定位数的二进制，比如指定五位数
    int digits=5;
    int value = 1 << digits | num;
    String bs = Integer.toBinaryString(value); //0x20 | 这个是为了保证这个string长度是6位数
    System.out.println(bs.substring(1));
  }
}
