package IOwork;

import sun.nio.cs.ext.GBK;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 功能说明：工作使用，读取文档内容，重新写入文档
 * 　　　　* 开发人员：shasha shasha@qq.com <br>
 * 　　 　　* 开发时间：2020/9/18 <br>
 * 　　　　* 功能描述：写明作用，调用方式，使用场景，以及特殊情况 <br>
 *
 */
public class IOreadAndWrite {
  public static void main(String[] args) throws IOException {
    //读取部分
    String filePath="E:\\WechatFiles\\WeChat Files\\wxid_yf0mr3xihdad22\\FileStorage\\File\\2020-09\\esse.log.2020-09-15";
    FileInputStream fileInputStream = new FileInputStream(filePath);
    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GBK");
    BufferedReader reader =new BufferedReader(inputStreamReader);
    String tempString=reader.readLine();
    //写入部分
    String outPath="C:\\Users\\shasha\\Desktop\\out.txt";
    FileOutputStream fileOutputStream=new FileOutputStream(outPath);
    OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream, "GBK");
    BufferedWriter writer=new BufferedWriter(outputStreamWriter);
    boolean flag=true;
    while(tempString!= null) {
      if (flag){
        if(tempString.contains("保存任务开始"))
          flag=false;
        else{
          writer.write(tempString);
          writer.newLine();
        }

      }else {
        if(tempString.contains("保存任务结束"))
          flag=true;
      }
      tempString=reader.readLine();
    }
    reader.close();
    writer.close();
  }
}
