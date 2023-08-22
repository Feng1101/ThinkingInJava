package feng.util.javaUtil;

import java.util.LinkedHashMap;

/**
 * MAP生成器
 */
public class MapData<K,V> extends LinkedHashMap<K,V> {
    //single Pair generator
    public MapData(Generator<Pair<K,V>> gen, int quantity){
        for(int i=0; i<quantity;i++){
            Pair<K,V> p=gen.next();
            put(p.key,p.value);
        }
    }
    //两个构造器
    public MapData(Generator <K> genK,Generator<V> genV, int quantity){
        for(int i=0;i<quantity;i++){
            put(genK.next(), genV.next());
        }
    }
    //一个构造器和一个普通值类
    public MapData(Generator<K>genK,V value,int quantity){
        for (int i=0; i<quantity;i++){
            this.put(genK.next(), value);
        }
    }

    //一个迭代器和一个生成器
    public MapData(Iterable<K> genK,Generator<V> genV){
        for(K key:genK){
            put(key,genV.next());
        }
    }

    //一个迭代器和一个普通值
    public MapData(Iterable<K> genK, V value){
        for(K key:genK){
            put(key,value);
        }
    }

    //对应五种生成器的静态生成类
    public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> gen,int quantity){
        return new MapData<>(gen,quantity);
    }

    public static <K,V> MapData<K,V> map(Generator<K> genK,Generator<V> genV,int quantity){
        return new MapData<>(genK,genV,quantity);
    }

    public static <K,V> MapData<K,V> map(Generator<K> genK,V value,int quantity){
        return new MapData<>(genK,value,quantity);
    }

    public static <K,V> MapData<K,V> map(Iterable<K> genK,Generator<V> genV){
        return new MapData<>(genK,genV);
    }

    public static <K,V> MapData<K,V> map(Iterable<K> genK,V value){
        return new MapData<>(genK,value);
    }


}
