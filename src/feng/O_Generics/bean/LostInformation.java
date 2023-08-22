package feng.O_Generics.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 你无法通过泛型容器获取到其中的具体类信息，它被擦除了
 */
public class LostInformation {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));
        Class c1=new ArrayList<String>().getClass();
        Class c2=new ArrayList<Integer>().getClass();
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1==c2);
    }
}
