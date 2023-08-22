package feng.P_Containers.E_Map;

import feng.util.javaUtil.CountingMapData;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * 排序Map的接口  TreeMap
 */
public class SortedMapDemo {
    public static void main(String[] args) {
        TreeMap<Integer, String> sortedMap = new TreeMap<>(new CountingMapData(10));
        System.out.println(sortedMap);
        Integer low = sortedMap.firstKey();
        Integer high = sortedMap.lastKey();
        System.out.println("low: "+low);
        System.out.println("high: "+high);
        Iterator<Integer> it = sortedMap.keySet().iterator();
        for(int i=0;i<=6;i++){
            if(i==3) low=it.next();
            if(i==6) high=it.next();
            else it.next();
        }
        System.out.println("low: "+low);
        System.out.println("high: "+high);
        System.out.println("排序Map的中间段: "+sortedMap.subMap(low,high));
        System.out.println("排序Map的前段: "+sortedMap.headMap(high));
        System.out.println("排序Map的后段: "+sortedMap.tailMap(high));
    }
}
