package feng.P_Containers.D_队列;

import feng.util.javaUtil.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 各种队列的展示
 */
public class QueueBehavior {
    private static int count=10;
    static <T> void test(Queue<T> queue, Generator<T> gen){
        for(int i=0;i<count;i++){
            queue.offer(gen.next());
        }
        while(queue.peek()!=null)
            System.out.print(queue.remove()+ " ");
        System.out.println();
    }

    static class Gen implements Generator<String>{
        String [] s="one two three four five six seven eight nine ten".split(" ");
        int i;
        public String next(){return  s[i++]; }
        public boolean hasNext(){return true;}
    }

    public static void main(String[] args) {
        //各种队列的展示
        test(new LinkedList<>(),new Gen());
        //优先级队列,按照优先级排序
        test(new PriorityQueue<>(),new Gen());
        test(new ArrayBlockingQueue<>(count),new Gen());
        test(new ConcurrentLinkedQueue<>(),new Gen());
        test(new LinkedBlockingQueue<>(),new Gen());
        test(new PriorityBlockingQueue<>(),new Gen());
    }
}
