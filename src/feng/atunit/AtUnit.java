package feng.atunit;

import feng.util.javaUtil.BinaryFile;
import feng.util.javaUtil.ProcessFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过反射抽取注解，该程序通过注解中的信息来决定如何构造测试对象
 */
public class AtUnit implements ProcessFiles.Strategy {
    static Class<?> testClass;
    static List<String> failedTests=new ArrayList<>();
    static long testsRun =0;
    static long failures=0;

    public static void main(String[] args) throws Exception {

    }
    @Override
    public void process(File cfile) {
        try {
            String cName=ClassNameFinder.thisClass(BinaryFile.read(cfile));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
