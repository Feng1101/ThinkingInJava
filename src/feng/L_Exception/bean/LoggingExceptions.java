package feng.L_Exception.bean;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 包装其他的异常，将日志信息添加到上面
 */
public class LoggingExceptions {
    private static Logger logger=Logger.getLogger("LogingExceptions");
    static void logException(Exception e){
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));//添加错误信息到trace上
        logger.severe(trace.toString());//封装日志信息
    }

    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        }catch (Exception e){
            logException(e);
        }
    }
}
