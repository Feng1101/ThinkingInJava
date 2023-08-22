package feng.M_String.bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * java中正则表达式中的\ 用\\表示就对了，而普通的\ 需要\\\\来进行表示，很难的辣
 */
public class IntegerMatch {
    public static void main(String[] args) {
        System.out.println("123".matches("-?\\d+"));
        System.out.println("-123".matches("-?\\d+"));
        System.out.println("+123".matches("-?\\d+"));
        System.out.println("+123".matches("(0|\\+)?\\d+"));   //正则表达式中+具有特殊意义，需要转意
        Pattern p=Pattern.compile("[A-Z]+.*[。]+");
        System.out.println("a123。".matches("[A-Z]+.*[。]+"));
        Pattern.compile("(0|\\+)?\\d+");
        Matcher matcher = p.matcher("A123.");
    }
}
