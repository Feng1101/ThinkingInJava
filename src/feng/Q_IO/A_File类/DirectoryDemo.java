package feng.Q_IO.A_File类;

import feng.util.javaUtil.Directory;

import java.io.File;

public class DirectoryDemo {
    public static void main(String[] args) {
        for(File file : Directory.walk("C:\\Users\\swall\\Documents\\a-Study\\yonyou",".*\\.md"))
            System.out.println(file);
    }
}
