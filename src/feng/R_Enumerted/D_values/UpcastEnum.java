package feng.R_Enumerted.D_values;

/**
 * values()方法在enum中是编译器后期插入的一个静态方法。
 * 向上转型后就没有此方法了
 * 不过可以使用Class的原生方法getEnumConstants()获取Enum中的所有value
 */
enum Search{HITHER, YON}
public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e=Search.HITHER;
        //e.values();
        for(Enum en : e.getClass().getEnumConstants())
            System.out.println(en);
    }
}
