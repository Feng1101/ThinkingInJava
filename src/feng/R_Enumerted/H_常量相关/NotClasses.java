package feng.R_Enumerted.H_常量相关;

enum LikeClasses{
    WINKEN{void behavior(){
        System.out.println("Behavior 1");
    }},
    BLINKEN{
        @Override
        void behavior() {
            System.out.println("Behavior 2");
        }
    },
    NOD{
        @Override
        void behavior() {
            System.out.println("Behavior 3");
        }
    };
    abstract void behavior();
}
public class NotClasses {
//    void f1(LikeClasses.WINKEN instance){}
}
