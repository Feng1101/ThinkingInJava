package feng.util.myUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class DeleteFile {
    private static String dir=".\\directories.txt";
    void deleteFileNotJava(String string) throws IOException {
        Path path = Paths.get(string);
        Files.walkFileTree(path,
                new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file,
                                                     BasicFileAttributes attrs) throws IOException {
                        if(!file.toFile().getName().endsWith("java")){
                            Files.delete(file);
                            System.out.printf("文件被删除 :%s :%s%n",string,file);
                        }
                        return FileVisitResult.CONTINUE;
                    }

                    //递归从后往前查找文件树
                    @Override
                    public FileVisitResult postVisitDirectory(Path dir,
                                                              IOException exc)  {
                        try{
                            Files.delete(dir);
                            System.out.println("删除空文件夹: "+dir);
                        }catch (IOException e){

                        }
                        return FileVisitResult.CONTINUE;
                    }
                }
        );

    }
    void deleteOther(String string)throws IOException{
        Path path = Paths.get(string);
        Files.walkFileTree(path,
                new SimpleFileVisitor<Path>() {
            //从前往后检索文件树
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir,
                                                             BasicFileAttributes attrs)throws IOException{
                        String name=dir.toFile().getName();
                        if(name.equals(".mvn")||name.equals("test")){
                            System.out.println("准备删除无用文件夹: "+dir);
                            deleteAll(dir.toString());
                            return FileVisitResult.SKIP_SUBTREE;
                        }
                        return FileVisitResult.CONTINUE;
                    }
                }
        );

    }
    void deleteAll(String string)throws IOException{
        Path path = Paths.get(string);
        Files.walkFileTree(path,
                new SimpleFileVisitor<Path>() {
                    // 先去遍历删除文件
                    @Override
                    public FileVisitResult visitFile(Path file,
                                                     BasicFileAttributes attrs) throws IOException {
                            Files.delete(file);
                            System.out.printf("文件被删除 :%s :%s%n",string,file);
                        return FileVisitResult.CONTINUE;
                    }
                    @Override
                    public FileVisitResult postVisitDirectory(Path dir,
                                                              IOException exc)  {
                        try{
                            Files.delete(dir);
                            System.out.println("删除空文件夹: "+dir);
                        }catch (IOException e){

                        }
                        return FileVisitResult.CONTINUE;
                    }
                }

        );
    }
    List<String> readDirectories(String dir) throws IOException {
        File file =new File(dir);
        List<String> result=new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while((line=br.readLine())!=null){
            result.add(line);
        }
        br.close();
        return result;
    }


    public static void main(String[] args) throws IOException {
        DeleteFile deleteFile = new DeleteFile();
        List<String> paths=deleteFile.readDirectories(dir);
        for(String path:paths){
            System.out.println("进入路径为： "+path);
            deleteFile.deleteFileNotJava(path);
            deleteFile.deleteOther(path);
        }
    }
}
