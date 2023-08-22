package feng.L_Exception.test;

public class T_1 {
    public static void main(String[] args) {
        try{
            throw new Exception("Hello , this is a Exception");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
