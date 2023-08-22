package feng.P_Containers.C_Set和存储顺序;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 该类的子类为TreeSet,可由其生成
 */
public class SortedSetDemo {
    public static void main(String[] args) {

        TreeSet<String> sortedSet = new TreeSet<>();
        TreeSet<String> testSet = new TreeSet<>();
        Collections.addAll(sortedSet,"one two three four five six seven eight nine ten" .split(" "));
        System.out.println(sortedSet);
        String low = sortedSet.first();
        String high = sortedSet.last();
        System.out.println(low);
        System.out.println(high);

        Iterator<String> iterator = sortedSet.iterator();
        for(int i=0;i<=6;i++){
            if(i==3) low=iterator.next();
            if(i==6) high=iterator.next();
            else iterator.next();
        }
        System.out.println(low);
        System.out.println(high);
        System.out.println(sortedSet.subSet(low,high));
        System.out.println(sortedSet.headSet(high));
        System.out.println(sortedSet.tailSet(low));
    }
}
