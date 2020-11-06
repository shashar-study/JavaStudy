package ThreadCreat;

/**
 * Author：shasha<br>
 * Time：2020/10/28 <br>
 * Description： <br>
 */
//创建线程方法一：集成thread 类重写 run方法，然后调用start方法开启线程
public class one extends Thread{
  @Override
  public void run() {
    for (int i = 0; i < 40; i++) {
      System.out.println("子线程运行第"+i+"次");
    }
  }

  public static void main(String[] args) {
    one o=new one();
    o.start();
    for (int i = 0; i < 40; i++) {
      System.out.println("主线程运行第"+i+"次");
    }
  }
}
