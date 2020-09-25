package tiger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class one {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int N=sc.nextInt();//总的项目数量
    int W=sc.nextInt();//初始资金
    int K=sc.nextInt();//最多可以做的项目数量
    List<Integer> cost=new ArrayList<Integer>(); //每个项目需要的启动资金
    List<Integer> profits=new ArrayList<Integer>(); //每个项目做完后的利润
    for (int i = 0; i <N ; i++) {
      cost.add(sc.nextInt());
    }
    for (int i = 0; i <N ; i++) {
      profits.add(sc.nextInt());
    }
    int max=Integer.MIN_VALUE;
    int index=0;//标识现在选择的项目编号
    while(K!=0){
      for (int i = 0; i <cost.size(); i++) {
        if(W>=cost.get(i)){
          if(max<profits.get(i)){
            max=profits.get(i);
            index=i;
          }
        }
      }
      K--;
      W+=profits.get(index);
      cost.remove(index);
      profits.remove(index);
    }
    System.out.println(W);
  }
}
