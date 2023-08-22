package feng.O_Generics.bean.Q_潜补;

import java.lang.reflect.Method;

/**'
 *通过反射对潜在类型进行补偿,java没有潜在类型机制
 * 缺点是速度较慢,因为运用了反射机制
 */
class Mine{
    public void walkAgainstTheWind(){}
    public void sit(){
        System.out.println("Pretending to sit");
    }
    public void pushInvisibleWalls(){}
    public String toString(){return  "Mine";}
}

class SmartDog{
    public void speak(){
        System.out.println("Woof!");
    }
    public void sit(){
        System.out.println("Sitting!");
    }
    public void reproduce(){}
}

//通用的反射获取某个方法,其实就是面向接口
class CommunicateReflectively{
    public static void perform(Object speaker){
        Class<?> spkr = speaker.getClass();
        try {
            try {
                Method speak = spkr.getMethod("speak");
                speak.invoke(speaker);
            }catch (NoSuchMethodException e){
                System.out.println(speaker + " cannot speak ");
            }
        }catch (Exception e){
            throw new RuntimeException(speaker.toString(),e);
        }
    }
}

public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Mine());
    }
}
