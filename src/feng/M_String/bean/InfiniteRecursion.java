package feng.M_String.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 无意识的递归
 * 该类想要打印对象的内存地址，但 + 号会进行一个转换，将该类使用String 方法的toString
 * 会导致无限的递归
 * 应该使用Object 类的toString 即super.toString()
 */
public class InfiniteRecursion {
    public String toString(){
//        return " InfiniteRecursion address: " +this + "\n";
        return " InfiniteRecursion address: " +super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> v=new ArrayList<>();
        for(int i=0;i<3;i++){
            v.add(new InfiniteRecursion());
        }
        System.out.println(v);
    }
}
