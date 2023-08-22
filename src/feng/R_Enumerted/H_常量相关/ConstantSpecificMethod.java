package feng.R_Enumerted.H_常量相关;

import java.text.DateFormat;
import java.util.Date;

/**
 * java允许未enum编写方法，请看如何实现
 * 首先定义abstract方法， 然后在每个实例中都需要添加该方法
 * 这实现了同一个enum中每个实例都可具有不同行为，进行本质的区分
 */
public enum ConstantSpecificMethod {
    DATE_TIME{
      String getInfo(){
          return DateFormat.getDateInstance().format(new Date());
      }
    },
    CLASS_PATH{
        String getInfo(){
            return System.getenv("CLASSPATH");
        }
    },
    VERSION("version"){
        String getInfo(){
            return System.getProperty("java.version");
        }
    };
    abstract String getInfo();
    private String name;
    ConstantSpecificMethod(String name){
        this.name=name;
    }
    ConstantSpecificMethod(){
    }

    public static void main(String[] args) {
        for(ConstantSpecificMethod csm : values())
            System.out.println(csm.getInfo()+"  : "+csm.name);
    }
}
