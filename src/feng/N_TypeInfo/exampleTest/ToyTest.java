package feng.N_TypeInfo.exampleTest;

import feng.N_TypeInfo.bean.FancyToy;
import feng.N_TypeInfo.bean.Toy;

/**
 * Class 的一些常用使用方法
 */
public class ToyTest {
    static  void printInfo(Class cc){
        System.out.println("Class name: "+cc.getName()+" is interface? ["+cc.isInterface()+"]");
        System.out.println("Simple name: "+cc.getSimpleName());
        System.out.println("Canonical name: "+cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Toy toy=new FancyToy();
        FancyToy fancyToy=null;
        if(toy instanceof FancyToy){
            fancyToy= (FancyToy) toy;
        }
        printInfo(fancyToy.getClass());
        Class c=null;
        try{
            c=Class.forName("feng.N_TypeInfo.bean.FancyToy");
        }catch (ClassNotFoundException e){
            System.out.println(e);
            System.exit(1);
        }
        printInfo(c);
        for(Class face:c.getInterfaces()){
            printInfo(face);
        }
        Class up =c.getSuperclass();
        printInfo(up);
        Object obj=null;
        try{
            obj=up.newInstance();
        }catch (InstantiationException e){
            System.out.println("Can't instantiate");
            System.exit(1);
        }catch(IllegalAccessException e){
            System.out.println("Can't access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
