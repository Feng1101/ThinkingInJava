package feng.T_Concurrency.A_Basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class T5 implements Callable {
    private int n;
    private int key=1;
    private int number=1;
    public T5(int n){this.n=n;}
    public Integer call(){
        for (int i = 0; i < n; i++) {
            if(i<2)
                number=1;
            else{
                number+=key;
                key=number-key;
            }
            System.out.println("Number of : "+n+" go in the time of : "+i);
        }
        return number;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<Integer>> list=new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add(exec.submit(new T5(i)));
        }
        for(Future<Integer> arg : list)
            try{
                System.out.println(arg.get());
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
