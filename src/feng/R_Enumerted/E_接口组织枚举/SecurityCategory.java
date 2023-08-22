package feng.R_Enumerted.E_接口组织枚举;

import feng.util.javaUtil.Enums;

/**
 * 在枚举类中管理枚举,这是一种很有用的方法
 * 可以使类的管理变得非常清晰
 */
public enum SecurityCategory {
    //可以认为每一个enum中实例都是一个构造函数
    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);
    Security[] values;
    //限制类型，Food接口
    SecurityCategory(Class<? extends Security> kind){
        values=kind.getEnumConstants();
    }

    interface Security {
        enum Stock implements Security {SHORT, LONG ,MARGIN }
        enum Bond implements Security{MUNICIPAL , JUNK }
    }

    public Security randomSelection(){
        return Enums.random(values);
    }
    public Security getSecurity(String value){
        for(int i=0;i< values().length; i++){
           String s=values[i].toString();
           if(s.equals(value))
               return values[i];
        }
        return null;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            SecurityCategory category = Enums.random(SecurityCategory.class);
//            System.out.println( category+": "+category.randomSelection());
//        }
        SecurityCategory stock = STOCK;
        System.out.println(stock.randomSelection());
        System.out.println(stock.getSecurity("SHORT"));
    }

}
