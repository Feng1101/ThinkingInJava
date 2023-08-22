package feng.Q_IO.B_IO流;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF {
    public static void main(String[] args)  throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("C:\\Users\\swall\\Documents\\a-Study\\yonyou\\yongyou.md")
                )
        );
        while ( in.available() != 0){
            System.out.print(in.readByte());
        }
    }
}
