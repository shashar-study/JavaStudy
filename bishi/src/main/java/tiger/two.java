package tiger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class two {
  public static void main(String[] args) {
    int[] arr={1, 2, 4, 4, 3, 3, 1, 5, 3};
    int[] ans=help(arr);
    for (int an : ans) {
      System.out.print(an+",");
    }
  }

  private static int[] help(int[] arr) {
    Arrays.sort(arr);
    List<Integer> list=new ArrayList<Integer>();
    int  help=arr[0];
    for (int i = 1; i <arr.length ; i++) {
       if(help==arr[i]){
         if(!list.contains(help))
             list.add(help);
       } else
         help=arr[i];
    }
    int size=list.size();
    int[] ans=new int[size];
    for (int i = 0; i <size ; i++) {
      ans[i]=list.get(i);
    }
    return  ans;
  }
}
