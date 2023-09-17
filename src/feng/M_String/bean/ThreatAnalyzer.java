package feng.M_String.bean;

import java.util.Scanner;
import java.util.regex.MatchResult;

/***
 * 通过scanner扫描正则表达式，可以大幅度提高生产力
 */
public class ThreatAnalyzer {
    static String threatData=
            "58.27.82.161@02/10/2005\n"+
            "58.27.82.161@02/10/2005\n"+
            "58.27.82.161@02/10/2005\n"+
            "58.27.82.161@02/10/2005\n"+
            "58.27.82.161@02/10/2005\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(threatData);
        String pattern="(\\d+.\\d+.\\d+.\\d+)@(\\d{2}/\\d{2}/\\d{4})";
        while (scanner.hasNext(pattern)){
            scanner.next(pattern);
            MatchResult match = scanner.match();
            String test=match.group(0);
            String ip = match.group(1);
            String date = match.group(2);
            System.out.println("all: "+test);
            System.out.println("ip: "+ip);
            System.out.println("date: "+date+"\n");
        }
    }
}
