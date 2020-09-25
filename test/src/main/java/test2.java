import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author：shasha<br>
 * Time：2020/9/24 <br>
 * Description： 字符串正则解析匹配<br>
 */
public class test2 {
  public static void main(String[] args) {
    String formula="@ST{35851.480.YIELD}=@ST{35851.480.VALUE}/@IP{35851}";
    String reg = "@[A-Z]+\\{\\d+.\\d+.[A-Z]+\\}|@[A-Z]+\\{\\d+\\}";
    Pattern p = Pattern.compile(reg);
    //让正则对象和要作用的字符串相关联。获取匹配器对象。
    Matcher m  = p.matcher(formula);
    int count = m.groupCount();
    System.out.println(count);
    while(m.find())
    {
      String key = m.group();
      System.out.println("key=="+key);
      String str = key.replaceAll("[@[A-Z]+\\{,\\}]","");
      System.out.println("str="+str);
      String str1 = key.replaceAll("[@,\\{,\\}]","").replaceAll("\\.","");
      System.out.println("str1="+str1);
      String typeKey = key.substring(key.indexOf("@")+1,key.indexOf("{"));
      System.out.println("typeKey="+typeKey);
    }

  }
}
