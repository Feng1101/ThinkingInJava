package feng.T_Concurrency.A_Basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 正常的异常捕获机制，无法捕捉到线程中抛出的异常
 * 即使使用了捕获，异常依旧被抛出
 */
public class NativeExceptionHanding {
    public static void main(String[] args) {
        try{
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        }catch (RuntimeException e){
            System.out.println("We catch the Exception!!!");
        }
    }
}
