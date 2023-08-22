package feng.M_String.bean;

import java.io.BufferedReader;
import java.io.StringReader;

/**
 * 基础的输入，只能readLine()，然后对行输入进行处理
 */
public class SimpleRead {
    public static BufferedReader input=new BufferedReader(
            new StringReader("Sir Robin of Camelot\n22 3.1415926")
    );

}
