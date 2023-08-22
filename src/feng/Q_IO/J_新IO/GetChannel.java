package feng.Q_IO.J_新IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 缓冲器,旧IO中InputStream类都已经被优化,这里着重使用Reader和Writer类的优化方法
 * 通道的方式进行IO数据层的传输
 */
public class GetChannel {
    private static  final  int BSIZE=1024;

    public static void main(String[] args)  throws Exception{
        //获取通道,通道建立再Bytes层
        FileChannel fc = new FileOutputStream( "data.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text ".getBytes()));
        fc.close();


        fc=new RandomAccessFile("data.txt","rw").getChannel();
        fc.position(fc.size());//Move to the end
        fc.write(ByteBuffer.wrap("Some more".getBytes()));
        fc.close();

        fc=new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        //read 后需要调用flip,让缓冲器做好被调用的准备
        fc.read((buff));
        buff.flip();
        while(buff.hasRemaining())
            System.out.print((char)buff.get());
    }
}
