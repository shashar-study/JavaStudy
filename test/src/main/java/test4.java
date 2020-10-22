/**
 * Author：shasha<br>
 * Time：2020/10/10 <br>
 * Description： <br>
 */
public class test4 {
  public static void main(String[] args) {
    String S="#fhewhfewj##";
    String chuli = chuli(S);
    System.out.println(chuli);
  }

  private static String chuli(String s) {
    char[] chars= s.toCharArray();
    StringBuilder sb=new StringBuilder();
    for (char c : chars) {
      if(c=='#'){
        if(sb.length()>0) {
          sb.deleteCharAt(sb.length() - 1);
        }
      }else
        sb.append(c);
    }
    return new String(sb);
  }
}
