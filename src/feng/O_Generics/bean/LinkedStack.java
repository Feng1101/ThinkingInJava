package feng.O_Generics.bean;

/**
 * 利用链表生成的一个栈,容器都应当被制作成泛型
 * @param <T>
 */
public class LinkedStack <T>{
    private static class Node<T>{
        T item;
        Node<T> next;//指向下一个Node
        Node(){item=null;next=null;}
        Node(T item,Node<T> next){this.item=item;this.next=next;}
        boolean end(){return item==null && next==null;}
    }
    //相当于一个指针,永远指向最后一个Node，这个是初始化的top，为null
    private Node<T> top=new Node<T>();
    public void push(T item){
        top=new Node<>(item,top);
    }
    public T pop(){
        T result = top.item;
        if(!top.end()){
            top=top.next;
        }
        return  result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss = new LinkedStack<>();
        for(String s:"Phasers on stun!".split(" ")){
            lss.push(s);
        }
        String s;
        while ((s=lss.pop())!=null){
            System.out.println(s);
        }
    }
}
