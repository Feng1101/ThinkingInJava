package feng.S_Annotations.B_注解处理器;

import feng.S_Annotations.A_基本语法.PasswordUtils;
import feng.S_Annotations.A_基本语法.UseCase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 通过反射来利用注解的一个小的处理器，getDeclaredMethods()    getAnnotation(T.classs)
 */
public class UseCaseTracker {
    public static  void trackUseCases(List<Integer> useCases,Class<?> cl){
        for(Method m :cl.getDeclaredMethods()){
            UseCase uc = m.getAnnotation(UseCase.class);
            if(uc!=null){
                System.out.println("Found Use Case:"+uc.id()+" "+uc.description());
                useCases.remove(new Integer(uc.id()));
            }
        }
        for(int i: useCases){
            System.out.println("Warning: Missing use case- "+i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases,47,48,49,50);
        trackUseCases(useCases, PasswordUtils.class);
    }
}
