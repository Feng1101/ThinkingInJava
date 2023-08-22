package feng.K_HoldingObjects.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * 支持反向遍历，返回一个特殊的Iterator
 * @param <T>
 */
public class ReversibleArrayList <T> extends ArrayList<T> {
    public ReversibleArrayList(Collection<T> c){super(c);}
    //面向接口编程，通过返回与forEach相同类型的接口，便可以直接使用
    public Iterable<T> reversed(){
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int index=size()-1;
                    @Override
                    public boolean hasNext() {
                        return index>-1;
                    }

                    @Override
                    public T next() {
                        return get(index--);
                    }
                    public void remove(){
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public static void main(String[] args) {
        ReversibleArrayList<String> ral = new ReversibleArrayList<>(Arrays.asList("To be or not to be".split(" ")));
        for(String s :ral){
            System.out.print(s+" ");
        }
        System.out.println();
        //获取反向迭代器
        for(String s:ral.reversed()){
            System.out.print(s+" ");
        }
    }
}
