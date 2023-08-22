package feng.P_Containers.F_散列码;

public class StringHashCode {
    /**
    字符串型，虽然两个对象，但由于内容相同，最终在内存中的地址相同，默认的hashCOde也就相同
     */
    public static void main(String[] args) {
        String[] hellos = "Hello Hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
    }
}
