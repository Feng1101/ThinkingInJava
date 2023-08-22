package feng.Q_IO.B_IO流;

import java.io.*;

/**
 * 此方法存储的数据不可读，只能通过该方法读取
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        String file="D:\\project\\test\\yonyou.md";
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        out.writeDouble(3.14159);
        out.writeUTF("That was pi");
        out.writeDouble(1.4141);
        out.writeUTF("Square root of 2");
        out.close();
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
        System.out.println(in.readDouble());
        System.out.println(in.readUTF());
    }
}
