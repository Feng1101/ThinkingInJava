package feng.T_Concurrency.B_Source;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 该例子中，getVal也必须是synchronized，否则会在i增加的途中调用，导致异常
 */
public class AtomicityTest implements Runnable{
    private  int i=0;
    public synchronized int getVal(){return i;}
    private synchronized void evenIncrement(){i++;i++;}
    public void run(){
        while (true)
            evenIncrement();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while(true){
            int val = at.getVal();
            if(val%2 != 0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
