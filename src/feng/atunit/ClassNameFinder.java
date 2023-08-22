package feng.atunit;

import feng.util.javaUtil.BinaryFile;
import feng.util.javaUtil.Directory;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.util.HashMap;

/**
 * 该程序用于读取class类文件的信息。
 * class类具有固定的格式，所以能够根据此进行读取
 */
public class ClassNameFinder {
    public static String thisClass(byte[] classBytes){
        HashMap<Integer, Integer> offsetTable = new HashMap<>();
        HashMap<Integer, String> classNameTable = new HashMap<>();
        try{
            DataInputStream data = new DataInputStream(new ByteArrayInputStream(classBytes));
            int magic = data.readInt();
            int minorVersion = data.readShort();
            int majorVersion=data.readShort();
            int constant_pool_count=data.readShort();
            int[] constant_pool= new int [constant_pool_count];
            for(int i=1 ; i<constant_pool_count; i++){
                int tag=data.read();
                int tableSize;
                switch (tag){
                    case 1://UTF
                        int length=data.readShort();
                        char[] bytes=new char[length];
                        for(int k=0; k< bytes.length; k++)
                            bytes [k] = (char)data.read();
                        String className=new String(bytes);
                        classNameTable.put(i,className);
                        break;
                    case 5: //LONG
                    case 6: //DOUBLE
                        data.readLong(); //discard 8 bytes
                        i++;
                        break;
                    case 7: //CLASS
                        int offset= data.readShort();
                        offsetTable.put(i,offset);
                        break;
                    case 8: //STRING
                        data.readShort();
                        break;
                    case 3://INTEGER
                    case 4://FLOAT
                    case 9://FIELD_REF
                    case 10: //METHOD_REF
                    case 11: //INTERFACE_METHOD_REF
                    case 12: //NAME_AND_TYPE
                        data.readInt();
                        break;
                    default:
                        throw new RuntimeException("Bad tag "+tag);
                }
            }
            short access_flags=data.readShort();
            int this_class=data.readShort();
            int super_class=data.readShort();
            return classNameTable.get(offsetTable.get(this_class)).replace('/','.');
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws  Exception {
        if(args.length>0){
            for(String arg: args)
                System.out.println(thisClass(BinaryFile.read(new File(arg))));
        }else
            for(File klass: Directory.walk(".",".*\\.class"))
                System.out.println(thisClass(BinaryFile.read(klass)));
    }
}
