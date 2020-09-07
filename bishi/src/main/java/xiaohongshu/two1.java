package xiaohongshu;

import java.util.Scanner;

public class two1 {
  static int maxBoxes(int[][] boxes) {
    //对数组第一列进行冒泡排序
    int l=boxes.length;
    for (int i = 0; i <l ; ++i) {
      boolean flag=false;
      for (int j = 0; j <l-i-1 ; j++) {
        if (boxes[j][0]>boxes[j+1][0]){
          int tem=boxes[j][0];
          boxes[j][0]=boxes[j+1][0];
          boxes[j+1][0]=tem;
          tem=boxes[j][1];
          boxes[j][1]=boxes[j+1][1];
          boxes[j+1][1]=tem;
          flag=true;
        }
      }
      if(!flag)break;//不再进行交换，退出
    }
    //对数据第二列进行冒泡排序
    for (int i = 0; i <l ; ++i) {
      boolean flag=false;
      for (int j = 0; j <l-i-1 ; j++) {
        if (boxes[j][1]>boxes[j+1][1]){
          int tem=boxes[j][0];
          boxes[j][0]=boxes[j+1][0];
          boxes[j+1][0]=tem;
          tem=boxes[j][1];
          boxes[j][1]=boxes[j+1][1];
          boxes[j+1][1]=tem;
          flag=true;
        }
      }
      if(!flag)break;//不再进行交换，退出
    }
    int count=1;
    for (int i=0;i<l-1;i++){
      if (boxes[i][1]<boxes[i+1][1]){
        count++;
      }else
        break;
    }
    return count;
  }
  /******************************结束写代码******************************/


  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int res;

    int _boxes_rows = 0;
    int _boxes_cols = 0;
    _boxes_rows = Integer.parseInt(in.nextLine().trim());
    _boxes_cols = Integer.parseInt(in.nextLine().trim());

    int[][] _boxes = new int[_boxes_rows][_boxes_cols];
    for(int _boxes_i=0; _boxes_i<_boxes_rows; _boxes_i++) {
      for(int _boxes_j=0; _boxes_j<_boxes_cols; _boxes_j++) {
        _boxes[_boxes_i][_boxes_j] = in.nextInt();

      }
    }

    if(in.hasNextLine()) {
      in.nextLine();
    }

    res = maxBoxes(_boxes);
    System.out.println(String.valueOf(res));

  }
}

