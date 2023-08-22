package feng.K_HoldingObjects.test;

import feng.K_HoldingObjects.beans.Mouse;

import java.util.ArrayList;

public class T_1 {
    private  static int KEY;
    public static void main(String[] args) {
        ArrayList<Mouse> list = new ArrayList<>();
        for (int i=0;i<5;i++){
            list.add(new Mouse(KEY));
            KEY++;
            list.get(i).hop();
        }
    }
}
