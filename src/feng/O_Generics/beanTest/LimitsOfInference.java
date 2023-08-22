package feng.O_Generics.beanTest;

import com.sun.org.apache.bcel.internal.generic.NEW;
import feng.O_Generics.bean.Automobile;
import feng.O_Generics.bean.New;

import java.util.List;
import java.util.Map;

public class LimitsOfInference {
    static void f(Map<String, List< ? extends Automobile>> map){
        System.out.println(map.getClass().getMethods());
    }

    public static void main(String[] args) {
        f(New.map());
    }
}
