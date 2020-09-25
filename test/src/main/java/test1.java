import java.util.Arrays;

/**
 * Author：shasha<br>
 * Time：2020/9/24 <br>
 * Description： <br>
 */
public class test1 {
  int a=0;
  int b=1;
  public static void main(String[] args) {
    int[] ans=new int[3];
    ans[0]=10;ans[1]=20;ans[2]=5;

   //数组扩容
    int[] newans=java.util.Arrays.copyOf(ans,6);
    for (int newan : newans) {
      System.out.println(newan);
    }
    System.out.println("==========");
    //数组缩减
    int[] suoxiao= Arrays.copyOf(ans,2);
    System.out.println(suoxiao.length);
    for (int i : suoxiao) {
      System.out.println(i);
    }

}
}
