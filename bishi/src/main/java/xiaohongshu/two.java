package xiaohongshu;

import java.util.Scanner;
import java.util.Stack;

/*
* 薯队长写了一篇笔记草稿，请你帮忙输出最后内容。
 1.输入字符包括，"("    ,    ")"    和    "<"和其他字符。
2.其他字符表示笔记内容。
 3.()之间表示注释内容，任何字符都无效。    括号保证成对出现。
 4."<"表示退格,    删去前面一个笔记内容字符。括号不受"<"影响    。

输入描述:
输入一行字符串。长度<=10000.

输出描述:
输出一行字符串，表示最终的笔记内容。

输入例子1:
Corona(Trump)USA<<<Virus

输出例子1:
CoronaVirus*/
public class two {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    StringBuilder sb=new StringBuilder();
    int length=s.length();
    Stack stack=new Stack();
    for (int i = 0; i <length ; i++) {
      char c=s.charAt(i);
      if(c=='(')
        stack.push(stack.capacity()+1);
      else if(c==')') {
        stack.pop();
      } else if(stack.empty()){
        if(c=='<'){
          sb.deleteCharAt(sb.length()-1);
        }else{
          sb.append(c);
        }
      }
      }
    System.out.println(sb.toString());
  }
}
