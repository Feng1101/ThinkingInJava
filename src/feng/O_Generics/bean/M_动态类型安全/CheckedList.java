package feng.O_Generics.bean.M_动态类型安全;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Cat{}
class Dog{}

/**
 * 由于擦除的特性，使得向泛型容器中插入非指定对象不会有问题，这是不对的
 * 通过checked容器类进行安全检查
 */
public class CheckedList {
    static void oldStyleMethod(List probablyDogs){
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1=new ArrayList<Dog>();
        oldStyleMethod(dogs1);//可以被执行
        List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);
        try{
            oldStyleMethod(dogs2);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
