package feng.O_Generics.bean;

/**
 * 元组，通过final保证安全性，初始化完毕后只能读不能写
 * @param <A>
 * @param <B>
 */
public class TwoTuple <A,B>{
    public final A first;
    public final B second;
    public TwoTuple(A a,B b){first=a;second=b;}
    public String toString(){
        return "("+first+", "+second+")";
    }
}
