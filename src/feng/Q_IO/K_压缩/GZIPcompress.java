package feng.Q_IO.K_压缩;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPcompress {
    public static void main(String[] args) throws IOException {
         if(args.length==0){
             System.out.println(
                     "Usage: \nGZIPcompress file]\n"+
                             "\t Uses GZIP compression to compress "+
                             "the file to test.gz"
             );
             System.exit(1);
         }
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
        /* out类压缩只接受Stream类，不接受Writer
        BufferedWriter out2 = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream("test2.gz"))));
         */
        System.out.println("Writing file");
        int c;
        while((c=in.read())!=-1){
            out.write(c);
//            out2.write(c);
        }
        in.close();
        out.close();
        System.out.println("Reading file");
        //注意这里，压缩类对字节进行处理，要想使用Reader的话需要使用InputStreamReader进行转换
        BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
        String s;
        while((s=in2.readLine() )!=null)
            System.out.println(s);
    }
}
