package feng.T_Concurrency.A_Basic;

public class T1 implements Runnable{
    private int i;
    private int x=1;
    public T1(int num){this.i=num;}
    @Override
    public void run() {
        System.out.println("number of the "+i + " start the mission" );
        for (int j = 0; j < 3; j++) {
            System.out.println("I am the number of "+i+" ,and run the "+(x++)+" times");
            Thread.yield();
        }
        System.out.println("number of "+i+" end the mission");
    }

    public static void main(String[] args) {
        for (int j = 0; j < 5; j++) {
            new Thread(new T1(j)).start();
        }
    }
}
