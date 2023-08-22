package feng.P_Containers.A_填充容器;

import feng.util.javaUtil.Generator;

import java.util.LinkedHashSet;

/**
 * CollectionData的实例，泛型容器可以轻易的实现各种类型的适配
 */
class Government implements Generator<String>{
    String [] foundation=( "a b c d e f g h i j k l").split(" ");
    private int index;

    public String next(){
        return foundation[index++];
    }
}

public class CollectionDataTest {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>(new CollectionData<>(new Government(),10));
        System.out.println(set);
        set.addAll(CollectionData.list(new Government(),10));
        System.out.println(set);
    }
}
