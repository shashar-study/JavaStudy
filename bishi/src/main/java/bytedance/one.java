package bytedance;

import java.util.Scanner;

/*
* 1. 三个同样的字母连在一起，一定是拼写错误，去掉一个的就好啦：比如 helllo -> hello
2. 两对一样的字母（AABB型）连在一起，一定是拼写错误，去掉第二对的一个字母就好啦：比如 helloo -> hello
3. 上面的规则优先“从左到右”匹配，即如果是AABBCC，虽然AABB和BBCC都是错误拼写，应该优先考虑修复AABB，结果为AABCC*/
public class one {
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int line = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < line; i++) {
        //将AA或AAA替换成AA;将AABB替换成AAB
        System.out.println(sc.nextLine().replaceAll("(.)\\1+","$1$1").replaceAll("(.)\\1(.)\\2","$1$1$2"));
    }
   }
}