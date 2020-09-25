package tongcheng58;

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;

import java.util.Scanner;

public class one {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    sc.close();
    //去空格
    String[] splitKongge = s.split("\\s+");
    StringBuilder sb = new StringBuilder();
    for (String s1 : splitKongge) {
      sb.append(s1);
    }
    String s1 = sb.toString();
    JexlEngine jexlEngine=new JexlBuilder().create();
    JexlExpression jexlExpression=jexlEngine.createExpression(s1);
    Object evaluate=jexlExpression.evaluate(null);
    System.out.println(evaluate);
  }
}
