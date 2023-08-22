package feng.O_Generics.bean;

import feng.util.javaUtil.Generator;

/**
 * 通用的一个生成器
 * @param <T>
 */

public class BasicGenerator <T> implements Generator<T> {
    private Class<T> type;
    public BasicGenerator (Class<T> type){
        this.type=type;
    }
    @Override
    public T next() {
        try {
            return type.newInstance();
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
    //static 类型在类加载前会被加载，需要声明泛型,该方法可以简化生成语句
    public static<T> Generator<T> create (Class<T> type){
        return  new BasicGenerator<>(type);
    }

}
