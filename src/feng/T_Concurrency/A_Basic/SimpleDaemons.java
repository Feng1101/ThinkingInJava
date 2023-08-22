package feng.T_Concurrency.A_Basic;

import java.util.concurrent.TimeUnit;

/**
 * 守护线程在没有主线程后会自动全部停止，该例子中主线程未main，停留一段时间后全部结束
 */
public class SimpleDaemons implements  Runnable{
    public void run(){
        try {
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+ this);
            }
        }catch (InterruptedException e){
            System.out.println("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}

