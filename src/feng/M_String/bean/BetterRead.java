package feng.M_String.bean;

import java.util.Scanner;

/**
 * java Scanner 用于读取文件、字符串、数字等
 * 功能强大，可以接受任何类型的输入对象
 */
public class BetterRead {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(SimpleRead.input);
        System.out.println("What's your name?");
        String name = scanner.nextLine();
        System.out.println(name);
        System.out.println("How old are you? What is your favorite number");
        System.out.println("(input: <age> <double>)");
        int age =scanner.nextInt();
        double number = scanner.nextDouble();
        System.out.println(age);
        System.out.println(number);
    }
}
