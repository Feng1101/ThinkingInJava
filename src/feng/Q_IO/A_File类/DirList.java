package feng.Q_IO.A_File类;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
    //使用匿名内部类的方式实现
    public static FilenameFilter filter(final String regex){
        return  new FilenameFilter() {
            private Pattern pattern=Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }
    public static void main(String[] args) {
        File path = new File("C:\\Users\\swall\\Documents\\a-Study\\yonyou");
        String [] list;
        if(args.length == 0)
            list=path.list();
        else list=path.list(filter(args[0]));
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem:list){
            System.out.println(dirItem);
        }
    }
}
//java 目录（文件）过滤类，简易即可生成
class DirFilter implements FilenameFilter{
    private Pattern pattern;
    public DirFilter (String regex){
        pattern = Pattern.compile(regex);
    }
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
