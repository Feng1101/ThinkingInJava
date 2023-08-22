package feng.R_Enumerted.D_values;

/**
 * 每天一个没什么用的小寄巧
 */
public class NoEnum {
    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try{
            for (Object en : intClass.getEnumConstants())
                System.out.println(en);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
