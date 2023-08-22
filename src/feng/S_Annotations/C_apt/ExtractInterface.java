package feng.S_Annotations.C_apt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)//Source 只在源代码层保留，运行时丢弃，无法用反射拿到
public @interface ExtractInterface {
    public String value();
}
