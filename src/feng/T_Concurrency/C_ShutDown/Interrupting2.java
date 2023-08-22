package feng.T_Concurrency.C_ShutDown;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在reentrantLock 上阻塞的任务具备可以被中断的能力
 * 看下什么样
 * 由于Mutex在创建之初就把自己给锁了,所以f()方法无论如何也获取不到该对象的锁.
 * 但可以轻易的打断被互斥阻塞的调用
 */
class BlockedMutex{
    private Lock lock=new ReentrantLock();
    public  BlockedMutex(){
        lock.lock();
    }
    public void f(){
        try{
            lock.lockInterruptibly(); //Special call
            System.out.println("lock acquired in f()");
        }catch (InterruptedException e){
            System.out.println("Interrupted from lock acquisition in f()");
        }
    }
}
class Blocked2 implements  Runnable{
    BlockedMutex blocked=new BlockedMutex();

    @Override
    public void run() {
        System.out.println("Waiting  for f() in BlockedMutex");
        blocked.f();
        System.out.println("Broken out of blocked call");
    }
}
public class Interrupting2 {
    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t.interrupt()");
        t.interrupt();
    }
}
