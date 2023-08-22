package feng.T_Concurrency.A_Basic;


import java.sql.SQLOutput;

//该类只关注于计算，完全G了。无法读取输入
//守护线程,不影响主线程
class UnresponsiveUI {
    private volatile double d=1;
    public UnresponsiveUI() throws Exception{
        while (d>0)
            d=d+(Math.PI+Math.E)/d;
        System.in.read();
    }
}
public class ResponsiveUI extends Thread{
    private  static volatile double d =1;
    public ResponsiveUI(){
        setDaemon(true);
        start();
    }
    public void run(){
        while (true){
            d=d+(Math.PI+Math.E)/d;
        }
    }

    public static void main(String[] args) throws  Exception{
        new ResponsiveUI();
        System.in.read();
        System.out.println(d);
    }
}
