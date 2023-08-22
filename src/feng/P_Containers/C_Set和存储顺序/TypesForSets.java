package feng.P_Containers.C_Set和存储顺序;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * set类中,对于不同类型的set,需要实现各自的接口或者方法,最基础的是equals方法,因为set中不允许出现相同的值.HashSet需要实现hashCode方法
 * TreeSet需要实现Comparable接口
 */
class SetType{
    int i;
    public SetType(int n ){i=n;}
    public boolean equals(Object o){
        return o instanceof SetType && (i== ((SetType)o).i);
    }
    public String toString(){return Integer.toString(i);}
}

class HashType extends SetType{
    public HashType (int n) {super(n);}
    public int hashCode(){return i;}
}

class TreeType extends SetType implements Comparable<TreeType>{
    public TreeType(int n){super(n);}
    public int compareTo(TreeType arg){
        return (i<arg.i?1 : (i==arg.i? 0: -1));
    }
}

public class TypesForSets {
    static <T> Set<T> fill(Set <T> set ,Class<T> type){
        try{
            for(int i=0;i<10;i++){
                set.add(type.getConstructor(int.class).newInstance(i));
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return set;
    }

    static <T> void test(Set<T> set, Class<T> type){
        fill(set,type);
        //添加重复的类型到set中
        fill(set,type);
        fill(set,type);
        System.out.println(set);
    }

    public static void main(String[] args) {
//        test(new HashSet<HashType>(),HashType.class);
//        test(new LinkedHashSet<HashType>(),HashType.class);
//        test(new TreeSet<TreeType>(),TreeType.class);
        ArrayList<TreeType> test = new ArrayList<>();
        for(int i=0;i<10;i++){
            test.add(new TreeType(i));
        }
        System.out.println(test);
        Collections.sort(test);
        System.out.println(test);

    }
}
