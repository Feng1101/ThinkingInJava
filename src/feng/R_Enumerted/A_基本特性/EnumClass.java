package feng.R_Enumerted.A_基本特性;

enum Shrubbery {GROUND , CRAWLING,HANGING }
public class EnumClass {
    public static void main(String[] args) {
        for(Shrubbery s : Shrubbery.values()){
            //ordinal() enum在声明时的次序
            System.out.println(s+" ordinal: "+s.ordinal());
            System.out.println(s.compareTo(Shrubbery.CRAWLING)+" ");
            System.out.println(s.equals(Shrubbery.CRAWLING)+" ");
            System.out.println(s == Shrubbery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("-------------------------");
        }
        for(String s:"HANGING CRAWLING GROUND".split(" ")){
            Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
            System.out.println(shrubbery);
        }
    }
}
