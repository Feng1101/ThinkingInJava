package feng.R_Enumerted.E_接口组织枚举;

import feng.util.javaUtil.Enums;

/**
 * 获取枚举的枚举的值
 */
public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class);
    private Food[] values;
    private Course (Class<? extends Food> kind){
        values=kind.getEnumConstants();
    }
    public Food randomSelection(){
        return Enums.random(values);
    }
}
