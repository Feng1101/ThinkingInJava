package feng.T_Concurrency.C_ShutDown;

/**
 * 两个锁方法获得的是同一个对象,也就是同一个锁
 * 所以等于,拿到了Multi锁,在锁方法中对该锁进行了续费,继续获得该锁的控制权
 * 再次强调,锁,锁的是对象,不管是什么类型的锁,只是锁的时间长短不同.
 */
public class MultiLock {
    public synchronized void f1(int count){
        if(count-- >0){
            System.out.println("f1() calling f2() with count "+count);
            f2(count);
        }
    }
    public synchronized  void f2(int count){
        if(count-- >0){
            System.out.println("f2() calling f1() with count "+count);
            f1(count);
        }
    }

    public static void main(String[] args) throws Exception{
        final MultiLock multiLock=new MultiLock();
        new Thread(){
            public void run(){
                multiLock.f1(10);
            }
        }.start();

    }
}
