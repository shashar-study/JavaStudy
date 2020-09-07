package xiaohongshu;

import java.util.Scanner;

/**
 * 1
 * 2
 * 3
 * 4
 * 输入一串字符，请编写一个字符串压缩程序，将字符串中连续出现的重复字母进行压缩，并输出压缩后的字符串。
 * 例如：
 * aac 压缩为 1ac
 * xxxxyyyyyyzbbb 压缩为 3x5yz2b
 *
 *
 * 输入描述:
 * 任意长度字符串
 *
 * 输出描述:
 * 压缩后的字符串
 *
 * 输入例子1:
 * xxxxyyyyyyzbbb
 *
 * 输出例子1:
 * 3x5yz2b*/
public class eight {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String str=sc.nextLine();
    char[] chars = str.toCharArray();
    StringBuilder ans=new StringBuilder();
    int count=0;
    int l=chars.length;
    for (int i = 0; i <l-1 ; i++) {
      if(chars[i]==chars[i+1]){
        count++;
      }else{
        if(count!=0){
          ans.append(count);
          count=0;
        }
        ans.append(chars[i]);
      }
    }
    if(count!=0)
      ans.append(count);
    ans.append(chars[l-1]);
    System.out.println(ans.toString());
  }
}
