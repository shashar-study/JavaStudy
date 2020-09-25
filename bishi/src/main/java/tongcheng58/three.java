package tongcheng58;

import java.util.ArrayList;

public class three {
  public static void main(String[] args) {


  }
  public static ArrayList<Integer> mergerArrays (ArrayList<Integer> arrayA, ArrayList<Integer> arrayB) {
    // write code here
    ArrayList<Integer> ans=new ArrayList<Integer>();
    int sizeA=arrayA.size();
    int sizeB=arrayB.size();
    int i=0;int j=0;
    while(i<sizeA&&j<sizeB){
      int A=arrayA.get(i);
      int B=arrayB.get(j);
      if (A==B){
        ans.add(A);
      }else if(A<B){
        i++;
      }else
        j++;
    }
    return ans;
  }
}
