package feng.Q_IO.B_IO流;

import java.io.*;

public class BasicFileOutPut {
    static String file="C:\\Users\\swall\\Documents\\a-Study\\yonyou\\yongyou.md";
    static String outFile="D:\\project\\test\\yonyou.md";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
        String s;
        int lineCount=1;
        while ( (s=in.readLine())!=null)
            out.println(s);
        out.close();
        System.out.println(BufferedInputFile.read(outFile));
    }
}
