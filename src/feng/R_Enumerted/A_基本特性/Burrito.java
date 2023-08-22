package feng.R_Enumerted.A_基本特性;

import static feng.R_Enumerted.A_基本特性.Spiciness.*;

/**
 * 使用import static 可以不带enum类的前缀直接使用名称
 */
public class Burrito {
    Spiciness degree;
    public Burrito(Spiciness degree){this.degree=degree;}
    public String toString(){return "Burrito is "+degree;}

    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));

    }
}
