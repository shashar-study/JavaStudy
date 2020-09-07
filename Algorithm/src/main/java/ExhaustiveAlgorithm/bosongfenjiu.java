package ExhaustiveAlgorithm;
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
/*
* 泊松分酒
* */
public class bosongfenjiu {
  public static void main(String[] args) {
    bosongfenjiu bj=new bosongfenjiu();
    bj.share(12,0,0);
  }
  //给定初始的容器大小
  private int b1=12;
  private int b2 = 8;
  private int b3 = 5;
  //目标是倒出6L酒
  private int rs = 6;
  public void share(int bb1,int bb2,int bb3){
    System.out.println("bb1:"+bb1+"~~bb2:"+bb2+"~~bb3:"+bb3);//查看每次倒酒个容器中酒量的变化
    if(bb1==rs||bb2==rs||bb3==rs){//若 有容器满足目标条件 程序退出
      System.out.println("find the bottle");
      return;
    }
    if(bb2==0){
      //容器二为空，向容器2倒酒
      if(bb1>=bb2){ // 容器一的酒可倒满容器二
        share(bb1-b2,b2,bb3);
      }else{
        share(0,bb1,bb3);
      }
    }else if(bb2!=0&&bb3!=b3){//容器二不为空并且容器三酒没有倒满
      if(bb2+bb3<b3){ //容器二 的酒倒入容器三不能使容器三倒满
        // dao bu man
        share(bb1,0,bb3+bb2);
      }else{
        share(bb1,bb2-(b3-bb3),b3);
      }
    }else if(bb3==b3){ //容器三倒满后向容器一倒酒
      if(bb3+bb1<b1){
        //dao bu man
        share(bb1+bb3,bb2,0);
      }else{
        share(b1,bb2,bb3-(b1-bb1));
      }
    }
  }


}
