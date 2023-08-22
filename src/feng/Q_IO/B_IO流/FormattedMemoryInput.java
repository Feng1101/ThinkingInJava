package feng.Q_IO.B_IO流;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * 格式化的内存输入，在面向字节的输入时，需要使用inputStream类，而不是Reader类
 * 字节形式读取中文会乱码，需要处理
 */
public class FormattedMemoryInput {
    public static void main(String[] args)  throws IOException {
        try{
            DataInputStream in = new DataInputStream(
                    new ByteArrayInputStream(
                            //新的文件类型BufferedInputFile
                            BufferedInputFile.read(
                                    "C:\\Users\\swall\\Documents\\a-Study\\yonyou\\yongyou.md"
                            ).getBytes()
                    )
            );
            while (true)
                System.out.print((char) in.readByte());
        }catch (EOFException e){
            System.err.println("End of stream");
        }
    }
}
