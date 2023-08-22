package feng.P_Containers.D_队列;

import javafx.scene.layout.Priority;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 优先级队列的使用,细节
 */
public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
    //优先级队列中的元素需要能够进行比较,具体的比较规则可以自行设置
    static class ToDoItem implements Comparable<ToDoItem>{
        private char primary;
        private int secondary;
        private String item;
        public ToDoItem(String td ,char pri , int sec){
            primary=pri;
            secondary=sec;
            item=td;
        }
        public int compareTo(ToDoItem arg){
            if(primary>arg.primary)
                return +1;

            if(primary == arg.primary)
                if(secondary>arg.secondary)
                    return +1;
                else if(secondary == arg.secondary)
                    return 0;

            return -1;
        }
        public String toString(){
            //字符转字符串需要使用该方法,否则会被转成hashCode相加
            return Character.toString(primary) + secondary+": "+item;
//            return primary+secondary+": "+item;
        }
    }
    public void add(String td , char pri ,int sec){
        super.add(new ToDoItem(td,pri,sec));
    }

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.add("Empty trash ", 'C',4);
        toDoList.add("Feed dog",'B' , 2);
        toDoList.add("Feed bird" , 'B',7);
        toDoList.add("test333",'C',3);
        while (!toDoList.isEmpty()){
            System.out.println(toDoList.remove());
        }
    }
}
