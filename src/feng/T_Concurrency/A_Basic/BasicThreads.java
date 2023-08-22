package feng.T_Concurrency.A_Basic;

public class BasicThreads {
    public static void main(String[] args) {
        //Thread类需要一个集成了Runnable的对象
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Waiting for LiftOff");
    }
}
