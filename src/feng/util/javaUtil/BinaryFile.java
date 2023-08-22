package feng.util.javaUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * 二进制文件的读写方式
 */
public class BinaryFile {
    public static byte[] read(File bFile) throws IOException{
        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));
        try{
            byte[] data = new byte[bf.available()];
            bf.read(data);
            return data;
        }finally {
            bf.close();
        }
    }

    //这种重载的思路很好,既简单也有较高的复用性
    public static byte[] read(String bFile) throws IOException{
        return read(new File(bFile).getAbsolutePath());
    }

    public static void main(String[] args) {
        Directory.TreeInfo info = Directory.walk("D:\\yonyou\\project\\Thinking in Java\\src\\feng\\Q_IO", ".*class");
        System.out.println(info);
        List<File> files = info.files;
        for(File file:files){
            try {
                byte[] read = read(file);
                for(int i=0;i<read.length;i++){
                    System.out.print(read[i]);
                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }

        }
    }
}
