package ExcelRead.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 功能说明：Excel表格实体类
 * 　　　　* 开发人员：shasha shasha@qq.com <br>
 * 　　 　　* 开发时间：2020/7/28 <br>
 * 　　　　* 功能描述：写明作用，调用方式，使用场景，以及特殊情况 <br>
 *
 */
@Data
public class TableInfo {

  @ExcelIgnore
  @ExcelProperty("序号")
  private Integer num;

  //字段	数据类型	字段标题	字段说明	字段来源
  @ExcelProperty("字段")
  private String fieldName;

  @ExcelProperty("数据类型")
  private String dataType;

  @ExcelProperty("字段标题")
  private String comment1;

  @ExcelProperty("字段说明")
  private String comment2;

  @ExcelIgnore
  @ExcelProperty("字段来源")
  private String url;
}
