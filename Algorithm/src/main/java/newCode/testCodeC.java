package newCode;


import org.apache.poi.ss.formula.functions.T;

/**
 * Author：shasha<br>
 * Time：2020/10/9 <br>
 * Description： <br>
 */
public class testCodeC {
  public static void main(String[] args) {
    TreeNode root=new TreeNode(1);
    root.left=new TreeNode(2);
    root.right=new TreeNode(3);
    root.right.left=new TreeNode(4);
    root.right.right=new TreeNode(5);

    Codec codec=new Codec();
    String serialize = codec.serialize(root);
    System.out.println(serialize);
    TreeNode ans = codec.deserialize(serialize);
  }
}
