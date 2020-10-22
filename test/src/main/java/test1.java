import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

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
    Map<Character,Integer> map=new HashMap<>();
    map.put('a',1);
    for (Character c : map.keySet()) {

    }
 String s="[1,2,3,4,null]";
    System.out.println(s.substring(1,s.length()-1));
    Stack<Integer> stack=new Stack<>();
    stack.push(
        10
    );
    stack.push(20);
    boolean empty = stack.isEmpty();
    System.out.println(stack.pop());
    System.out.println(stack.pop());

    List<Integer> res=new ArrayList<>();
/*    //数组扩容
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
    }*/

}
}
