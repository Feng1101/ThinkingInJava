package feng.O_Generics.bean;

import java.util.HashMap;
import java.util.Map;

public class New {
    public static <K,V>Map<K,V>map(){
        return new HashMap<K,V>();
    }
}
