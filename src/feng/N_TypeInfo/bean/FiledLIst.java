package feng.N_TypeInfo.bean;

import java.util.ArrayList;
import java.util.List;

class CountedInteger{
    private static long counter;
    private final long id =counter++;
    public String toString(){
        return Long.toString(id);
    }
}
public class FiledLIst<T> {
    private  Class<T> type;
    public FiledLIst(Class<T> type){
        this.type=type;
    }
    public List<T> create(int nElements){
        List<T> list=new ArrayList<>();
        try{
            for (int i=0;i<nElements;i++){
                list.add(type.newInstance());
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return list;
    }

    public static void main(String[] args) {
        FiledLIst<CountedInteger> fl=new FiledLIst<>(CountedInteger.class);
        System.out.println(fl.create(15));
    }
}
