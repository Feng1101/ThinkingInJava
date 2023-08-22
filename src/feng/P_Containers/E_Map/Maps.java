package feng.P_Containers.E_Map;

import feng.P_Containers.F_散列码.SlowMap;
import feng.util.javaUtil.CountingMapData;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 普通Map拥有的接口
 */
public class Maps {
    public static void printKeys(Map<Integer,String> map){
        System.out.println("Size= "+map.size() +", ");
        System.out.println("Keys: "+ map.keySet());
    }
    public static void test(Map<Integer,String> map){
        System.out.println("--------------this is test  ---------------------");
        System.out.println(map.getClass().getSimpleName());
        //需要传入Map的接口,将一个map全部存入当前map中
        map.putAll(new CountingMapData(25));
        printKeys(map);

        System.out.print("Values: ");
        System.out.println(map.values());
        System.out.println(map);
        System.out.println("map.containsKey(11): "+map.containsKey(11));
        System.out.println("map.get(11): "+map.get(11));
        System.out.println("map.containsValue(\"F0\"): "+map.containsValue("F0"));
        //通过iterator获取第一个元素
        Integer key = map.keySet().iterator().next();
        System.out.println("First key in map : "+key);
        map.remove(key);
        printKeys(map);
        map.clear();
        System.out.println("map is empty: "+ map.isEmpty());
        map.putAll(new CountingMapData(25));
        //根据键进行map的移除操作
        map.keySet().removeAll(map.keySet());
        System.out.println("map is empty: "+map.isEmpty());
    }

    public static void main(String[] args) {
        test(new HashMap<Integer,String>());
        test(new TreeMap<Integer,String>());
        test(new LinkedHashMap<>());
        test(new IdentityHashMap<>());  //顺序
        test(new ConcurrentHashMap<>());
        test(new WeakHashMap<>());     //顺序
        test(new SlowMap<>());
    }
}
