package feng.R_Enumerted.D_values;

import feng.util.javaUtil.Generator;

import java.util.Random;

enum CartoonCharacter implements Generator<CartoonCharacter> {
    SLAPPY,SPANKY,PUNCHY,SILLY,BOUNCY,NUTTY,BOB;
    private Random rand = new Random(47);

    @Override
    public CartoonCharacter next() {
        return values()[rand.nextInt(values().length)];
    }
    public boolean hasNext(){
        return true;
    }
}
public class EnumImplementation {
    public static <T> void printNext(Generator<T> rg){
        System.out.println(rg.next()+" , ");
    }

    public static void main(String[] args) {
        CartoonCharacter cc = CartoonCharacter.BOB;
        for(int i=0;i<10;i++)
            printNext(cc);
    }
}
