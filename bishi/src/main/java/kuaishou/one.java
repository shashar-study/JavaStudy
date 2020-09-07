package kuaishou;

import java.util.Scanner;

/*
* 第一行是一个整数k，表示子串中有k个1就有可能是病毒。其中 0 <= k <= 1 000 000
第二行是一个字符串，就是library的代码部分的二进制表示。字符串长度 <= 1 000 000。并且字符串中只包含"0"或"1".'
*
* 输入例子1:
1
1010
输出例子1:
6
例子说明1:
满足条件的子串有："1", "1", "10", "01", "10", "010".*/
public class one {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int k=sc.nextInt();
    String library=sc.nextLine();
    int length=library.length();
    int[] newLibrary=new int[length];
    char[] chars = library.toCharArray();
    for (int i = 0; i <length ; i++) {
      newLibrary[i]=chars[i]-'0';
    }
    int count=0;
    int num=0;
    for (int i = 0; i <length ; i=i+num) {
      while(newLibrary[i]==0){
        num++;
        i++;
      }
      int jishu=0;
     while(newLibrary[i]==1&&jishu<=k){
       i++;
       jishu++;
     }
     if(jishu==k){}
      }
    }

  }
