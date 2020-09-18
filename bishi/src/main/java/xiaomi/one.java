package xiaomi;
/**
 * 题目描述：
 * 股票交易中：
 *
 * 人们将股票购买后，该股票价格开始下跌的情况，称为“被套”。
 *
 * 股票“被套”后，股票开始上涨并超过当时的购入价，称为“解套”。
 *
 * 如果这个股票一直下跌，很长时间都不能“解套”，则称为“套牢”。
 *
 * 现在小米同学生成了很多虚拟的股价，按时间顺序排序。
 *
 * 设计程序模拟一下在不同时间下购入该股票，会“被套”多长时间。
 *
 * 为简化计算，购入时开始“被套”（即使下一刻股票价格上涨），即最少“被套”时间为1。如果在最高价购入（即“套牢”，无法解套），用0表示。
 *
 *
 *
 * 输入描述
 * 模拟股票数据
 *
 * 第一行为总时长(0 < N < 200000)
 *
 * 第二行开始为每段时间的股价(0 < N < 500000)
 *
 * 输出描述
 * 每段时间“被套”的时间
 *
 *
 * 样例输入
 * 10
 * 11
 * 15
 * 16
 * 12
 * 8
 * 16
 * 18
 * 17
 * 11
 * 10
 * 样例输出
 * 1
 * 1
 * 4
 * 2
 * 1
 * 1
 * 0
 * 0
 * 0
 * 0
 *
 * 提示
 * 0. 11 //“被套”时间为1，在1“解套”
 * 1. 15 //“被套”时间为1，在2“解套“
 * 2. 16 //“被套”时间为4，在6“解套”
 * 3. 12 //“被套”时间为2，在5“解套“
 * 4. 8 //“被套”时间为1，在5“解套”
 * 5. 16 //“被套”时间为1，在6“解套”
 * 6. 18 ///被“套牢”，无法“解套”
 * 7. 17 ///被“套牢”，无法“解套”
 * 8. 11 ///被“套牢”，无法“解套”
 * 9. 10 //被“套牢”，无法“解套”*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*75%AC*/
public class one {


  /*请完成下面这个函数，实现题目要求的功能
  当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
  ******************************开始写代码******************************/
  static int[] stocks(int[] stocks) {
    int l=stocks.length;
    int[] ans=new int[l];
    for (int i = 0; i <l-1 ; i++) {
      for (int j = i+1; j <l ; j++) {
         if(stocks[j]>stocks[i]){
           ans[i]=j-i;
           break;
         }
      }
    }
    return ans;
  }
  /******************************结束写代码******************************/
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int[] res;

    int _stocks_size = 0;
    _stocks_size = Integer.parseInt(in.nextLine().trim());
    int[] _stocks = new int[_stocks_size];
    int _stocks_item;
    for(int _stocks_i = 0; _stocks_i < _stocks_size; _stocks_i++) {
      _stocks_item = Integer.parseInt(in.nextLine().trim());
      _stocks[_stocks_i] = _stocks_item;
    }

    res = stocks(_stocks);
    for(int res_i=0; res_i < res.length; res_i++) {
      System.out.println(String.valueOf(res[res_i]));
    }
  }
}
