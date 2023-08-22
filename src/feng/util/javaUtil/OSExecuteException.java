package feng.util.javaUtil;

/**
 * java提供程序的输入和输出,并抛出运行时异常
 */
public class OSExecuteException  extends RuntimeException{
    public OSExecuteException (String why){
        super(why);
    }
}
