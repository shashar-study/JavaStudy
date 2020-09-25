package tiger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class three {
  public static List<Integer> help;
  public static int count=0;
  public static void main(String[] args) {
    //八皇后，递归输入，判断
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    List<Integer> shuru=new ArrayList<Integer>();
    for (int i = 0; i <n ; i++) {
      shuru.add(sc.nextInt());
    }
    sc.close();

  }

  private static void tiaozheng(List<Integer> shuru) {
    if(shuru.size()==0){
      shuchu(help);
    }else{
      int i,target = 0;
      for (i=0;i<shuru.size();i++) {
        target=shuru.get(i);
        if(check(help,target)){
          help.add(target);
          shuru.remove(i);
          tiaozheng(shuru);
        }
    }

        //回退到当前步骤
      shuru.add(target);
      help.remove(target);

    }
  }

  private static void shuchu(List<Integer> help) {
    for (Integer integer : help) {
      System.out.println(integer);
    }
  }

  private static boolean check(List<Integer> help,int i) {
    int size=help.size();
    if(help==null||size<=0){
      return true;
    }
    if(size%2==0){
      if(help.get(size)>=i)
        return true;
      else
        return false;
    }else{
      if (help.get(size)<=i)
        return  true;
      else
        return false;
    }
  }
}
