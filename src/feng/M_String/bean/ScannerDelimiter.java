package feng.M_String.bean;

import java.util.Scanner;

/**
 * Scanner 使用定界符，默认为空格，可以自行设置
 */
public class ScannerDelimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner("12,42,78 , 99, 42");
        scanner.useDelimiter("\\s*,\\s*");//, 前后可有多个或没有空格
        while (scanner.hasNext()){
//            System.out.println(scanner.nextInt());
            System.out.println(scanner.next());
        }
    }
}
