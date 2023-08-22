package feng.O_Generics.bean;

public class Erased <T>{
    private final int SIZE=100;
    public  void f(Object arg){
//        if(arg instanceof  T){}   //Error
//        T var= new T();         //编译器不能知道T到底有没有默认构造器，所以只能正常用都是传具体类型
//        T[] array = new T[SIZE];
//        T[] array2=(T)new Object[SIZE];
    }
}
