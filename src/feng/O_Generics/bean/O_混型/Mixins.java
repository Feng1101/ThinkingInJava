package feng.O_Generics.bean.O_混型;


import java.util.Date;

/**
 * 与接口混型,Java 由于擦除机制的原因,不能使用泛型.
 * 使用接口组合类
 */
//时间戳接口
interface TimeStamped { long getStamp();}

class TimeStampedImp implements TimeStamped{
    private final long timeStamp;
    public TimeStampedImp(){timeStamp=new Date().getTime();}
    public long getStamp(){return  timeStamp;}
}
//序列号接口
interface SerialNumbered { long getSerialNumbered();}

class SerialNumberedImp implements SerialNumbered{
    private static long counter= 1;
    private final long serialNumber=counter++;
    public long getSerialNumbered(){return serialNumber;}
}
//基础组件接口
interface Basic{
    public void set (String val);
    public String get();
}
class BasicImp implements Basic{
    private String value;
    public void set (String val){
        this.value=val;
    }
    public String get(){return value;}
}
//混合类
class Mixin extends BasicImp
    implements TimeStamped,SerialNumbered{
    private TimeStamped timeStamp=new TimeStampedImp();
    private SerialNumbered serialNumber=new SerialNumberedImp();
    public long getStamp(){return timeStamp.getStamp();}
    public long getSerialNumbered(){return serialNumber.getSerialNumbered();}
}

public class Mixins{
    public static void main(String[] args) {
        Mixin mixin1=new Mixin(), mixin2 = new Mixin();
        mixin1.set("test String 1");
        mixin2.set("test String 2");
        System.out.println(mixin1.get()+" "+mixin1.getStamp()+" "+mixin1.getSerialNumbered());
        System.out.println(mixin2.get()+" "+mixin2.getStamp()+" "+mixin2.getSerialNumbered());
    }
}
