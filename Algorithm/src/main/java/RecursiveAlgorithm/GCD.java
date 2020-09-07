package RecursiveAlgorithm;
/*** 软件版权：XX有限公司
 　　　　* 修改记录：
 　　　　* 修改日期   修改人员     修改说明
 　　　　* =========  ===========  ====================================
 　　　　 * 2020/5/18   shasha      新增
 　　　　* =========  ===========  ====================================
 　　　　*/


/**
 * 功能说明：
 * 　　　　* 开发人员：shasha shasha@qq.com <br>
 * 　　 　　* 开发时间：2020/5/18 <br>
 * 　　　　* 功能描述：写明作用，调用方式，使用场景，以及特殊情况 <br>
 *
 */
/*欧几里得算法求最大公约数*/
public class GCD {
  public static void main(String[] args) {
    gcd(6,27);
  }

  private static void gcd(int a,int b) {
    if (a >= b) {
    if(a%b==0) {
      System.out.println("最大公约数为"+b);
      return;
    }
    gcd(b,a%b);
  }else
  gcd(b,a);
}


  }
