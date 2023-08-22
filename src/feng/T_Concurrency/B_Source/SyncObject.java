package feng.T_Concurrency.B_Source;

/**
 * 演示两个任务同时进入一个对象,该示例中的两个任务是互相独立的,没啥关系.锁的不是一个对象.
 *
 */
class DualSynch{
    private Object syncObject=new Object();
    public synchronized  void f(){
        for (int i = 0; i < 100; i++) {
            System.out.print("f() ");
            Thread.yield();
        }
    }
    public void g(){
        synchronized (syncObject){
            for (int i = 0; i < 100; i++) {
                System.out.print("g() ");
                Thread.yield();
            }
        }
    }
}

public class SyncObject {
    public static void main(String[] args) {
        final DualSynch ds=new DualSynch();
        new Thread(){
            public void run(){
                ds.f();
            }
        }.start();
        ds.g();
    }

}
