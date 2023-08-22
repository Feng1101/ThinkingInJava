package feng.P_Containers.F_散列码;

import java.lang.reflect.Constructor;
import java.util.HashMap;

/**
 * 即使是相同的number也不行.因为默认的Object 的hashCode() 是取对象的地址, eauals()则是比较地址信息.所以两个键在散列结构中不同
 */
public class SpringDetector {
    public static <T extends Groundhog>
     void detectSpring(Class<T> type) throws Exception{
        Constructor<T> ghog = type.getConstructor(int.class);
        HashMap<Groundhog, Prediction> map = new HashMap<>();
        for(int i=0;i<10;i++){
            map.put(ghog.newInstance(i),new Prediction());
        }
        System.out.println("map = "+map);
        Groundhog gh = ghog.newInstance(3);
        System.out.println("Looking up prediction for "+gh);
        if(map.containsKey(gh))
            System.out.println("it has: "+map.get(gh));
        else
            System.out.println("Key not found: "+gh);
    }

    public static void main(String[] args) throws Exception {
        detectSpring(Groundhog.class);
        System.out.println("----------分割线-------");
        detectSpring(Groundhog2.class);
    }
}
