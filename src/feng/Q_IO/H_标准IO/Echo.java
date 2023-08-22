package feng.Q_IO.H_标准IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 标准输出已经被包装好，如System.out,System.err。
 * 标准输入需要单独进行包装
 */
public class Echo {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in)
        );
        String s;
        while((s = stdin.readLine())!=null && s.length() != 0)
            System.out.println(s);

    }
}
