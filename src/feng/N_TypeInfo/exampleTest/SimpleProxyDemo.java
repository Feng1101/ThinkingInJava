package feng.N_TypeInfo.exampleTest;

/**
 * 简单代理方法，将类交给其他类来实现，可以方便的进行扩展和添加功能
 */
interface Interface{
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface{
    public void doSomething(){
        System.out.println("doSomething..");
    }
    public void somethingElse(String arg){
        System.out.println("somethingElse "+arg);
    }
}

class SimpleProxy implements Interface{
    private Interface proxied;
    public SimpleProxy(Interface proxied){
        this.proxied=proxied;
    }
    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }
    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy someThingElse "+arg);
        proxied.somethingElse(arg);
    }
}

public class SimpleProxyDemo{
    public static  void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("Boom");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
