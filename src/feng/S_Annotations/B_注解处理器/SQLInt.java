package feng.S_Annotations.B_注解处理器;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInt {
    int value() default 0;
    String name() default "";
    //可以通过后缀的形式修改嵌套注解中的默认值
    Constraints constraints() default @Constraints(unique = true);
}
