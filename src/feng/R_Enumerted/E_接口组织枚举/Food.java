package feng.R_Enumerted.E_接口组织枚举;

/**
 * 通过实现接口对enum进行分类，唯一的一种方法
 */
public interface Food {
    enum Appetizer implements Food{
        SALAD, SOUP, SPRING_ROLLS;
    }
    enum MainCourse implements Food{
        LASAGNE,BURITO,PAD_THAI,LENTILS,HUMMOUS,VINDALOO;
    }
}
