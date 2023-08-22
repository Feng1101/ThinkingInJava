package feng.K_HoldingObjects.beans;

import java.util.Iterator;

/**
 * 这个类实现了Iterator接口，其他类可以通过传递Iterator来减小耦合度
 * 即使没有集成Collection或者AbstractCollection，只要实现了Iterator接口，就可以使用foreach()
 */
public class NonCollectionSequence {
    protected String[] numbers={"a","b","c"};
    public Iterator<String> iterator(){
        return new Iterator<String>() {
            private  int index=0;
            @Override
            public boolean hasNext() {
                return index<numbers.length;
            }

            @Override
            public String next() {
                return numbers[index++];
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        NonCollectionSequence list = new NonCollectionSequence();
        Iterator<String> ite = list.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());
        }

    }
}
