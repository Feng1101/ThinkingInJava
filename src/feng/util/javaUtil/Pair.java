package feng.util.javaUtil;

/**
 * Map生成器,需要使用Pair类,每次调用Generator时需要产生对象对
 */
public class Pair <K,V>{
    public final K key;
    public final V value;
    public Pair(K k ,V v ){
        key=k;
        value=v;
    }
}
