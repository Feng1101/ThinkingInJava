package feng.J_InnerClass.test;

import feng.J_InnerClass.bean.Sequence;

public class T_4 {
    private String common="name is ";
    public void start(){
        System.out.println("game is on");
    }
    class A{
        private String name="a";
        public void show(){
            System.out.println(common+name);
        }
        public void outer(){
            T_4.this.start();
        }
    }
    class B{
        private String name="b";
        public void show(){
            System.out.println(common+name);
        }
    }
    public T_4.A getA(){return  new T_4.A();}
    public T_4.B getB(){return new T_4.B();}

    public static void main(String[] args) {
        T_4 t4 = new T_4();
        A a = t4.new A();
        a.outer();
        Sequence sequence = new Sequence();

    }
}
