package feng.T_Concurrency.A_Basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 设置默认的线程异常捕获器
 */
public class SettingDefaultHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
