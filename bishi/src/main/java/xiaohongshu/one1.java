package xiaohongshu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 消息分段
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 为了满足消息发送的要求，我们需要将一大段文本分成多个消息发送，每个消息最大长度不超过1024个英文字符，文本内容为英文字符和英文标点符号（包括”,”/“.”/“;”/“!”以及换行），为了尽可能保证可读性，我们希望每一个消息尽可能是分在段落结束。如果不行，可以分在句子结束。可以保证输入的文本内容每个句子长度不超过1024（包括符号）。请给出拆分算法。 String[] splitMsg(String textContent)
 *
 *
 *
 * 输入描述
 * 一段文本（英文字符加英文符号）。
 *
 * 输出描述
 * String的数组，每个数组长度不超过1024字节。
 *
 * 内容为分段或者分句。
 * */
public class one1 {
  static String[] splitMsg(String text) {
    int MAX_SIZE = 20;
    char[] tempArray =new char[MAX_SIZE];
    int lastParagraphEnd=0,lastSentenceEnd=0 , pos=0,lastTextPos=0;
    ArrayList<String> ret =new ArrayList<String>();//分组结果
    char[] textChars = text.toCharArray() ;
    char[] splited ;
    for (int textpos=0;textpos<textChars.length;) {
      char c = textChars[textpos++];
      tempArray[pos] = c ;
      if (c == '\n'){
        lastParagraphEnd = pos ;//段落末尾
      }else if ('.' == c || '!' == c){
        lastSentenceEnd = pos ;//句子末尾
      }
      pos++ ;
      if (pos==MAX_SIZE){
        int splitPos = lastParagraphEnd>0?lastParagraphEnd:lastSentenceEnd;
        //到大设定最大值，判断是否有段落末尾，有分割，没有按句末分割
        splited = new char[splitPos+1];//扩容
        System.arraycopy(tempArray,0,splited,0,splitPos+1);
        ret.add(new String(splited));
        lastParagraphEnd=0;
        lastSentenceEnd=0;
        pos=0;
        textpos = lastTextPos+splitPos+1;
        lastTextPos = textpos ;
      }
    }
    if (pos>0) {
      splited = new char[pos - 1];

      System.arraycopy(tempArray, 0, splited, 0, pos - 1);
      ret.add(new String(splited));
    }
    return ret.toArray(new String[]{}) ;
  }
  /******************************结束写代码******************************/


  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    String[] res;
    StringBuffer sb = new StringBuffer();
    while (in.hasNextLine()){
      String line = in.nextLine() ;
      if (line.length()==0)break;
      sb.append(line +"\n");
    }

    res = splitMsg(sb.toString());
    for(int res_i=0; res_i < res.length; res_i++) {
      System.out.println(String.format("msg%d:%s",res_i+1,res[res_i]));
    }

  }
}
