package feng.T_Concurrency.A_Basic;

import java.util.concurrent.TimeUnit;

/**
 * 使用内部类将线程代码隐藏在类中，有时会很有用
 * 下面是五种隐藏内部类线程代码的方法
 * 继承或直接使用Thread类的1 2 5，直接new Thread即可，3 4 方法由于使用的是Runnable接口，在通过建立Thread实现多线程时，需要传两个参数，Runnable 和 name
 */
class InnerThread1{
    private int countDown = 5;
    private Inner inner;
    private class Inner extends Thread{
        Inner(String name){
            super(name);
            start();
        }
        public void run(){
            try{
                while(true){
                    System.out.println(this);
                    if(--countDown==0)
                        return;
                    sleep(10);
                }
            }catch (InterruptedException e){
                System.out.println("interrupted");
            }
        }
        public String toString(){
            return getName()+": "+countDown;
        }
    }
    public InnerThread1(String name){
        inner=new Inner(name);
    }
}

//内部类直接创建
class InnerThread2{
    private int countDown = 5;
    private Thread t;
    public InnerThread2(String name){
        t=new Thread(name){
          public void run(){
              try{
                  while(true){
                      System.out.println(this);
                      if(--countDown==0)
                          return;
                      sleep(10);
                  }
              }catch (InterruptedException e){
                  System.out.println("sleep() interrupted");
              }
          }
          public String toString(){
              return getName()+": "+countDown;
          }
        };
        t.start();
    }
}
class InnerRunnable1{
    private int countDown=5;
    private Inner inner;
    private class Inner implements Runnable{
        Thread t;
        Inner(String name){
            t=new Thread(this,name);
            t.start();
        }
        public void run(){
            try{
                while(true){
                    System.out.println(this);
                    if(--countDown==0)
                        return;
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            }catch (InterruptedException e){
                System.out.println("interrupted");
            }
        }
        public String toString(){
            return t.getName()+": "+countDown;
        }
    }
    public InnerRunnable1(String name){
        inner=new Inner(name);
    }
}

class InnerRunnable2{
    private int countDown = 5;
    private Thread t;
    public InnerRunnable2(String name){
        t=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while(true){
                        System.out.println(this);
                        if(--countDown==0)
                            return;
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                }catch (InterruptedException e){
                    System.out.println("sleep() interrupted");
                }
            }
            public String toString(){
                return Thread.currentThread().getName()+": "+countDown;
            }
        },name);
        t.start();
    }
}

class ThreadMethod{
    private int countDown=5;
    private Thread t;
    private String name;
    public ThreadMethod(String name ){this .name=name;}
    public void runTask(){
        if(t==null){
            t=new Thread(name){
                public void run(){
                    try{
                        while(true){
                            System.out.println(this);
                            if(--countDown==0)
                                return;
                            TimeUnit.MILLISECONDS.sleep(10);
                        }
                    }catch (InterruptedException e){
                        System.out.println("sleep() interrupted");
                    }
                }
                public String toString(){
                    return getName()+": "+countDown;
                }
            };
            t.start();
        }
    }
}

public class ThreadVariations {
    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("THreadMethod").runTask();
    }
}
