package feng.T_Concurrency.B_Source;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//显式地创建锁区域,与synchronized的自动化相对
public class MutexEvenGenerator  extends  IntGenerator{
    private int currentEvenValue=0;
    private Lock lock=new ReentrantLock();
    public int next(){
        lock.lock();
        try{
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGenerator());
    }

}
