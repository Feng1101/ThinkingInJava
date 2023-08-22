package feng.Q_IO.H_标准IO;

import java.io.*;

/**
 * 重定向系统的输入与输出位置，可以用于日志查询
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("D:\\project\\test\\yonyou.md"));
        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("D:\\project\\test\\yonyou2.md")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=br.readLine())!= null)
            System.out.println(s);
        out.close();
        System.setOut(console);
    }
}
