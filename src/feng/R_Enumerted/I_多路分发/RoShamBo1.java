package feng.R_Enumerted.I_多路分发;

import java.util.Random;

public class RoShamBo1 {
    static final int SIZE=20;
    private static Random rand=new Random(47);
    public static Item newItem(){
        switch (rand.nextInt(3)){
            default:
            case 0: return new Scissors();
            case 1: return new Rock();
            case 2: return new Paper();
        }
    }

    public static  void match(Item a ,Item b){
        System.out.println(a+ " vs. "+b +": "+a.compete(b));
    }

    public static void main(String[] args) {
        for(int i=0; i< SIZE;i++){
            match(newItem(),newItem());
        }
    }
}
