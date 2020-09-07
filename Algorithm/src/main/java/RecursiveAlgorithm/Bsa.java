package RecursiveAlgorithm;
/*** 软件版权：XX有限公司
 　　　　* 修改记录：
 　　　　* 修改日期   修改人员     修改说明
 　　　　* =========  ===========  ====================================
 　　　　 * 2020/5/19   shasha      新增
 　　　　* =========  ===========  ====================================
 　　　　*/

/**
 * 功能说明：
 * 　　　　* 开发人员：shasha shasha@qq.com <br>
 * 　　 　　* 开发时间：2020/5/19 <br>
 * 　　　　* 功能描述：写明作用，调用方式，使用场景，以及特殊情况 <br>
 *
 */

import java.util.Scanner;

/**
 * 二分法查找
 */
public class Bsa {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int[] arr={1,2,3,4,6,7,8,9,10};
    int left=0;
    int right=arr.length-1;
    int key=5;
    int bsa = BSA(arr, key, left, right);
    System.out.println(bsa);
  }

  private static int BSA(int[] arr,int key,int left,int right) {
    if(left>right) return -1;
    int mid=left+(right-left)/2;
    if(arr[mid]==key)
      return mid;
    else if(arr[mid]<key)
      return  BSA(arr,key,mid+1,right);
    else
      return  BSA(arr,key,left,mid-1);
  }
}
