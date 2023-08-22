package feng.M_String.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T_11 {
    public static void main(String[] args) {
        String a="(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";
        String a2="[a-z]\\w+";
        String b="Arline ate eight apples and one orange while Anita hadn't any";
        //字符串可以直接分割
        System.out.println(Arrays.asList(b.split(" ")));;
        //通过Pattern进行字符串分割
        Pattern p=Pattern.compile(a2);
        String[] split = p.split(b);
        System.out.println(Arrays.asList(split));

        Matcher m = p.matcher(b);
        int i=0;
        while (m.find()){
            System.out.println(m.group()+"   " + m.start()+"   " +m.end());
        }
    }
}
