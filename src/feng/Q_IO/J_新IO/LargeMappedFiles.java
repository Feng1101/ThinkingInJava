package feng.Q_IO.J_新IO;


import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 内存映射文件，用于处理大于内存的文件读写操作，速度也很快
 * 真NB
 */
public class LargeMappedFiles {
    static int length=0x8FFFFFF;

    public static void main(String[] args) throws  Exception{
        MappedByteBuffer out=new RandomAccessFile("test.dat","rw")
                .getChannel().map(FileChannel.MapMode.READ_WRITE,0,length);
        for (int i = 0; i < length; i++) {
            out.put((byte) 'x');
        }
        System.out.println("Finished writing");
        for (int i = length/2; i < length/2+6; i++) {
            System.out.print((char)out.get(i));
        }
    }
}
