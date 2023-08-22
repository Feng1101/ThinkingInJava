package feng.O_Generics.bean;

/**
 * 模板方法,给定一个模板，他的子类必须照做,即create()方法
 * @param <T>
 */
abstract class GenericWithCreate<T>{
    final T element;
    GenericWithCreate(){element=create();}
    abstract  T create();
}
class X{}

class Creator extends GenericWithCreate<X>{
    X create(){
        return new X();
    }
    void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}

public class CreatorGeneric {
    public static void main(String[] args) {
        Creator c = new Creator();
        c.f();
    }
}
