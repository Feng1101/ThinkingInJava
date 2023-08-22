package feng.O_Generics.bean.L_自限定;

/**
 * 自限定类，保证参数与被定义的类相同；
 * 可以在使用了SelfBounded 的 参数中进行导出
 * @param <T>
 */
class SelfBounded <T extends SelfBounded<T>>{
    T element;
    SelfBounded<T> set (T arg){
        this.element=arg;
        return this;
    }
    T get(){
        return element;
    }
}
class A extends SelfBounded<A>{}
class B extends SelfBounded<B>{}
class C extends SelfBounded<C>{
    C setAndGet (C arg) {set (arg); return get();}
}

public class SelfBounding {
    public static void main(String[] args) {
        A a =new A();
        a.set(new A());
        a=a.set(new A()).get();
        a=a.get();
        C c =new C();
        c=c.setAndGet(new C());
    }
}
