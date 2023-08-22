package feng.K_HoldingObjects.test;

import feng.K_HoldingObjects.beans.Mouse;
import org.omg.CORBA.Object;

import java.util.*;

public class T_11 {
    void init(Collection<Mouse> collection){
        for(int i=0;i<5;i++){
            collection.add(new Mouse(i));
        }
    }
    static void display(Iterator<Mouse> iterator){
        while (iterator.hasNext()){
            Mouse k=iterator.next();
            System.out.println(k.toString());
        }
    }

    public static void main(String[] args) {
        T_11 t7 = new T_11();
        LinkedList<Mouse> mouse = new LinkedList<>();
        t7.init(mouse);
        List<Mouse>copy=new LinkedList<>(mouse.subList(0, 2));
        System.out.println(mouse.subList(0, 2));
        mouse.containsAll(mouse.subList(0, 2));
        //在使用removeAll方法时，不能直接用自己剪出来的子集，需要用新的copy对象
        mouse.removeAll(copy);
        System.out.println(mouse);
        display(mouse.iterator());
        display(copy.iterator());
        HashMap<String, String> map = new HashMap<>();

        Queue<Integer> queue=new LinkedList<>();        //linkedList继承自队列，可以直接向上转型

        map.put("b","a");
        map.put("a","b");
        System.out.println(map);

    }
}
