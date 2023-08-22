package feng.P_Containers.A_填充容器;

import feng.util.javaUtil.Generator;

import java.util.ArrayList;

/**
 * 所有的Collection子类型，都有接受另一个Collection对象的构造器，类似该例子。
 * @param <T>
 */
public class CollectionData <T> extends ArrayList<T> {

    public CollectionData(Generator<T> gen , int quantity){
        for(int i=0; i<quantity;i++){
            add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen , int quantity){
        return new CollectionData<>(gen,quantity);
    }

}
