package ExcelRead;

import ExcelRead.listener.TableDataListener;
import ExcelRead.pojo.TableInfo;
import com.alibaba.excel.EasyExcel;
import org.junit.Test;

/**
 * 功能说明：
 * 　　　　* 开发人员：shasha shasha@qq.com <br>
 * 　　 　　* 开发时间：2020/7/28 <br>
 * 　　　　* 功能描述：写明作用，调用方式，使用场景，以及特殊情况 <br>
 *
 */
public class readTest {
  @Test
  public void simpleRead() {
    // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
    String fileName ="C:\\Users\\shasha\\Desktop\\需求\\财务报表\\公司研究系列-财务报表-利润表.xlsx";

    // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
    System.out.println("id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,");
    EasyExcel.read(fileName, TableInfo.class, new TableDataListener()).sheet().doRead();

  }
}
