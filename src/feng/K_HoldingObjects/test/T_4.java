package feng.K_HoldingObjects.test;

import java.util.*;

public class T_4 {
    static String[] Movies ={"Young and Beautiful","Beautiful Life","Brave Heart","My World","Brave Shine"};
    final static int length= Movies.length;
    static int key=0;

    void next(Collection<String> collection){
        collection.add(Movies[key]);
        key++;
        if(key==length){
            key=0;
        }
    }
    void show(Collection<String> collection){
        for(int i=0;i<5;i++){
            this.next(collection);
        }
        System.out.println(collection);
    }

    public static void main(String[] args) {
        T_4 t4 = new T_4();
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        t4.show(arrayList);
        t4.show(linkedList);
        t4.show(hashSet);
        t4.show(linkedHashSet);
        t4.show(treeSet);

    }
}
