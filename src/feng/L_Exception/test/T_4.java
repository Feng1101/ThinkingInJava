package feng.L_Exception.test;

import feng.L_Exception.bean.SimpleException;

/**
 * 通过给异常类添加构造器，异常类需要继承Exception并使用super（）继承基类的构造方法
 */
public class T_4 {
    public static void main(String[] args) {
        String s="this is a SimpleException";
        try{
            throw new SimpleException(s);
        } catch (SimpleException e) {
            e.printStackTrace();
        }
        try{
            throw new SimpleException();
        } catch (SimpleException e) {
            e.printStackTrace();
        }
    }
}
