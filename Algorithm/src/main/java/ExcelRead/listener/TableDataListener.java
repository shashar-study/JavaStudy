package ExcelRead.listener;

import ExcelRead.dao.TableDao;
import ExcelRead.pojo.TableInfo;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：
 * 　　　　* 开发人员：shasha shasha@qq.com <br>
 * 　　 　　* 开发时间：2020/7/28 <br>
 * 　　　　* 功能描述：写明作用，调用方式，使用场景，以及特殊情况 <br>
 *
 */
public class TableDataListener extends AnalysisEventListener<TableInfo> {
  private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(TableDataListener.class);
  /**
   * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
   */
  private static final int BATCH_COUNT = 200;
  List<TableInfo> list = new ArrayList<TableInfo>();
  /**
   * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
   */
  private TableDao tableDao;
  public TableDataListener() {
    // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
    tableDao = new TableDao();
  }
  /**
   * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
   *
   * @param tableDao
   */
  public TableDataListener(TableDao tableDao) {
    this.tableDao = tableDao;
  }
  /**
   * 这个每一条数据解析都会来调用
   *
   * @param data
   *            one row value. Is is same as {@link AnalysisContext#readRowHolder()}
   * @param context
   */
  @Override
  public void invoke(TableInfo data, AnalysisContext context) {
 /*   StringBuilder sql=new StringBuilder(data.getFieldName());
    if(data.getDataType().equals("Nvarchar")){
      sql.append("  varchar(255)");
    }else{
      sql.append("   "+data.getDataType());
    }
    sql.append("  COMMENT '"+data.getComment1().replaceAll("\'","\""));
    if(data.getComment2()!=null){
      sql.append(","+data.getComment2().replaceAll("\'","\""));
    }
    sql.append("',");
    System.out.println(sql);
*/

    System.out.println(JSON.toJSONString(data));
    list.add(data);
    // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
    if (list.size() >= BATCH_COUNT) {
      saveData();
      // 存储完成清理 list
      list.clear();
    }
  }
  /**
   * 所有数据解析完成了 都会来调用
   *
   * @param context
   */
  @Override
  public void doAfterAllAnalysed(AnalysisContext context) {
    // 这里也要保存数据，确保最后遗留的数据也存储到数据库
    saveData();
    LOGGER.info("所有数据解析完成！");
  }
  /**
   * 加上存储数据库
   */
  private void saveData() {
   // System.out.println("{}条数据，开始存储数据库！"+ list.size());
    tableDao.save(list);
    LOGGER.info("存储数据库成功！");
  }
}
