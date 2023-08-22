package feng.util.javaUtil;

import java.io.File;
import java.io.IOException;

/**
 * 结合Directory 工具类，策略模式的一种体现，Process可以让我们对文件进行单独地处理
 */
public class ProcessFiles {
    public interface Strategy{
        void process(File file);
    }

    private Strategy strategy;
    private String ext;

    public ProcessFiles(Strategy strategy , String ext){
        this.strategy = strategy ;
        this.ext = ext;
    }

    public void start (String [] args){
        try{
            if(args.length == 0){
                processDirectoryTree(new File("."));
            }else {
                for (String arg : args){
                    File fileArg=new File(arg);
                    if(fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else{
                        if(!arg.endsWith("."+ext))
                            arg+="."+ext;
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }
            }
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
    }

    public void processDirectoryTree(File root) throws IOException{
        for(File file: Directory.walk(root.getAbsolutePath(),".*\\."+ext))
            strategy.process(file.getCanonicalFile());
    }

    public static void main(String[] args) {
        new ProcessFiles(new Strategy(){
            public void process(File file){
                System.out.println(file);
            }
        },"java").start(args);
    }


}
