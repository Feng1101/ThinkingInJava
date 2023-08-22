package feng.Q_IO.B_IO流;

import java.io.IOException;

public class RandomAccessFile1 {
    static String file = "D:\\project\\test\\RandomAccess.txt";
    static void display() throws IOException{
        java.io.RandomAccessFile rf = new java.io.RandomAccessFile(file, "r");
        for(int i=0;i<7 ; i++){
            System.out.println("Value "+ i + ": "+rf.readDouble());
        }
        System.out.println(rf.readUTF());
        rf.close();
    }

    public static void main(String[] args)  throws  IOException{
        java.io.RandomAccessFile rf = new java.io.RandomAccessFile(file, "rw");
        for(int i =0;i<7;i++)
            rf.writeDouble(i*1.414);
        rf.writeUTF("The end of the file");
        rf.close();
        display();
        rf=new java.io.RandomAccessFile(file,"rw");
        rf.seek(5*8);
        rf.writeDouble(47.0001);
        rf.close();
        display();
    }
}
