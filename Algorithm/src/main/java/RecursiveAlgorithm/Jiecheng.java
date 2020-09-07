package RecursiveAlgorithm;
/*** 软件版权：XX有限公司
 　　　　* 修改记录：
 　　　　* 修改日期   修改人员     修改说明
 　　　　* =========  ===========  ====================================
 　　　　 * 2020/5/19   shasha      新增
 　　　　* =========  ===========  ====================================
 　　　　*/

/**
 * 功能说明：
 * 　　　　* 开发人员：shasha shasha@qq.com <br>
 * 　　 　　* 开发时间：2020/5/19 <br>
 * 　　　　* 功能描述：写明作用，调用方式，使用场景，以及特殊情况 <br>
 *
 */
public class Jiecheng {
  public static void main(String[] args) {
    int n=30;
    System.out.println(n+"的阶乘是"+ f(n));

  }

  private static int f(int n) {
  if(n==1)
    return 1;
  else
    return n*f(n-1);
  }
}
