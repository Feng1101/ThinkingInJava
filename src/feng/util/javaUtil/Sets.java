package feng.util.javaUtil;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * 通过泛型方法，表达数学中的关系式
 */
public class Sets {
    //并集
    public static<T> Set<T> union(Set<T> a,Set <T> b){
        HashSet<T> result = new HashSet<>(a);
        result.addAll(b);   //完全添加
        return  result;
    }
    //交集
    public static <T> Set <T> intersection(Set<T> a,Set <T> b){
        HashSet<T> result = new HashSet<>(a);
        result.retainAll(b);  //保留相同的部分
        return result;
    }
    //不同的部分
    public static <T> Set<T> difference(Set<T> superset,Set<T> subset){
        HashSet<T> result = new HashSet<>(superset);
        result.removeAll(subset);
        return result;
    }
    //非交集--不是共有的部分
    public static <T> Set<T> complement(Set<T> a,Set<T>b){
        return difference(union(a,b),intersection(a,b));
    }
}
