package feng.util.javaUtil;

import java.util.LinkedList;

/**
 * 可以看到,在LinkedList中已经包含了双向队列的所有接口,但为了实用,需要增加其他方法
 * @param <T>
 */
public class Deque <T>{
    private LinkedList<T> deque=new LinkedList<T>();
    public void addFirst(T e ){ deque.addFirst(e); }
    public void addLast(T e) { deque.addLast(e);}
    public T getFirst(){ return deque.getFirst(); }
    public T getLast() { return deque.getLast(); }
    public T removeFirst() { return deque.removeFirst();}
    public T removeLast() { return deque.removeLast();}
    public int size() { return deque.size();}
    public String toString() { return deque.toString();}

}
