package feng.O_Generics.bean;

/**
 * 工厂对象，最便利的工厂对象为Class
 * @param <T>
 */

class ClassAsFactory<T>{
    T x;
    public ClassAsFactory(Class<T> kind){
        try{
            x=kind.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

class Employee{}

public class InstantiateGenericType {
    public static void main(String[] args){
        ClassAsFactory<Employee> fe=
                new ClassAsFactory<>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeeded");
        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        }catch (Exception e){
            System.out.println("ClassAsFactory<Integer> failed");   //Integer 没有默认的构造器
        }
    }

}
