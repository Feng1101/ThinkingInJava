package feng.O_Generics.bean.N_异常;

import java.util.ArrayList;
import java.util.List;

//进程的接口，每个进程都有process 作为入口
interface Processor<T,E extends Exception>{
    void process (List<T> resultCollector) throws E;
}

// 进程的执行集合，返回执行结果集
class ProcessorRunner <T,E extends Exception> extends ArrayList<Processor<T,E>> {
    List<T> processAll() throws E{
        List<T> resultCollector = new ArrayList<>();
        for(Processor<T,E> processor: this){
            processor.process(resultCollector);
        }
        return resultCollector;
    }
}
//自定义异常类型1
class Failure1 extends Exception{}
//具体的进程
class Processor1 implements Processor<String, Failure1>{
    static int count =3;
    public  void process(List<String> resultCollector) throws Failure1{
        if(count-- > 1)
            resultCollector.add("Hep!");
        else
            resultCollector.add("Ho!");
        if(count<0)
            throw  new Failure1();
    }
}

//自定义异常类型2
class Failure2 extends Exception{}
//具体的进程
class Processor2 implements Processor<Integer, Failure2>{
    static int count =3;
    public  void process(List<Integer> resultCollector) throws Failure2{
        if(count-- > 1)
            resultCollector.add(count+50);
        else
            resultCollector.add(count+20);
        if(count<0)
            throw  new Failure2();
    }
}



public class ThrowGenericException {
    public static void main(String[] args) {
        ProcessorRunner runner=new ProcessorRunner<String,Failure1>();
        for(int i=0;i<3;i++){
            runner.add(new Processor1());
        }
        try{
            System.out.println(runner.processAll());
        }catch (Exception e){
            System.out.println();
        }
    }

}
