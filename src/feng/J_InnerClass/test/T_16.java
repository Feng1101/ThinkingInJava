package feng.J_InnerClass.test;

import feng.J_InnerClass.bean.Implementation1;
import feng.J_InnerClass.bean.Implementation2;
import feng.J_InnerClass.bean.Service;
import feng.J_InnerClass.bean.factory.ServiceFactory;

public class T_16 {
    public static void serviceConsumer(ServiceFactory factory){
        Service service = factory.getService();
        service.method1();
        service.method2();
    }

    //通过匿名的方式使用工厂，有工厂方法那味了
    public static void main(String[] args) {
        serviceConsumer(Implementation1.factory);
        serviceConsumer(Implementation2.factory);
    }
}
