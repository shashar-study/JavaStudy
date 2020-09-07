package pinduoduo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 小多想在美化一下自己的庄园。他的庄园毗邻一条小河，他希望在河边种一排树，共 M 棵。
 * 小多采购了 N 个品种的树，每个品种的数量是 Ai (树的总数量恰好为 M)。
 * 但是他希望任意两棵相邻的树不是同一品种的。小多请你帮忙设计一种满足要求的种树方案。
 *
 * 输入描述:
 * 第一行包含一个正整数 N，表示树的品种数量。
 * 第二行包含 N 个正整数，第 i (1 <= i <= N) 个数表示第 i 个品种的树的数量。
 * 数据范围：
 * 1 <= N <= 1000
 * 1 <= M <= 2000
 *
 * 输出描述:
 * 输出一行，包含 M 个正整数，分别表示第 i 棵树的品种编号 (品种编号从1到 N)。
 * 若存在多种可行方案，则输出字典序最小的方案。若不存在满足条件的方案，则输出"-"。
 *
 * 输入例子1:
 * 3
 * 4 2 1
 *
 * 输出例子1:
 * 1 2 1 2 1 3 1*/

/**
 * 算法：DFS、剪枝优化
 * 数据结构：ArrayList
 * 剪枝思路：每次搜索之前判断当前剩余的空间大小和任意品种的树之间的关系:
 * 1) 如果freeSpaceSize为偶数，那么只要treeQuantityArray[treeCategory] > freeSpaceSize / 2，就不能保证相邻树种不同
 * 2) 如果freeSpaceSize为奇数，那么只要treeQuantityArray[treeCategory] > (freeSpaceSize + 1) / 2，就不能保证相邻树种不同
 * tip：freeSpaceSize为偶数时，treeQuantityArray[treeCategory] > freeSpaceSize / 2 和treeQuantityArray[treeCategory] > (freeSpaceSize + 1) / 2的值是相等的。
 * 所以可以统一使用treeQuantityArray[treeCategory] > (freeSpaceSize + 1) / 2的关系来做剪枝优化！
 */

public class two {
  //剩余空间大小是否能保证，在相邻树种不同的情况下，能放下任意品种的树（够放最大数量的树种）
  private static boolean checkIfFreeSpaceEnough(int treeCategorySize, int[] treeQuantityArray, int freeSpace) {
    for (int treeCategory = 1; treeCategory <= treeCategorySize; treeCategory++) {
      if (treeQuantityArray[treeCategory] > (freeSpace + 1) / 2) {
        return false;
      }
    }
    return true;
  }

  //深度优先搜索，寻找是否存在按规则分布的序列
  private static boolean DFS(int treeDistributionIndex, int[] treeQuantityArray, int treeCategorySize,
                             List<String> treeDistributionList, int treeQuantitySum) {
    //形成按规则分布的序列，DFS成功标志
    if (treeDistributionIndex == treeQuantitySum) {
      return true;
    }
    //剩余空间是否充足，剩余空间即剩下要放的树的数量
    int freeSpace = treeQuantitySum - treeDistributionIndex;
    if (! checkIfFreeSpaceEnough(treeCategorySize, treeQuantityArray, freeSpace)) {
      return false;
    }
    for (int treeCategory = 1; treeCategory <= treeCategorySize; treeCategory ++) {//字典序实现
      //treeQuantityArray[treeCategory] != 0表示某一树种不用尽
      //treeCategory != Integer.valueOf(treeDistributionList.get(treeDistributionIndex - 1))表示相邻树种不该相同
      if (treeDistributionIndex == 0 ||
          treeQuantityArray[treeCategory] != 0 &&
              treeCategory != Integer.valueOf(treeDistributionList.get(treeDistributionIndex - 1))) {
        treeQuantityArray[treeCategory] --;
        //int值+""->String
        treeDistributionList.add(treeCategory + "");
        if (DFS(treeDistributionIndex + 1, treeQuantityArray, treeCategorySize, treeDistributionList, treeQuantitySum)) {
          return true;
        }
        //某一条分路走不下去返回false了（放树顺序错了，如放该种树后面数目更大的树种将放不下）
        //回退，跳过该树放数目更大的树种
        treeQuantityArray[treeCategory] ++;
        treeDistributionList.remove(treeDistributionList.size() - 1);//将序列末尾值去除
      }
    }
    //无法形成按规则分布的序列，dfs失败标志
    return false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int treeCategorySize = sc.nextInt();//树的品种数量
    int[] treeQuantityArray = new int[treeCategorySize + 1];//每个树种对应的数量
    int treeQuantitySum = 0;//已经栽种的总数量
    //题目要求树种从1开始
    for (int treeCategory = 1; treeCategory <= treeCategorySize; treeCategory ++) {
      treeQuantityArray[treeCategory] = sc.nextInt();
      treeQuantitySum += treeQuantityArray[treeCategory];
    }
    sc.close();
    List<String> treeDistributionList = new ArrayList<String>();
    //若存在按规则分布的序列
    if (DFS(0, treeQuantityArray, treeCategorySize, treeDistributionList, treeQuantitySum)) {
      System.out.println(String.join(" ",treeDistributionList));//分布序列元素间加上空格
    }
    //若不存在按规则分布的序列
    else {
      System.out.println("-");
    }
  }
}

