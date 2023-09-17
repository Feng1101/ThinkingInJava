package feng.LeetCode.HW;

import com.sun.deploy.util.StringUtils;

import java.util.Locale;
import java.util.Scanner;

public class HJ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine().toLowerCase();
        String s2=sc.nextLine();
        System.out.println(s1.length()-s1.replaceAll(s2,"").length());
    }
}
