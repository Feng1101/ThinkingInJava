package feng.P_Containers.Q_持有引用;

import java.lang.ref.*;
import java.util.LinkedList;

class VeryBig{
    private static final int SIZE = 10000;
    private long[] la = new long[SIZE];
    private String ident;
    public VeryBig (String id ){ident = id ;}
    public String toString () { return ident; }
    protected  void finalize() {
        System.out.println( " Finalizing "+ ident);
    }
}
public class References {
    private static ReferenceQueue<VeryBig> rq= new ReferenceQueue<>();
    public static void checkQueue(){
        Reference<? extends VeryBig> inq = rq.poll();
        if(null != inq)
            System.out.println(" In queue : "+ inq.get());
    }

    public static void main(String[] args) {
        int size =10;
        if(args.length>0)
            size=new Integer(args[0]);
        LinkedList<SoftReference<VeryBig>> sa = new LinkedList<>();
        //向ReferenceQueue 中添加元素，需要指定rq
        for(int i=0; i< size ; i++){
            sa.add(new SoftReference<VeryBig>(
                    new VeryBig("Weak "+i),rq
            ));
            System.out.println("Just created: "+sa.getLast());
            checkQueue();
        }
        // weakReference
        LinkedList<WeakReference<VeryBig>> wa = new LinkedList<>();
        for(int i=0; i< size ; i++){
            wa.add(new WeakReference<VeryBig>(
                    new VeryBig("Weak "+i),rq
            ));
            System.out.println("Just created: "+wa.getLast());
            checkQueue();
        }

        SoftReference<VeryBig> s = new SoftReference<>(new VeryBig("Soft"));
        WeakReference<VeryBig> w = new WeakReference<>(new VeryBig("Soft"));
        System.gc();
        //Phantomreference
        LinkedList<PhantomReference<VeryBig>> pa = new LinkedList<>();
        for(int i=0; i< size ; i++){
            pa.add(new PhantomReference<VeryBig>(
                    new VeryBig("Weak "+i),rq
            ));
            System.out.println("Just created: "+wa.getLast());
            checkQueue();
        }
    }

}
