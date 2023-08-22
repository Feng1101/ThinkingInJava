package feng.Q_IO.J_新IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 将一个通道与另一个通道进行连接
 * 为什么通道的IO形式更快
 * 它更接近操作系统底层的读写逻辑
 */
public class TransferTo {
    public static void main(String[] args) throws Exception{
        if(args.length!=2){
            System.out.println("arguments: sourceFile destFile");
            System.exit(1);
        }
        FileChannel in = new FileInputStream(args[0]).getChannel(),
                    out=new FileOutputStream(args[1]).getChannel();
        in.transferTo(0,in.size(),out);
        /*or
        out.transferFrom(in,0,in.size());
         */
    }
}
