package feng.R_Enumerted.E_接口组织枚举;

public class Meal {
    public static void main(String[] args) {
        for(int i=0; i< 5; i++){
            for(Course course: Course.values()){
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("---------------");
        }
    }
}
