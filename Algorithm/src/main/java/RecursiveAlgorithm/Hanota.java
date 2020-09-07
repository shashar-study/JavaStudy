package RecursiveAlgorithm;/*** 软件版权：XX有限公司
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
/*汉诺塔问题*/
public class Hanota {
  public static void main(String[] args) {
   HanotaMove(3,"A","B","C");
  }
  public static void HanotaMove(int n, String from, String buffer, String to){
    if(n==1){
      System.out.println(from+"-->"+to);
      return;
    }else
    {
      HanotaMove(n-1,from,to,buffer);
      System.out.println(from+"-->"+to);
      HanotaMove(n-1,buffer,from,to);
    }
  }
}
