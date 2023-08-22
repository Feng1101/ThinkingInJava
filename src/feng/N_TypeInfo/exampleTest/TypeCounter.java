package feng.N_TypeInfo.exampleTest;

import java.util.HashMap;
import java.util.Map;

/**
 * 递归查询一个类的父类及其数量，保存在自己的类中
 */
public class TypeCounter extends HashMap<Class<?>,Integer> {
    private Class<?> baseType;
    public TypeCounter(Class<?> baseType){
        this.baseType=baseType;
    }

    public void count(Object obj){
        Class<?> type=obj.getClass();
        if(!baseType.isAssignableFrom(type)){
            throw new RuntimeException(obj+" incorrect type: "+
                    type+", should be type or subtype of "+baseType);
        }
        countClass(type);
    }
    private void countClass(Class<?> type){
        Integer integer = get(type); //this.get
        put(type,integer==null?1:integer+1);
        Class<?> superClass=type.getSuperclass();
        if(superClass!=null&& baseType.isAssignableFrom(superClass)){
            countClass(superClass);
        }
    }
    public String toString(){
        StringBuilder result = new StringBuilder("{");
        for(Map.Entry<Class<?>,Integer> pair: entrySet()){
               result.append(pair.getKey().getSimpleName());
               result.append(" = ");
               result.append(pair.getValue());
               result.append(", ");
        }
        result.delete(result.length()-2,result.length());
        result.append("}");
        return  result.toString();
    }
}
