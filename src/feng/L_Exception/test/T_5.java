package feng.L_Exception.test;

/**
 * 恢复模型，不断重复，直到异常消失
 */
public class T_5 {
    public static void main(String[] args) {
        int i=5;
        while(i>0){
            try {
                throw new Exception("i is bigger than 0");
            }catch (Exception e ){
                e.printStackTrace();
                i--;
            }
        }
        System.out.println(" now , we are out of the try");
    }
}
