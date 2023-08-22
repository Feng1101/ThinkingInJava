package feng.N_TypeInfo.exampleTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * 用于获取一个类的所有方法，利用class和反射机制
 * 一个参数显示所有方法，两个参数 第二个为int，表示只展示多于该长度的方法
 */
public class ShowMethods {
    private static Pattern p= Pattern.compile("(\\w+\\.)|(final)");

    public static void main(String[] args) {
        if(args.length<1){
            System.out.println("You need to give me a arg, a Class's name");
            System.exit(0);
        }
        int lines=0;

        try {
            Class<?> c =Class.forName(args[0]);
            Method[] methods = c.getMethods();
            Constructor<?>[] constructors = c.getConstructors();
            for(Method method:methods){
                System.out.println(method.toString());
            }
            System.out.println("----------------");
            if(args.length==1){
                for(Method method:methods){
                    System.out.println(
                            p.matcher(method.toString()).replaceAll("")   //将正则表达式匹配的部分全部替换为空字符
                    );
                }
                for(Constructor<?> cons:constructors){
                    System.out.println(
                            p.matcher(cons.toString()).replaceAll("")
                    );
                }
                lines= methods.length+ constructors.length;
            }else{
                for(Method method:methods){
                    if(method.toString().indexOf(args[1])!=-1){
                        System.out.println(
                                p.matcher(method.toString()).replaceAll("")

                        );
                        lines++;
                    }
                }
                for(Constructor<?> cons:constructors){
                    if(cons.toString().indexOf(args[1])!=-1){
                        System.out.println(
                                p.matcher(cons.toString()).replaceAll("")
                        );
                        lines++;
                    }
                }
            }

        }catch (ClassNotFoundException e){
            System.out.println("No such Class: "+e);
        }
    }
}
