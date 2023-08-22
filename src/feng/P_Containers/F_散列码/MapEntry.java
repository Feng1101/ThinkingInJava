package feng.P_Containers.F_散列码;

import java.util.Map;

public class MapEntry<K,V> implements Map.Entry<K,V> {
    private K key;
    private V value;
    public MapEntry(K k,V v){
        key=k;
        value=v;
    }
    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V v) {
        //返回旧的value
        V result= value;
        this.value=v;
        return result;
    }
    public int hashCode(){
        return (key==null ?0:key.hashCode() ^ (value==null? 0: value.hashCode()) );
    }
    public boolean equals(Object o){
        if(! (o instanceof MapEntry)) return false;
        MapEntry me =(MapEntry) o;
        return
                (key ==null ? me.getKey()==null:key.equals(me.getKey()))
                &&
                (value==null? me.getValue()==null : value.equals(me.getValue()));

    }
    public String toString(){
        return key+" = "+value;
    }
}
