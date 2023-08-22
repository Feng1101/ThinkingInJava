package feng.T_Concurrency.B_Source;

public class EvenGenerator extends IntGenerator{
    private  int  currentEvenValue=0;
    public synchronized int next(){
        ++currentEvenValue;  //Danger point here
        Thread.yield();       //让当前线程从Running 态 进入 Ready 态，增加Cpu处理现成的随机性
        ++currentEvenValue;
        return  currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
