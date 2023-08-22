package feng.O_Generics.bean.J_通配符;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
    public static void main(String[] args) {
        List<? extends Fruit> flist=new ArrayList<Apple>();
        //无法接受任何类型的对象
        /*
        flist.add(new Apple());//谁能告诉我为什么
        flist.add(new Object());
        flist.add(new Fruit());
         */

    }
}
