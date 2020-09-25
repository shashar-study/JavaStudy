package tongcheng58;
public class two {
  public static void main(String[] args) {

  }
  public int[] countBits (int num) {
    // write code here
    int[] ans=new int[num+1];
    int count=2;
    ans[1]=1;
    for (int i = 2; i <num+1 ; i++) {
      if(i==count){
        ans[i]=1;
      }else if(i>count&&i<count*2){
        ans[i]=1+ans[i-count];
      }else if(i==count*2){
        count*=2;
        ans[i]=1;
      }
      }
    return ans;
  }
}
