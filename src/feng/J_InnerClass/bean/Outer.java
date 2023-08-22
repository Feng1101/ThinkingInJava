package feng.J_InnerClass.bean;

public class Outer {
    class Inner{
        private String name="Inner";
        public void getName(){
            System.out.println("name is: "+name);
        }
    }
    public Inner getInner(){ return  new Inner();}

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.getInner();
        inner.getName();
    }
}
