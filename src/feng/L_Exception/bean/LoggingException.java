package feng.L_Exception.bean;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 记录错误的日志,利用Logger公共组件，简单记录错误
 */
public class LoggingException extends Exception{
    private static Logger logger=Logger.getLogger("LoggerException");
    public LoggingException(){
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
