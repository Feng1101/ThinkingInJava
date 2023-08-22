package feng.util.javaUtil;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

//具备一定的享元思想,享元: 公共的源,其他的均为指针指向特定对象,不需要单独进行复制
public class CountingMapData  extends AbstractMap<Integer,String> {
    private int size;
    private static String[] chars="A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");
    public CountingMapData(int size){
        if (size<0)
            size=0;
        else
            this.size=size;
    }

    private static class Entry implements Map.Entry<Integer ,String >{
        int index;
        Entry (int index){this.index =index;}
        public boolean equals(Object o){
            return Integer.valueOf(index).equals(o);
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index % chars.length] + Integer.toString(index/chars.length);
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }
        public int hashCode(){
            return Integer.valueOf(index).hashCode();
        }

    }

    //继承AbstractMap需要实现的具体接口
    public Set<Map.Entry<Integer,String>> entrySet(){
        Set <Map.Entry<Integer,String>> entries=new LinkedHashSet<>();
        for(int i=0;i<size;i++){
            entries.add(new Entry(i));
        }
        return entries;
    }

    public static void main(String[] args) {
        System.out.println(new CountingMapData(60));
    }
}
