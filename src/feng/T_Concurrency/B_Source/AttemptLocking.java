package feng.T_Concurrency.B_Source;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

//尝试获取锁或者获取锁一段时间后自动放弃.定制化的获取锁操作需要使用lock
public class AttemptLocking {
    private ReentrantLock lock=new ReentrantLock();
    public void untimed(){
        boolean captured=lock.tryLock();
        try {
            System.out.println("tryLock(): "+captured);
        }finally {
            if(captured)
                lock.unlock();
        }
    }
    public void timed(){
        boolean captured=false;
        try{
            captured=lock.tryLock(2, TimeUnit.SECONDS);//尝试获取锁2秒
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock2(): "+captured);
        }finally {
            if(captured)
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al= new AttemptLocking();
        al.untimed();
        al.timed();
        new Thread(){
            {setDaemon(true);}
            public void run(){
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        try {
            Thread.sleep(50);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        Thread.yield();
        al.untimed();
        al.timed();
    }
}
