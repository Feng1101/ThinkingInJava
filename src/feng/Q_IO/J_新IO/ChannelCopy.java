package feng.Q_IO.J_新IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通过buffer读写,最普通的Stream流操作
 */
public class ChannelCopy {
    private static  final int BSIZE=1024;

    public static void main(String[] args) throws  Exception{
        if(args.length !=2){
            System.out.println("arguments : sourcefile destfile");
            System.exit(1);
        }
        FileChannel in=new FileInputStream(args[0]).getChannel(),
                    out=new FileOutputStream(args[0]).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        while(in.read(buffer)!=-1){
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
    }
}
