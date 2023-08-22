package feng.K_HoldingObjects.test;

import feng.K_HoldingObjects.beans.Mouse;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class T_7 {
    void init(Collection<Mouse> collection){
        for(int i=0;i<5;i++){
            collection.add(new Mouse(i));
        }
    }

    public static void main(String[] args) {
        T_7 t7 = new T_7();
        LinkedList<Mouse> mouse = new LinkedList<>();
        t7.init(mouse);
        List<Mouse> mice = mouse.subList(0, 2);

        List<Mouse>copy=new LinkedList<>(mice);
        System.out.println(mice);
        mouse.containsAll(mice);
        //在使用removeAll方法时，不能直接用自己剪出来的子集，需要用新的copy对象
        mouse.removeAll(copy);
        System.out.println(mouse);
    }
}
