package feng.T_Concurrency.A_Basic;

import feng.util.javaUtil.DaemonThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 通过工厂的方式创建Executor,并使用它
 */
public class DaemonFromFactory  implements Runnable{
    public  void run(){
        try{
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+this);
            }
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        //通过factory创建Executor,并在后面进行使用
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            exec.execute(new DaemonFromFactory());
        }
        System.out.println("All Daemons started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
