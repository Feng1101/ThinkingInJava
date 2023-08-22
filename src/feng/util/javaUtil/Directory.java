package feng.util.javaUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 目录实用工具
 */
public final class Directory {
    public static  File[] local(File dir,final String regex){
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern=Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(
                        new File(name).getName()
                ).matches();
            }
        });
    }

    public static File[] local(String path,final String regex){    //overLoad
        return local(new File(path),regex);
    }

    public static class TreeInfo implements Iterable<File>{
        public List<File> files= new ArrayList<File>();
        public List<File> dirs=new ArrayList<File>();
        //注意，这里返回的是files 的 iterator，所以循环自动调用的是files，不是dirs
        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }
        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.files);
        }

        public String toString(){
            return "dirs: "+PPrint.pformat(dirs)+"\n\nfiles: "+ PPrint.pformat(files);
        }
    }
    static TreeInfo recurseDirs(File startDir,String regex){
        TreeInfo result = new TreeInfo();
        for(File item: startDir.listFiles()){
            if(item.isDirectory()){
                result.dirs.add(item);
                result.addAll(recurseDirs(item,regex));
            }else
                if(item.getName().matches(regex))
                    result.files.add(item);
        }
        return result;
    }
    public static TreeInfo walk (String start, String regex){
        return recurseDirs(new File(start),regex);
    }

    public static TreeInfo walk(File start,String regex){
        return recurseDirs(start,regex);
    }

    public static TreeInfo walk(File start){
        return recurseDirs(start,".*");
    }

    public static  TreeInfo walk(String start){
        return recurseDirs(new File(start),".*");
    }

    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println(walk("C:\\Users\\swall\\Documents\\a-Study\\yonyou",".*md"));
        }else
            for(String arg:args){
                System.out.println(walk(arg));
            }
    }

}
