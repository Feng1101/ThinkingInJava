package feng.J_InnerClass.bean;

public class Sequence {
    private String common="name is ";
    class A{
        private String name="a";
        public void show(){
            System.out.println(common+name);
        }
    }
    class B{
        private String name="b";
        public void show(){
            System.out.println(common+name);
        }
    }
    public A getA(){return  new A();}
    public B getB(){return new B();}

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        sequence.new B();  //创建内部类的方法
        sequence.getA().show();
        sequence.getB().show();
    }
}
