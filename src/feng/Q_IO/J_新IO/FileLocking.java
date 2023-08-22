package feng.Q_IO.J_新IO;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * 可以对资源上锁，该锁操作系统可见，用于防止其他线程控制资源
 */
public class FileLocking {
    public static void main(String[] args) throws Exception{
        FileOutputStream fos = new FileOutputStream("file.txt");
        FileLock fl = fos.getChannel().tryLock();
        if(fl != null){
            System.out.println("Locked File");
            TimeUnit.MILLISECONDS.sleep(100);
            fl.release();
            System.out.println("Released Lock");
        }
        fos.close();
    }
}
