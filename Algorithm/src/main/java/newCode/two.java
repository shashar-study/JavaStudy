package newCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author：shasha<br>
 * Time：2020/10/8 <br>
 * Description：
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class two {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    ArrayList<String> res = new ArrayList<>();
    dfs(0,0,"",n,res);
    for (String re : res) {
      System.out.println(re);
    }
  }
    private static void dfs(int left, int right, String str, int n, ArrayList<String> res){
      if(left==n&&right==left) {//一个匹配结果
        res.add(str);
        return;
      }
      if(left+1<=n) dfs(left+1,right,str+"(",n,res);
      if(right+1<=left) dfs(left,right+1,str+")",n,res);
    }


}
