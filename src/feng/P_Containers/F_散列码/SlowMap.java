package feng.P_Containers.F_散列码;

import java.util.*;

/**
 * 自定义Map
 */
public class SlowMap<K,V> extends AbstractMap<K,V> {
    private List<K> keys= new ArrayList<>();
    private List<V> values=new ArrayList<>();
    //Map.Entry只是一个接口,需要先定义具体的类
    public Set<Entry<K,V>> entrySet(){
        Set<Entry<K,V>> set=new HashSet<>();
        Iterator<K> ki=keys.iterator();
        Iterator<V> vi=values.iterator();
        while (ki.hasNext()){
            set.add(new MapEntry<>(ki.next(),vi.next()));
        }
        return set;
    }
    public V get(Object key){
        if(! keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }
    public V put(K key, V value){
        V oldValue= get(key);
        if(! keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else{
            values.set(keys.indexOf(key),value);
        }
        return oldValue;
    }
    public V remove(Object key){
        if(! keys.contains(key)){
            return null;
        }
        V value=values.get(keys.indexOf(key));
        values.remove(keys.indexOf(key));
        keys.remove(key);
        return value;
    }

    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<>();
        for(int i=0;i<5;i++){
            String a=i+"a";
            m.put(a,a+i);
        }
        System.out.println(m);
        System.out.println(m.get("0a"));
        System.out.println(m.entrySet());
    }
}
