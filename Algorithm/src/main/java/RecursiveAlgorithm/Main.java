package RecursiveAlgorithm;import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] grade=new int[n];
    for(int i=0;i<n;i++){
      grade[i]=sc.nextInt();
    }
    for(int g:grade){
      System.out.println(g);
    }

    int q=sc.nextInt();
    for(int i=0;i<q;i++){
      int g=sc.nextInt();
      System.out.println(g);
      quest(grade,g);
    }

  }
  public static void quest(int[] grade,int n){
    int target=grade[n-1];
    int count=0;
    for(int g:grade){
      if(g<=target)
        count++;
    }
    System.out.println(count);
    System.out.println((float)((count-1)/grade.length));
  }
}