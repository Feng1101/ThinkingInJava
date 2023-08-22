package feng.O_Generics.bean.Q_潜补;

import java.util.Iterator;
import java.util.LinkedList;

public class SimpleQueue<T> implements Iterable<T>{
    private LinkedList<T> storage=new LinkedList<>();
    public void add(T t){
        storage.add(t);
    }
    public T get(){return storage.poll();}
    public Iterator<T> iterator(){
        return storage.iterator();
    }
}
