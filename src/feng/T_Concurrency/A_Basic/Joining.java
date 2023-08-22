package feng.T_Concurrency.A_Basic;

/**
 *  加入一个线程，造成当前线程的阻塞，直至另一个线程完成任务返回结果或因为超时返回
 *  返回结果必定是Sleeper先苏醒或者先被打断后，才会有Joiner的响应结果
 */
class Sleeper extends Thread{
    private int duration;
    public Sleeper(String name , int sleepTime){
        super(name);
        duration=sleepTime;
        start();
    }
    public void run(){
        try{
            sleep(duration);
        }catch (InterruptedException e){
            System.out.println(getName()+" was interrupted. isInterrupted(): "+isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened !");
    }

}
class  Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper){
        super (name);
        this.sleeper=sleeper;
        start();
    }

    public void run(){
        try{
            sleeper.join();
        }catch (InterruptedException e){
            System.out.println("Interrupted ");
        }
        System.out.println(getName()+" join completed ");

    }
}
public class Joining {
    public static void main(String[] args) {
        Sleeper sleepy= new Sleeper("Sleepy",1500),
                grumpy = new Sleeper("Grumpy", 1500);
        Joiner dopey=new Joiner("Dopey",sleepy),
                doc=new Joiner("doc",grumpy);
        grumpy.interrupt();
    }
}
