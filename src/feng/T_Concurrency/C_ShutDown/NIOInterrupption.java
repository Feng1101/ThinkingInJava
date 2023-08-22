package feng.T_Concurrency.C_ShutDown;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * nio类提供了不同的I/O中断操作.
 * 被阻塞的nio通道会自动地响应中断
 * 通常使用exec.execute()来启动,并通过shutdownNow()来终结任务
 */
class NIOBLocked implements  Runnable{
    private  final SocketChannel sc;
    public NIOBLocked(SocketChannel sc){this.sc=sc;}
    public void run(){
        try{
            System.out.println("Waiting for read() in "+this);
            sc.read(ByteBuffer.allocate(1));
        }catch (ClosedByInterruptException e){
            System.out.println("CloseedByInterruptException");
        }catch (AsynchronousCloseException e){
            System.out.println("AsynchronousCloseException");
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        System.out.println("Exiting NIOBlocked.run() "+this);
    }
}
public class NIOInterrupption {
    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(8080);
        InetSocketAddress isa = new InetSocketAddress("localhost", 8080);
        SocketChannel sc1 = SocketChannel.open(isa);
        SocketChannel sc2 = SocketChannel.open(isa);
        Future<?> f = exec.submit(new NIOBLocked(sc1));
        exec.execute(new NIOBLocked(sc2));
        exec.shutdown();
        TimeUnit.SECONDS.sleep(1);
        f.cancel(true);
        TimeUnit.SECONDS.sleep(1);
        sc2.close();
    }
}
