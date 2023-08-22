package feng.Q_IO.K_压缩;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

public class ZipCompress {
    public static void main(String[] args) throws IOException {
        FileOutputStream f = new FileOutputStream("test.zip");
        //CheckSum类可用来校验和计算文件和 Adler32,CRC32(慢一些，更准确
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        zos.setComment("A test of Java Zipping");

        for(String arg:args){
            System.out.println("Writing file "+ arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));
            //对于每一个要加入压缩档案的文件，都要调用此方法
            zos.putNextEntry(new ZipEntry(arg));
            int c;
            while ((c=in.read())!= -1 )
                out.write(c);
            in.close();
            out.flush();
        }
        out.close();
        System.out.println("Checksum: "+csum.getChecksum().getValue());
        System.out.println("Reading FIle");
        FileInputStream fi = new FileInputStream("test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);
        ZipEntry ze;
        while ( (ze =in2.getNextEntry())!=null){
            System.out.println("Reading file "+ze);
            int x;
            while((x=bis.read()) != -1){
                System.out.write(x);
            }
        }
        if(args.length==1)
            System.out.println("CheckSum: "+csumi.getChecksum().getValue());
        bis.close();
        ZipFile zf = new ZipFile("test.zip");
        Enumeration<? extends ZipEntry> e = zf.entries();
        while(e.hasMoreElements()){
            ZipEntry ze2 = e.nextElement();
            System.out.println("File: "+ze2);
        }



    }
}
