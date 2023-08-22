package feng.N_TypeInfo.exampleTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 简单动态代理,首先代理类需要实现InvocationHandler接口
 */
class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;
    public DynamicProxyHandler(Object proxied){
        this.proxied=proxied;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("***** proxy: "+proxy.getClass()+", method: "+method+", args: "+args);
        if(args!=null){
            for(Object arg:args){
                System.out.println("   "+arg);
            }
        }
        return method.invoke(proxied,args);
    }
}

public class SimpleDynamicProxy {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("boom");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);
        //通过动态代理创建类，传入和输出都是Object类型
        Interface proxy= (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),    //被加载对象类型的类加载器
                new Class[]{Interface.class},          //该代理实现的接口列表，这里是Interface 的两个接口
                new DynamicProxyHandler(realObject)     //一个实现了InvocationHandler的实现类
        );//最终实现了动态代理，生成了对应的类，该类属于Interface，拥有Interface的实现接口
        consumer(proxy);
    }

}
