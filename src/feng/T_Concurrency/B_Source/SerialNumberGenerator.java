package feng.T_Concurrency.B_Source;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 这是一个可能导致线程安全的生成类
 * 即使serialNumber被定义为volatile，但也无法改变java中自增不是原子性的事实
 * 一旦
 */
public class SerialNumberGenerator  {
    private static  volatile int serialNumber=0;
    public static int nextSerialNumber(){return serialNumber++;}

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new SerialNumberChecker.SerialChecker());
    }
}
