package feng.T_Concurrency.A_Basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用execute ，管理Thread对象
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0; i< 5; i++){
            exec.execute(new T1(i));
        }
        exec.shutdown();
    }
}
