package feng.O_Generics.bean.Q_潜补;

import feng.util.javaUtil.Generator;

import java.util.Collection;

/**
 * 适配器仿真 潜在类型机制
 */

interface Addable<T> {void add(T t);}

public class Fill2 {
    //默认构造器
    public  static <T> void  fill(Addable<T> addable,Class<? extends  T> classToken,int size){
        for(int i=0;i<size ;i++){
            try{
                addable.add(classToken.newInstance());
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }
    //生成器
    public static <T> void fill(Addable<T> addable , Generator<T> generator ,int size){
        for(int i=0 ;i<size ;i++){
            addable.add(generator.next());
        }
    }
}

class AddableCollectionAdapter <T> implements Addable<T>{
    private Collection<T> c;
    public AddableCollectionAdapter(Collection<T> c){
        this.c = c;
    }
    public void add(T item){ c.add(item); }
}

//适配器
class Adapter{
    public static <T> Addable<T> collectionAdapter(Collection<T> c){
        return new AddableCollectionAdapter<T>(c);
    }
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T>{
    public void add(T item){
        super.add(item);
    }
}

class Fill2Test{
    public static void main(String[] args) {

    }

}
