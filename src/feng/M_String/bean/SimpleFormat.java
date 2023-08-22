package feng.M_String.bean;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * Formatter 类型举例
 * Formatter 需要初始化，即一个新的对象，需要PrintStream 作为其参数
 * String.format()
 */
public class SimpleFormat {
     final static  String FIRST="%-5s";
     //format 可以通过字符来控制固定长度
     final static String SECOND="%10.2f";
    public static void main(String[] args) {
        PrintStream errAlia=System.err;
        Formatter f=new Formatter(errAlia);
        int x =5;
        double y=3.141592;
        System.out.format("Row 1:"+FIRST+SECOND +"\n",x+100,y);
        f.format("Row 2:"+ FIRST +SECOND +"\n",x,y);
    }
}
