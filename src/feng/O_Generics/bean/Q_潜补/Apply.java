package feng.O_Generics.bean.Q_潜补;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 使用可变参数的方式,公认的优雅
 */

public class Apply {
    //设定边界,否则后面的某些方法无法使用,相当于设定拥有的基础接口
    public static <T, S extends Iterable<T>> void apply(S seq, Method f, Object ... args){
        try{
            for(T t:seq){
                f.invoke(t,args);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

class Shape{
    public void rotate(){
        System.out.println(this+" rotate");
    }
    public void resize( int newSize){
        System.out.println(this + " resize " + newSize);
    }
}

class Square extends Shape{}

//继承泛型容器时,需要使用泛型参数
class FilledList<T> extends ArrayList<T>{
    public FilledList(Class<? extends T> type ,int size){
        try {
            for(int i=0;i<size;i++){
                add(type.newInstance()); //使用对方的默认构造器,无参数,可能会出问题.另一种解决方式是传递一个工厂接口,使用工厂创建
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

class ApplyTest{
    public static void main(String[] args) throws NoSuchMethodException {
        ArrayList<Shape> shapes = new ArrayList<>();
        for(int i=0;i<10;i++){
            shapes.add(new Shape());
        }
        Apply.apply(shapes,Shape.class.getMethod("rotate"));
        Apply.apply(shapes,Shape.class.getMethod("resize", int.class),5);
        //使用自定义的容器
        Apply.apply(new FilledList<Shape>(Shape.class,10),Shape.class.getMethod("rotate")); //实体化的类必须有默认构造器
        Apply.apply(new FilledList<Shape>(Shape.class,10),Square.class.getMethod("rotate"));
        //使用自定义容器,需要继承Iterable接口
        SimpleQueue<Shape> shapeQ = new SimpleQueue<>();
        for(int i=0;i<5;i++){
            shapeQ.add(new Shape());
            shapeQ.add(new Square());
        }
        Apply.apply(shapeQ,Shape.class.getMethod("rotate"));

    }
}
