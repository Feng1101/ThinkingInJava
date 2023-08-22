package feng.T_Concurrency.A_Basic;

/**
 * 与Simple并无多少不同，但可以继承自己需要的类使用
 */
public class SelfManaged implements  Runnable{
    private int countDown=5;
    private Thread t=new Thread(this);
    public SelfManaged(){t.start();}
    public String toString(){
        return Thread.currentThread().getName()+"( "+countDown+"), ";
    }
    public void run(){
        while(true){
            System.out.println(this);
            if(--countDown==0)
                return;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }
}
