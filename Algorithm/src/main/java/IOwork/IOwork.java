package IOwork;
/*** 软件版权：XX有限公司
 　　　　* 修改记录：
 　　　　* 修改日期   修改人员     修改说明
 　　　　* =========  ===========  ====================================
 　　　　 * 2020/7/23   shasha      新增
 　　　　* =========  ===========  ====================================
 　　　　*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOwork {
  public static void main(String[] args) throws IOException {
    String filePath="C:\\Users\\shasha\\Desktop\\新建文件夹\\STK_MKT_LoseOrWin.txt";
    FileInputStream fileInputStream = new FileInputStream(filePath);
    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
    BufferedReader reader =new BufferedReader(inputStreamReader);
    String tempString=reader.readLine();
/*
    String table_name="";
    String kaitou="INSERT INTO "+table_name+" VALUES";
    System.out.println(kaitou);
    StringBuilder sb=new StringBuilder();
    tempString=reader.readLine();*/
    while(tempString!= null)
    {
    /*  String[] split = tempString.split("\t");
      int length=split.length;
     if(length==1){
       tempString=reader.readLine();
       continue;
     }else {
       for (int i = 0; i <length ; i++) {
         if(i==0)
           sb.append("("+split[0]);
         else if(i<length-1){
           sb.append(","+split[i]);
         }else
           sb.append(","+split[length-1]+")");
       }
       tempString=reader.readLine();
       if(tempString!=null)
         sb.append(",");
       else
         sb.append(";");
       System.out.println(sb);
       System.out.println();
     }

*/
      System.out.println(tempString);
      tempString=reader.readLine();
      }
    reader.close();
  }
  }
