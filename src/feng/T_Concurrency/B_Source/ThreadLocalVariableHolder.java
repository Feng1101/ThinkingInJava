package feng.T_Concurrency.B_Source;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal 会根据不同的线程创建出不同的对象,因此,他们调用的并不是一个对象.是五个不同的对象,每一个都有其对应的线程对应本地数据.
 * 这东西类似一个容器，线程中使用
 */
class Accessor implements Runnable{
    private final int id;
    public Accessor (int nid ){id =nid;}
    public void run(){
        while(!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
        ThreadLocalVariableHolder.remove();
    }
    public String toString(){
        return "#"+id + ": "+ThreadLocalVariableHolder.get();
    }

}
public class ThreadLocalVariableHolder {
    //ThreadLocal 会根据不同的线程创建出不同的对象
    private static ThreadLocal<Integer> value=new ThreadLocal<Integer>(){
      private Random rand=new Random(47);
      protected synchronized Integer initialValue(){
          return rand.nextInt(10000);
      }
    };

    public static void increment(){
        value.set(value.get()+1);
    }
    public static Integer get(){
        return value.get();
    }
    public static void remove(){value.remove();}

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Accessor(i));
        }
        TimeUnit.SECONDS.sleep(1);
        exec.shutdownNow();
    }
}
