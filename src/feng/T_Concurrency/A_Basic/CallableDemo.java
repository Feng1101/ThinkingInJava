package feng.T_Concurrency.A_Basic;

import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Future容器用于存储线程的返回结果，isDone方法可以判断是否已处理完毕，get可以直接获取，若get时没有处理完毕，则造成阻塞，等待处理完毕后返回
 */
class TaskWithResult implements Callable{
    private int id;
    public TaskWithResult(int id){this.id=id;}
    public String call(){
        return "result of TaskWithResult: "+id;
    }
}
public class CallableDemo {
    public static void main(String[] args) {
        //对于实现了Callable的线程，exec类使用submit方法，runnable线程使用execute方法
        ExecutorService exec = Executors.newCachedThreadPool();

        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for(Future<String> fs : results)
            try {
                System.out.println(fs.get());
            }catch (InterruptedException e){
                System.out.println(e);
                return;
            }catch (ExecutionException e){
                System.out.println(e);
            }finally {
                exec.shutdown();
            }
    }
}
