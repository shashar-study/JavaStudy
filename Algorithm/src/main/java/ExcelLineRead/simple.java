package ExcelLineRead;
/**
 * 功能说明：
 * 　　　　* 开发人员：shasha shasha@qq.com <br>
 * 　　 　　* 开发时间：2020/8/12 <br>
 * 　　　　* 功能描述：写明作用，调用方式，使用场景，以及特殊情况 <br>
 *
 */

import java.io.File;


import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class simple {
  public static void main(String[] args) {
    try {
      File file = new File("C:\\Users\\shasha\\Desktop\\FS_Combas.xls" +
          ""); // 创建文件对象
      Workbook wb = Workbook.getWorkbook(file); // 从文件流中获取Excel工作区对象（WorkBook）
      Sheet sheet = wb.getSheet(0); // 从工作区中取得页（Sheet）
      for (int i = 0; i < sheet.getRows(); i++) { // 循环打印Excel表中的内容
        for (int j = 0; j < sheet.getColumns(); j++) {
          Cell cell = sheet.getCell(j, i);
          System.out.printf(cell.getContents()+" ");
        }
        System.out.println();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}