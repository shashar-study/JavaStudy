package pinduoduo;

import java.util.Scanner;

/**
 * A 国的手机号码由且仅由 N 位十进制数字(0-9)组成。一个手机号码中有至少 K 位数字相同则被定义为靓号。A 国的手机号可以有前导零，比如 000123456 是一个合法的手机号。
 * 小多想花钱将自己的手机号码修改为一个靓号。修改号码中的一个数字需要花费的金额为新数字与旧数字之间的差值。比如将 1 修改为 6 或 6 修改为 1 都需要花 5 块钱。
 * 给出小多现在的手机号码，问将其修改成一个靓号，最少需要多少钱？
 *
 * 输入描述:
 * 第一行包含2个整数 N、K，分别表示手机号码数字个数以及靓号至少有 K 个数字相同。
 * 第二行包含 N 个字符，每个字符都是一个数字('0'-'9')，数字之间没有任何其他空白符。表示小多的手机号码。
 * 数据范围：
 * 2 <= K <= N <= 10000
 *
 * 输出描述:
 * 第一行包含一个整数，表示修改成一个靓号，最少需要的金额。
 * 第二行包含 N 个数字字符，表示最少花费修改的新手机号。若有多个靓号花费都最少，则输出字典序最小的靓号。
 *
 * 输入例子1:
 * 6 5
 * 787585
 *
 * 输出例子1:
 * 4
 * 777577
 *
 * 例子说明1:
 * 花费为4的方案有两种：777577与777775，前者字典序更小。*/
public class one {
  public static void main(String[] args) {
      problem1_2019();
    }

    /**思路：
     * 统计初始号码中每个数字（0~9）出现的频率，记录在num中
     * num[i]表示数字i出现的频率
     * 考虑极端情况，若是初始号码就满足靓号需求，即某个数字的频率大于等于K，则无需处理，直接输出
     * 考虑一般情况，暴力枚举修改成每个字符0~9需要花费的价格，选取最小花费
     * 例如，想要把初始号码修改成有K个数字i的靓号，
     * int gap=k - nums[i] 为初始需要修改的次数，为了保证字典序最小，
     * 优先从前往后把大于i数数字改小，然后从后前往把小的数字改大，
     * 每次修改需要修改的次数是数字i+p/i-p(修改前需要判断这两个数字是否在0~9之中)
     * 的频率和当前gap中最小值
     * int p=1,是指先改比i多1的，再该比i少1的，p++是指，若果差值绝对值为1的改完之后
     * 仍然不符合靓号标准，再改绝对值差为2的，以此类推，0~9中每一个数字i，计算改成k个数字i的花费，
     * 每次去之前的cost和当前tmpCost最小值，如果当前tmpCost更小，更新结果集为当前靓号*/
    public static void problem1_2019() {
      Scanner scanner = new Scanner(System.in);
      int n = scanner.nextInt();
      int k = scanner.nextInt();
      scanner.nextLine();
      String str = scanner.nextLine();
      char[] phone = str.toCharArray();
      int[] nums = new int[10];//用于存储每个数字的频率
      for (int i = 0; i < n; i++) {
        nums[phone[i] - '0']++;
      }
      int cost = Integer.MAX_VALUE;
      String res = "";//存储结果集
      for (int i = 0; i < 10; i++) {
        int tmpCost = 0;
        char[] tmpRes = phone.clone();

        int gap = k - nums[i];//如果修改为i,需要修改的次数
        //对k和每一个数字的频率进行对比，若是本身集合符合条件的靓号，则不用修改
        if (gap <= 0) {
          System.out.println(0);
          System.out.println(str);
          return;
        }

        int p = 1;
        while (gap > 0) {
          int change = i+p;
          // 大改小
          if (change < 10) {
            int min = Math.min(gap,nums[change]);
            gap -= min;
            tmpCost += p*min;
            // 从前往后
            for (int l = 0; l < n; l++) {
              if (tmpRes[l] - '0' == change) {
                tmpRes[l] = (char) (i + '0');
                min--;
                if (min == 0)
                  break;
              }
            }

          }

          if (gap == 0)
            break;

          change = i - p;
          // 小改大
          if (change >= 0) {
            int min = Math.min(gap, nums[change]);
            gap -= min;
            tmpCost += p*min;
            // 从后往前
            for (int l = n-1; l >= 0; l--) {
              if (tmpRes[l]-'0' == change) {
                tmpRes[l] = (char)(i+'0');
                min--;
                if (min == 0)
                  break;
              }
            }
          }
          p++;
        }
        if (tmpCost < cost) {
          cost = tmpCost;
          res = String.valueOf(tmpRes);
        }
      }
      System.out.println(cost);
      System.out.println(res);
    }
}
