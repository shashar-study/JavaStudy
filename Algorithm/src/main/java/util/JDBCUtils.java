package util;
/*** 软件版权：XX有限公司
 　　　　* 修改记录：
 　　　　* 修改日期   修改人员     修改说明
 　　　　* =========  ===========  ====================================
 　　　　 * 2020/5/10   shasha      新增
 　　　　* =========  ===========  ====================================
 　　　　*/

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 功能说明：
 * 　　　　* 开发人员：shasha shasha@qq.com <br>
 * 　　 　　* 开发时间：2020/5/10 <br>
 * 　　　　* 功能描述：写明作用，调用方式，使用场景，以及特殊情况 <br>
 *
 */
public class JDBCUtils {
  //定义成员变量DataSource
  private static DataSource ds;
  static{
    try {
      //加载配置文件
      Properties pro=new Properties();
      pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
      //获取DataSource
      ds= DruidDataSourceFactory.createDataSource(pro);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  /**
   * 获取连接
   */
  public static Connection getConnection() throws SQLException {
    return ds.getConnection();
  }
  /**
   * 释放资源
   * */
  public static void close(Statement st, Connection conn){
    close(null,st,conn);
  }
  /*重载*/
  public static void close(ResultSet rs, Statement st, Connection conn){
    if(rs!=null){
      try {
        st.close();//释放连接
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if(st!=null){
      try {
        st.close();//释放连接
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if(conn!=null){
      try {
        st.close();//归还连接
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
  /*
   * 获取连接池的方法
   * */
  public static DataSource getDataSource(){
    return ds;
  }
}
