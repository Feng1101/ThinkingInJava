package feng.O_Generics.bean.J_通配符;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends  Fruit> flist= Arrays.asList(new Apple());
        Apple a=(Apple)flist.get(0);
        //持有的对象为 继承fruit的某个类并不是Apple，通配符的缺点
        System.out.println(flist.contains(new Apple())); //false
        System.out.println(flist.indexOf(new Apple())); //-1
    }
}
