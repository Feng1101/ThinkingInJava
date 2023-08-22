package feng.S_Annotations.B_注解处理器;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//仅用于Class类
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
    public String name() default "";
}
