package newCode;

/**
 * Author：shasha<br>
 * Time：2020/10/9 <br>
 * Description： <br>
 */
public class Codec {
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode(int x) { val = x; }
   * }
   */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      StringBuilder sb=new StringBuilder("[");
      sb.append(root.val);
      sb.append(",");
      serialize(root,sb);
      sb.deleteCharAt(sb.length()-1);
      sb.append("]");
      return new String(sb);
    }
    public void serialize(TreeNode root,StringBuilder sb){
        if(root.left!=null){
          sb.append(root.left.val);
          sb.append(",");
        }else
          sb.append("null,");

        if(root.right!=null){
          sb.append(root.right.val);
          sb.append(",");
        }else
          sb.append("null,");

        if(root.left!=null)
          serialize(root.left,sb);
        if(root.right!=null)
          serialize(root.right,sb);
      }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      String newdata=data.substring(1,data.length()-1);
      String[] split=newdata.split(",");
      TreeNode res=deserialize(split,0);
      return res;
    }
    public TreeNode deserialize(String[] data,int i){
      if(i>=data.length)
        return null;
      if(data[i].equals("null"))
        return null;
      TreeNode head=new TreeNode(Integer.parseInt(data[i]));
      head.left=deserialize(data,2*i+1);
      head.right=deserialize(data,2*i+2);
      return head;
    }
}
