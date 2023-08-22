package feng.P_Containers.A_填充容器;

import feng.util.javaUtil.Generator;
import feng.util.javaUtil.MapData;
import feng.util.javaUtil.Pair;

import java.util.Iterator;

class Letters implements Generator<Pair<Integer,String>>,Iterable<Integer>{
    private int size =9;
    private int number =1;
    private char letter='A';
    //实现Generator接口
    public Pair<Integer,String> next(){
        return new Pair<Integer,String>(number++,""+letter++);
    }
    //实现Iterable接口
    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return number<size;
            }

            @Override
            public Integer next() {
                return number++;
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
}
public class MapDataTest {
    public static void main(String[] args) {
        System.out.println(MapData.map(new Letters(),27));

        System.out.println(MapData.map(new Letters(),"Pop"));
    }
}
