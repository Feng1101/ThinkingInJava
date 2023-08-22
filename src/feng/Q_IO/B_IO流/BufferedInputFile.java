package feng.Q_IO.B_IO流;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 比较典型的读取方法，缓冲输入，可以提高速度,最常用的读取方式 FileReader
 */
public class BufferedInputFile {
    //Throw exceptions to console
    public static String read(String fileName) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s ;
        StringBuilder sb = new StringBuilder();
        while ((s=in.readLine())!=null){
            sb.append(s+"\n");
        }
        in.close();
        return sb.toString();
    }

    public static void main(String[] args)  throws  Exception{
        System.out.println(read("C:\\Users\\swall\\Documents\\a-Study\\yonyou\\yongyou.md"));
    }

}
