package feng.N_TypeInfo.bean;

import feng.N_TypeInfo.bean.interfaces.A;
import feng.N_TypeInfo.bean.packageaccess.HiddenC;

import java.lang.reflect.Method;

/**
 * 反射机制，强制执行方法
 */
public class HiddenImplementation {
    public static void main(String[] args)throws Exception{
        A a = HiddenC.makeA();
        a.f();
        /*由于包访问权限，无法进行RTTI
        if(a instanceof C){
            C c=(C)a;
            c.g();
        }
         */
        callHiddenMethod(a,"g");
        callHiddenMethod(a,"u");
        callHiddenMethod(a,"v");
        callHiddenMethod(a,"w");
    }

    static void callHiddenMethod(Object a ,String methodName) throws Exception{
        //通过反射，强制执行方法，需要知道方法的名称
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}
