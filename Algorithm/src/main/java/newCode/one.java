package newCode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Author：shasha<br>
 * Time：2020/10/7 <br>
 * Description： 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *  输入： nums = [1,2,3]
 *  输出：
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class one {
  public static void main(String[] args) {
    int[] nums={1,2,3,4,5,6};
    List<List<Integer>> one = methodOne(nums);
    List<List<Integer>> two = methodTwo(nums);
    List<List<Integer>> three = methodThree(nums);
    for (List<Integer> list : one) {
      for (Integer integer : list) {
        System.out.print(integer+" ,");
      }
      System.out.println();
    }
    System.out.println("=========");

    for (List<Integer> list : two) {
      for (Integer integer : list) {
        System.out.print(integer+" ,");
      }
      System.out.println();
    }
    System.out.println("=========");
    for (List<Integer> list : three) {
      for (Integer integer : list) {
        System.out.print(integer+" ,");
      }
      System.out.println();
    }
  }
  private static List<List<Integer>>   methodThree(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    int bmp = (int) Math.pow(2, nums.length);
    for (int i = 0; i < bmp; i++) {
      List<Integer> subset = new ArrayList<>();
      String string = Integer.toBinaryString(i);
      for (int j = 0; j <string.length() ; j++) {
        if(string.charAt(j)=='1')
          subset.add(nums[j]);
      }
      subsets.add(subset);
    }
    return subsets;
  }

  private static List<List<Integer>> methodTwo(int[] nums) {
      List<List<Integer>> subsets = new ArrayList<>();
      int bmp = (int) Math.pow(2, nums.length);
      // 从 nums.length 个 0 遍历到 nums.length 个 1
      for (int i = 0; i < bmp; i++) {
        List<Integer> subset = new ArrayList<>();
        for (int j = 0; j < nums.length; j++)
          // 将每一位右移最低位，检测其是否为1
          if ((i >>> j & 1) == 1) subset.add(nums[j]);
        subsets.add(subset);
      }
      return subsets;
    }

  public static List<List<Integer>> methodOne(int[] nums) {
    List<List<Integer>> ans=new ArrayList<List<Integer>>();
    ans.add(new ArrayList<>());
    for(int n:nums){
      int size=ans.size();
      for(int i=0;i<size;i++){
        List<Integer> help=new ArrayList<>();
        //将原来的元素集合全部加入新集合中
        help.addAll(ans.get(i));
        //将当前元素加入到新集合中
        help.add(n);
        //结果集
        ans.add(help);
      }
    }
    return ans;

  }
}
