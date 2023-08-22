package feng.T_Concurrency.A_Basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程具备优先级，优先级低的占用cpu的时间和频率比较低
 * yield()方法：让步，具有相同优先级的线程可运行，使用此方法能够产生分布较好的处理机制
 */

public class SimplePriority  implements Runnable{
    private int countDown =5;
    private volatile double d;
    private int priority ;
    public String toString(){
        return Thread.currentThread()+": "+countDown;
    }
    public SimplePriority( int priority){this.priority=priority;}
    public void run(){
        Thread.currentThread().setPriority(priority);
        while(true){
            for (int i = 0; i < 100000; i++) {
                d += (Math.PI+Math.E);
                if(i % 1000==0)
                    Thread.yield();
            }
            System.out.println(this);
            if(--countDown==0) return;
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriority(Thread.MIN_PRIORITY));
            exec.execute(new SimplePriority(Thread.MAX_PRIORITY));
        }
        exec.shutdown();
    }

}
