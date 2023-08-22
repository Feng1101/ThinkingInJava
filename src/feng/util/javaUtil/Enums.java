package feng.util.javaUtil;

import java.util.Random;

public class Enums {
    private static Random rand = new Random(47);
    //该泛型属于自限定泛型，将T限制到了Enum类，T是enum的一个实例
    public static <T extends Enum<T>> T random(Class<T> ec){
        return random(ec.getEnumConstants());
    }
    public static <T> T random(T[] values){
        return values[rand.nextInt(values.length)];
    }
}
