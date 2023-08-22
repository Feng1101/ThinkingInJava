package feng.O_Generics.bean.O_混型;

import java.util.Date;

/**
 * 使用装饰器模式
 */
class Base{
    private String value;
    public void set (String val){value=val;}
    public String get(){return value;}
}
class Decorator extends Base{
    protected Base base;
    public Decorator (Base base){this.base=base;}
    public void set(String val){base.set(val);}
    public String get(){return  base.get();}
}

class TimeStamped1 extends Decorator{
    private final long timeStamp;
    public TimeStamped1(Base base){
        super(base);
        timeStamp=new Date().getTime();
    }
    public long getTimeStamp(){return timeStamp;}
}

class SerialNumbered1 extends Decorator{
    private static long counter=1;
    private final long serialNumber=counter++;
    public SerialNumbered1(Base base){
        super(base);
    }

    public long getSerialNumber() {
        return serialNumber;
    }
}

public class Decoration{
    public static void main(String[] args) {
        TimeStamped1 t1 = new TimeStamped1(new Base());
        TimeStamped1 t2 = new TimeStamped1(new SerialNumbered1(new Base())); //并没有什么用，只能使用最后一层装饰类的所有方法
        System.out.println(t1.getTimeStamp());
        System.out.println(t2.getTimeStamp());
    }
}
