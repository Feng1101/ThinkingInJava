package feng.O_Generics.beanTest;

import feng.O_Generics.bean.Automobile;

/**
 * 通过<T>表示一个泛型容器，在创建该容器时必须制定类
 * 泛型使得类更加的灵活，一个类型可以兼容多个
 * @param <T>
 */
public class Holder3<T> {
    private T a;
    public Holder3(T a){this.a =a;}
    public void set(T a ){this.a =a;}
    public T get(){return  a;}

    public static void main(String[] args) {
        Holder3<Automobile> h3=new Holder3<>(new Automobile());
        Automobile a = h3.get();
        /*编译器会帮你检查传入的类型信息
        h3.set("can't set String");
        h3.set(1);
         */
    }
}
