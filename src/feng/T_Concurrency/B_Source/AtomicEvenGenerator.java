package feng.T_Concurrency.B_Source;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Java提供了特殊的原子类变量
 * 如果能够保证某一个操作是原子性的，那就没有必要将其同步，否则当其可能涉及多个任务时，应当对其进行同步，以保证其原子性，如 EvenGenerator 所示
 * 同步又可分为内部的 synchronized 或者 人为 控制的 lock
 */
public class AtomicEvenGenerator extends IntGenerator {

    private AtomicInteger currentEvenValue=new AtomicInteger(0);
    public int next (){
        return currentEvenValue.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }

}
