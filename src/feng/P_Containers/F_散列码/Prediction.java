package feng.P_Containers.F_散列码;

import java.util.Random;

public class Prediction {
    private static Random rand=new Random(47);
    private  boolean shadow=rand.nextDouble()>0.5;
    public String toString(){
        if(shadow)
            return "Six more weeks of Winter";
        else
            return "Early Spring!";
    }
}
