package feng.R_Enumerted.E_接口组织枚举;
import static feng.R_Enumerted.E_接口组织枚举.Food.*;

/**
 * 实现了Food接口的enum都是一个Food大类
 */
public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Appetizer.SALAD;
        food=MainCourse.BURITO;
    }
}
