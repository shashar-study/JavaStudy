package GreedyAlgorithm;
/*** 软件版权：XX有限公司
 　　　　* 修改记录：
 　　　　* 修改日期   修改人员     修改说明
 　　　　* =========  ===========  ====================================
 　　　　 * 2020/5/19   shasha      新增
 　　　　* =========  ===========  ====================================
 　　　　*/

import java.util.Scanner;

/**
 * 功能说明：
 * 　　　　* 开发人员：shasha shasha@qq.com <br>
 * 　　 　　* 开发时间：2020/5/19 <br>
 * 　　　　* 功能描述：写明作用，调用方式，使用场景，以及特殊情况 <br>
 *
 */
/*背包问题
* 有一个背包，背包容量是M=150kg。有7个物品，物品不可以分割成任意大小。要求尽可能让装入背包中的物品总价值最大，但不能超过总容量。
物品 A B C D E F G
重量 35kg 30kg 6kg 50kg 40kg 10kg 25kg
价值 10$ 40$   30$ 50$ 35$   40$  30$
* 并非最优解
* */
public class bag {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("请输入背包容量：");
    int M=sc.nextInt();
    System.out.println("请输入物品个数：");
    int num=sc.nextInt();
    System.out.println("请输入物品重量");
    int[] weight=new int[num];
    int[] value=new int[num];
    for (int i = 0; i <num ; i++) {
      weight[i]=sc.nextInt();
    }
    System.out.println("请输入物品价值");
    for (int i = 0; i <num ; i++) {
      value[i]=sc.nextInt();
    }
    bagProblem(M,weight,value,num);
  }

  private static void bagProblem(int m, int[] weight, int[] value,int num) {
    double[] r=new double[num];//性价比
    int[] xiabiao=new int[num];//下标
    for (int i = 0; i <num ; i++) {
      r[i]=(double)(value[i]/weight[i]);
      xiabiao[i]=i;
    }

    //冒泡排序
    for (int i = 0; i <num-1; i++) {
      for (int j = i+1; j <num ; j++) {
        if(r[i]<r[j]){
          double temp1=r[i];
          int temp2=xiabiao[i];
          r[i]=r[j];
          r[j]=temp1;
          xiabiao[i]=xiabiao[j];
          xiabiao[j]=temp2;
        }
      }
    }
    //获取性价比高的物品价格和质量数组排序
    int[] newValue=new int[num];
    int[] newWeight=new int[num];
    for (int i = 0; i <num ; i++) {
      newValue[i]=value[xiabiao[i]];
      newWeight[i]=weight[xiabiao[i]];
    }

    //打印输出结果
    int finalValue=0;
    int finalWeight=0;
    for (int i = 0; i <num ; i++) {
      if(m>newWeight[i]){
        finalValue+=newValue[i];
        finalWeight+=newWeight[i];
        m-=newWeight[i];
        System.out.println("重量为"+newWeight[i]+"，价格为"+newValue[i]+"的物品放入背包");
      }else
        break;
    }
    System.out.println("最终放入物品的总价格为"+finalValue+",总重量为"+finalWeight);
  }

}
