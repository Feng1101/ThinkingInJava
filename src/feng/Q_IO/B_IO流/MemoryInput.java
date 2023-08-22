package feng.Q_IO.B_IO流;

import java.io.IOException;
import java.io.StringReader;

/**
 * 从内存输入，StringReader 用于 读取字符流
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("C:\\Users\\swall\\Documents\\a-Study\\yonyou\\yongyou.md"));
        int c ;
        while ((c=in.read())!= -1)
            System.out.print((char)c);
    }
}
