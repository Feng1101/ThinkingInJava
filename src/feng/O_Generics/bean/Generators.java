package feng.O_Generics.bean;

import feng.util.javaUtil.Generator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 生成器的泛型方法
 */
public class Generators {
    public static <T>Collection<T> fill(Collection<T> coll, Generator<T> gen,int n){
        for(int i=0;i<n;i++){
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Integer> fill = fill(new ArrayList<Integer>(), new Fibonacci(), 12);
        for(int i: fill){
            System.out.print(i+", ");
        }
    }
}
