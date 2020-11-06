package ProductorAndBuyer;

/**
 * Author：shasha<br>
 * Time：2020/11/2 <br>
 * Description：生产者和消费者方法 <br>
 */
/**
 * method:1
 * 利用缓冲区，生产者生产，消费者消费
 * */
public class guancheng {
  public static void main(String[] args) {
    synContainer syncontainer = new synContainer();

    new Productor(syncontainer).start();
    new Customer(syncontainer).start();
  }

}

//生产者
class Productor extends Thread{
  synContainer  syncontainer;

  public Productor(synContainer  syncontainer){
    this.syncontainer=syncontainer;
  }
  //生产方法
  @Override
  public void run(){
    for (int i = 0; i < 100; i++) {
      System.out.println("生产了第"+i+"只鸡");
      syncontainer.push(new Chicken(i));
    }
  }

}

//消费者
class Customer extends  Thread{
  synContainer  syncontainer;

  public Customer(synContainer  syncontainer){
    this.syncontainer=syncontainer;
  }

  //消费方法
  @Override
  public void run(){
    for (int i = 0; i < 100; i++) {
      System.out.println("消费了第"+syncontainer.pop().id+"只鸡");
    }
  }
}

//产品
class Chicken{
  int id;

  public Chicken(int id) {
    this.id = id;
  }
}

//缓冲区
class synContainer{

  //容器大小
  Chicken[] chickens = new Chicken[10];
  //容器计数器
  int count = 0;

  //生产产品
  public  synchronized void  push(Chicken chicken){
    //容器满了，等待xiaofei
    if(count==chickens.length){
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
    //没有满，继续生产
    chickens[count] = chicken;
    count++;

    //通知消费
    this.notifyAll();


  }


  //消费产品
  public  synchronized  Chicken pop(){
    //不可以消费
    if (count==0){
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }

    //可以消费
    count--;
    this.notifyAll();
    return  chickens[count];
  }
}
