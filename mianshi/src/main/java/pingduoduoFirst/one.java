package pingduoduoFirst;
/**
 * 不使用乘除法，计算A*B*/
public class one {
  public static void main(String[] args) {
    int A=10;
    int B=5;
    System.out.println(MehtodOne(A,B));
    System.out.println(MehtodTwo(A,B));
  }

  private static int MehtodTwo(int a, int b) {
    int yushu=0;
    if(a<b){
      int tmp=a;
      a=b;
      b=tmp;
    }
      while(b>=2){
      if(b%2==1){
        yushu+=a;
      }
      b=b>>1;
      a=a<<1;
      }
    return a+yushu;
  }

  private static int MehtodOne(int a, int b) {
    if(a<b){
      int tmp=a;
      a=b;
      b=tmp;
    }
    int sum=0;
    for (int i = 0; i < b; i++) {
      sum+=a;
    }
    return  sum;
  }

}
